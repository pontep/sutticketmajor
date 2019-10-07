<template>
  <div >
    <h1>
      this is a Home.
    </h1>
  </div>
</template>

<script>
import Home from '../components/Home';
import Login from '../components/Login'
export default {
  components: {
    Home,
    Login
  },
  data(){
    return{
      username: null
    }
  }
};
</script>
