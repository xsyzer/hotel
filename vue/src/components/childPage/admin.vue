<template>
  <div>
    <h3>菜品管理</h3>
      <!--<el-table
        :data="lists"
        border
        style="width: 60%">
        <el-table-column
          prop="id"
          label="ID"
          width="100">
        </el-table-column>
        <el-table-column
          prop="name"
          label="菜名"
          width="100">
        </el-table-column>
        <el-table-column
          prop="price"
          label="价格"
          width="100">
        </el-table-column>
        <el-table-column
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="edit1(id,name,price)">编辑</el-button>
            <el-button @click="del(lists)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      -->
    <table>
      <tr >
        <td width="50">ID</td>
        <td width="150">菜名</td>
        <td width="100">价格</td>
        <td width="250" align="center">操作</td>
      </tr>
      <tr v-for="list in lists " :key="list.name" >
        <td >{{list.id}}</td>
        <td >{{list.name}}</td>
        <td >{{list.price}}</td>
        <td  >
            <el-button @click="edit(list)">编辑</el-button>
            <el-button @click="del(list)">删除</el-button>
        </td>
      </tr>
    </table >
            <table  >
                 <tr >
                    <th>ID</th>
                    <th>菜名</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td> </td>
                    <td> <input  type="text"  ref='name'></td>
                    <td> <input  type="text" ref='price'></td>
                    <td> 
                        <el-button @click="add()" class="button">新增</el-button>
                    </td>
                </tr>
                <tr v-for="item in editing" :key="item.name" class="part">
                  <td> <input  v-model="item.id" ></td>
                  <td> <input  v-model="item.name" ></td>
                  <td> <input  v-model="item.price" ></td>
                    <td> 
                        <el-button @click="update(item)" class="button">提交</el-button>
                    </td>
                </tr>
            </table>
  </div>
</template>
<script>
  export default {

    name:'admin',
    data: function () {
      return{
        lists:[
          {
            id:'1',
            name:'1',
            price:'1'
          }
        ],
        editing:[],

      }
    },
    created:function(){
        this.getAdminDish();
    },
    methods:{
      getAdminDish(){
          this.$axios.post('http://localhost:8081/getAdminDish',{
            id:this.$route.query.id
          }).then(response=>{
              this.lists=response.data;
          }).catch(error=>{
			console.log(error);
		});
      },
      edit(list){
          this.editing.push(list);
      },
      edit1(list){
        this.editing.push(id,name,price);
      },
      del(list){
        this.$axios.post('http://localhost:8081/doDishDelete',{
            id:list.id
          }).then(response=>{
              if(response.data=='success'){
                  alert('删除成功');
              }
          }).catch(error=>{
			console.log(error);
		});
      },
      update(item){
          this.$axios.post('http://localhost:8081/doDishUpdate',{
            id:  item.id,
            name:item.name,
            price:item.price
          }).then(response=>{
              if(response.data=='success'){
                  alert('修改成功');
              }
          }).catch(error=>{
			console.log(error);
		});
      },
      add(){
         this.$axios.post('http://localhost:8081/doDishAdd',{
            adminid:this.$route.query.id,
            name:this.$refs.name.value,
            price:this.$refs.price.value
          }).then(response=>{
              if(response.data=='success'){
                  alert('修改成功');
              }
          }).catch(error=>{
			console.log(error);
		});
      }

  }
  }
</script>
<style>
  h3
  {
    color: orangered;  /*  #154245  */
    font-size : 30px ;
  }
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: left;
    line-height: 30px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 140px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 80px;
  }

  body > .el-container {
    margin-bottom: 30px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 150px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 150px;
  }
</style>
