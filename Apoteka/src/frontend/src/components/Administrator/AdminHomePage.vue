<template>
  <div>
      <div >
        <h1>Admin homepage</h1>
        <button v-on:click="component ='change-information'">Change Personal Information</button>
        <button v-on:click="component ='change-password'">Change Password</button>
        <button v-on:click="component ='add-new-medication'">Add new medication</button>
        <button v-on:click="component ='register-new-administrator'">Register new Administrator</button>
      </div>
      <component v-bind:is="component"> </component>
    </div>
    
</template>

<script>
//import axios from "axios";

import ChangePersonalInformation from './ChangeInformationAdministrator.vue'
import ChangeAdminPassword from './ChangeAdminPassword.vue'
import AddNewMedication from './AddNewMedication.vue'
import AddNewAdministrator from './AddNewAdministrator.vue'


export default {
  name: "AdminHomePage",

components:{
  'change-information' : ChangePersonalInformation,
  'change-password': ChangeAdminPassword,
  'add-new-medication': AddNewMedication,
  'register-new-administrator' : AddNewAdministrator
},

 data(){
    return{
      component:null,
    }
  },

}
</script>

<style scoped>

</style>