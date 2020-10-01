<template>
    <div>
        注册
    <p>
		用户名
		<input type="text" ref='username'  >
	</p>
    <p>
		密码
		<input type="text" ref='userpwd'  >
	</p>
    <p>
		姓名
		<input type="text" ref='name'  >
	</p>
    <p>
		电话号码
		<input type="text" ref='phonenumber'  >
	</p>
    <p>
		地址
		<input type="text" ref='address'  >
	</p>
    <button v-on:click="reg">注册</button>
    </div>
</template>
<script>
export default {
    name:'reg',
    data:function(){
		return {
		username:'',
		userpwd:''
		}
	},
    methods:{
	reg:function(){
		this.$axios.post('http://localhost:8081/doUserReg',{
			UserName:this.$refs.username.value,
            UserPwd:this.$refs.userpwd.value,
            Name:this.$refs.name.value,
            PhoneNumber:this.$refs.phonenumber.value,
            Address:this.$refs.address.value
			}
			).then(response=>{
			let res=response.data;
			if(res=='success'){
                alert('注册成功');
				this.$router.push('/');
			}
		}).catch(error=>{
			console.log(error);
		});
	}
	}
}
</script>