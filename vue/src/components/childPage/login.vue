<template>
  <div >




    <p>
      用户名
      <el-input v-model="log.name" placeholder="请输入内容"></el-input>
    </p>

    <p>
      密码
      <el-input v-model="log.psw" placeholder="请输入内容"></el-input>
    </p>
    <p>
      是否为管理员？
      <input type="checkbox"  ref='admin' >
    </p>
    <el-button  @click="login()">登录</el-button>
    <p><router-link to="/reg">没有账号？立即注册</router-link></p>
    <p><router-link to="/test">测试</router-link></p>
  </div>
</template>


<script>


  export default {
    name: 'login',
    data:function(){
      names:''
      return {log:
          [{
            name:'',
            psw:''
          }]

      }
    },
    methods:{
      login(){
        if(this.$refs.admin.checked){
          this.$axios.post('http://localhost:8081/doAdminLogin',{
              AdminName:this.log.name,
              AdminPwd:this.log.psw
            }
          ).then(response=>{
            let res=response.data;
            console.log(res);
            this.$router.push({
              path:'/admin',
              query:{id:res}
            });

          }).catch(error=>{
            console.log(error);
          });
        }else{
          this.$axios.post('http://localhost:8081/doUserLogin',{
              UserName:this.log.name,
              UserPwd:this.log.psw
            }
          ).then(response=>{
            let res=response.data;
            console.log(res);
            if(res=='success'){
              this.$router.push('/main');
            }
          }).catch(error=>{
            console.log(error);
          });
        }
      }
    }
  }
</script>
<style scoped>
  .el-input {
    width: auto;
  }

</style>
