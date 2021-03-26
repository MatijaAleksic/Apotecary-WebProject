<template>
  <div>
    <component v-bind:is="component"> </component>

    <button v-on:click="component ='register-dermatologist'">Register Dermathologist</button>
    <button v-on:click="component ='change-password'">Change Password Dermatologist</button>
    <button v-on:click="component ='change-password-pharm'">Change Password Pharmacist</button>
    <button v-on:click="component ='change-information'">Change Information</button>


  </div>
  <div>
        <button v-on:click="component ='null'">Close</button>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import RegisterDermatologist from './components/RegisterDermatologist.vue'
import changePassword from "@/components/changePassword";
import ChangeInformation from "@/components/ChangeInformation";
import changePasswordPharmacist from "@/components/changePasswordPharmacist"

export default {
  name: 'App',

  components: {
    //HelloWorld
    'register-dermatologist' : RegisterDermatologist,
    'change-password': changePassword,
    'change-information': ChangeInformation,
    'change-password-pharm': changePasswordPharmacist
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
