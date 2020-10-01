<template>
    
     <div>
        <template class="container">
            <p>菜单</p>
            <table border="0" class="menu-main">
                <tr class="menu-item-head">
                    <th>菜名</th>
                    <th>价格</th>
                    <th>添加至购物车</th>
                </tr>
                <tr v-for="dish in dishes" :key="dish.name" class="part">
                    <td> {{dish.name }}</td>
                    <td> {{dish.price}}</td>
                    <td> <button v-on:click="addToCart(dish.name,dish.price)" class="button">+</button></td>
                </tr>
            </table>
        </template>
       <hr>

       <template>
         <el-input v-model="tprice" placeholder="请输入价格"></el-input>
         <el-input v-model="nums" placeholder="请输入数量"></el-input>
         <el-button type="primary" plain @click="bestorder(tprice,nums)">自动生成菜品</el-button>
        <!-- <el-table
           :data="bestorders"
           stripe
           :summary-method="getSummaries"
           show-summary
           style="width: 40%"
           max-height="250">
           <el-table-column
             prop="name"
             label="菜名"
             width="180">
           </el-table-column>
           <el-table-column
             prop="price"
             label="价格"
             width="180">
           </el-table-column>
           <el-table-column
             prop="star"
             label="评分">
           </el-table-column>
           <el-table-column
             fixed="right"
             label="操作"
             width="100">

             <el-button type="text" size="small" @click="addToCart(bestorders.name,bestorders.price)">加购</el-button>

           </el-table-column>
         </el-table>
         -->
         <table>
           <tr>
             <th>菜名</th>
             <th>价格</th>
             <th>评分</th>
             <th>操作</th>
           </tr>
           <tr v-for="one in bestorders" :key="one.name">
             <td>{{one.name}}</td>
             <td>{{one.price}}</td>
             <td>{{one.star}}</td>
             <td><el-button @click="addToCart(one.name,one.price)">加购</el-button></td>
           </tr>
         </table>

       </template>

       <hr>
        <template>
            <p>购物车</p>
            <table  class="cart-main">
                 <tr class="menu-item-head">
                    <th>菜名</th>
                    <th>价格</th>
                    <th>数量</th>
                </tr>
                <tr v-for="item in cart" :key="item.name" class="part">
                    <td> {{item.name }}</td>
                    <td> {{item.price}}</td>
                    <td> <button v-on:click="minunum(item)" class="button">-</button>
                    {{item.num}}
                    <button v-on:click="addnum(item)" class="button">+</button></td>

                </tr>
            </table>
            <p>总金额：{{total_price}}
              <el-button @click="submit()">提交订单</el-button></p>
        </template>

     </div>
</template>
<script>
import dishes from '@/components/childPage/dishes'
export default {
    name:'main',
    data:function(){
        return{
            dishes:[
                {
                name:'',
                price:''}
            ],
            cart:[
            ],
          bestorders: [{
              name:'',
            price:'',
            star:''
          }

          ],

          tprice:'',
          nums:'',
          total_price:0
        }
    },
created:function(){
    this.getdishes();
},
methods:{
  submit(){
    console.log(this.cart)
    this.$router.push({
      path:'/order',
      query:{
        name:this.cart
      }
    })
  },
  getSummaries(param) {
    const { columns, data } = param;
    const sums = [];
    columns.forEach((column, index) => {
      if (index === 0) {
        sums[index] = '总价';
        return;
      }
      const values = data.map(item => Number(item[column.property]));
      if (!values.every(value => isNaN(value))) {
        sums[index] = values.reduce((prev, curr) => {
          const value = Number(curr);
          if (!isNaN(value)) {
            return prev + curr;
          } else {
            return prev;
          }
        }, 0);
        sums[index] = ' 总计'+sums[index];
      } else {
        sums[index] = 'N/A';
      }
    });

    return sums;
  },

    getdishes(){
        this.$axios.get('http://localhost:8081/getDishes'
			).then(response=>{
            this.dishes=response.data;
		}).catch(error=>{
			console.log(error);
		});
},
addToCart(name,price){
 let dish_select={
     name:name,
     price:price,
     num:1
 }
 if(this.cart.length>0){
     /*result    判断即将添加至购物车的dish是否存在于购物车中  通过name判断 */
 let result =this.cart.filter((dish)=>{
    return  (dish.name===name)
});
if(result.length>0&&result!=null){
    result.forEach((value)=>{
        value.num++;
    })
}else{
    this.cart.push(dish_select);
}
 }else{
     this.cart.push(dish_select);
 }
this.total_price+=price;
},
addnum(item){
 item.num++;
 this.total_price+=item.price;
},
minunum(item){
 item.num--;
 this.total_price-=item.price;
},
submit(){
this.$router.push("/order")
},
bestorder(tprice,nums){
  this.$axios.post('http://localhost:8081/bestOrder',{
    Id:this.tprice,
    Num:this.nums,
  }).then(response=>{
    this.bestorders=response.data;

  }).catch(error=>{
    console.log(error);
  });
}
}
}
</script>

<style scoped >
  .el-input {
    width: auto;
  }
    .container{
        text-align: center;
        width: 80%;
        height: 80%;
        background-color: #8EE5EE;
    }
  .menu-main{
    width: 40%;
  }
  .cart-main{
      width: 40%;
  }
  .menu-item{
      text-align: center;
      border-bottom: 1px solid ;
      padding: 10px 0;
      font-size: 14px;
      color: #696969;
  }
  .menu-item-head{
      font-size: 15px;
      color: #000;
    }
    .button{
        display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #fff;
    border: 1px solid #dcdfe6;
    color: #62D2CE;
    -webkit-appearance: none;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    outline: 0;
    margin: 0;
    -webkit-transition: .1s;
    transition: .1s;
    padding: 5px 10px;
    font-size: 14px;
    border-radius: 4px;
}
.part{
    text-align: center;
}
.footer{
    height: 10%;

}

    
</style>
