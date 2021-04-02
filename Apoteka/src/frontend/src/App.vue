<template>
  <div>
    <component v-bind:is="component"> </component>

    <button v-on:click="component ='register-dermatologist'">Register Dermathologist</button>
    <button v-on:click="component ='change-password'">Change Password</button>
    <button v-on:click="component ='change-information'">Change Information</button>
    <button v-on:click="component ='search-dermatologist'">Search Dermatologist</button>


  </div>
  <div>
        <button v-on:click="component ='null'">Close</button>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import RegisterDermatologist from './components/RegisterDermatologist.vue'
import changePassword from "@/components/changePassword.vue";
import ChangeInformation from "@/components/ChangeInformation.vue";
import SearchDermatologist from "@/components/SearchDermatologist.vue";

export default {
  name: 'App',

  components: {
    //HelloWorld
    'register-dermatologist' : RegisterDermatologist,
    'change-password': changePassword,
    'change-information': ChangeInformation,
    'search-dermatologist': SearchDermatologist,
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
