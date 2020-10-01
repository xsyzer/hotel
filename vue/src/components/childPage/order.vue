<template xmlns:v-on="http://www.w3.org/1999/xhtml">
  <div  class="order">
    <p> 下单成功，祝您用餐愉快！</p>
    <p> {{this.$route.query.name}}</p>
    <table  class="cart-main">
      <tr class="menu-item-head">
        <th>菜名</th>
        <th>评分</th>
        <th>提交</th>

      </tr>
      <tr v-for="item in order" :key="item.name" class="part">
        <td> {{item.name}}</td>
        <td> <input type="text" v-model="score" placeholder="满分为5.0分"></td>
        <td><button v-on:click="submit(item)" class="button">提交评价</button></td>
      </tr>
      <p><button v-on:click="back()" class="button">返回主界面</button></p>
    </table>
  </div>
</template>
<script>
  export default {
    name:'order',
    data:function(){
      return {
        order:[],
        score:''
      }
    },
    created:function(){
      this.order=this.$route.query.name;
    },
    methods:{
      submit(item){
        this.$axios.post('http://localhost:8081/doStarUpdate',{
            name:item.name,
            score:this.score
          }
        ).then(response=>{
          let res=response.data;
          if(res=='success'){
            alert('评价提交成功');
          }
        }).catch(error=>{
          console.log(error);
        });

      },
      back(){
        this.$router.push('/main');
      }
    }
  }
</script>
<style scoped>
  .order{
    text-align: center;
    size: 20px;
  }
</style>
