<template>
  <div>
    <div style="background-color: cadetblue; height: 20% "></div>
    <div style="background-color: cadetblue; height: 80px; border-radius: 8px;">
      <div>
        <h1 style="font-family: sans-serif; color: white; position:absolute; left: 40px;">A p o t e k a</h1>
        <button v-on:click="component ='login'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:110px">Login</button>
        <button type="submit" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:10px">Register</button>
      </div>
    </div>
    <component v-bind:is="component"> </component>

  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import RegisterDermatologist from './components/RegisterDermatologist.vue'
import changePassword from "@/components/changePassword.vue";
import ChangeInformation from "@/components/ChangeInformation.vue";
import SearchDermatologist from "@/components/SearchDermatologist.vue";
import LoginForm from "@/components/LoginForm";

export default {
  name: 'App',

  components: {
    //HelloWorld
    'register-dermatologist' : RegisterDermatologist,
    'change-password': changePassword,
    'change-information': ChangeInformation,
    'search-dermatologist': SearchDermatologist,
    'login': LoginForm
  },

  data(){
    return{
      component:null
    }
  }

  // methods: {
  //   swapComponents : function(component)
  //   {
  //     this.currentComponent = component;
  //   }
  // }
}
</script>

<style>

</style>
