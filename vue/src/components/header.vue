<template>
  <el-row>
    <el-col :span="24"><div class="grid-content bg-purple-dark">

      <h2 >自主订餐系统</h2>

    </div></el-col>
  </el-row>
    
</template>

<script>

export default {
    name:'head_name'
}
</script>
<style scoped>
  h2
  {
    color: green;  /*  #154245  */
    font-size : 40px ;
  }
.header{
    height: 10%;
    width: 100%;
    text-align: center;
}
  .el-row {
    margin-bottom: 20px;

  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 40px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
