<template>
    <div>
        <head_name/>
        <router-view></router-view>
    </div>

</template>
<script>
import head_name from './header.vue'
import login from './childPage/login.vue'
export default {
 name:'home',
components:{
    head_name,
}
}

</script>