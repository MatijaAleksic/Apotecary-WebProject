<template>
  <div>
      <div >
        <h1>Admin homepage</h1>
        <button v-on:click="component ='change-information'">Change Personal Information</button>
        <button v-on:click="component ='change-password'">Change Password</button>
        <button v-on:click="component ='add-new-medication'">Add new Medication</button> 
        <button v-on:click="component ='register-new-administrator'">Register new Administrator</button>
        <button v-on:click="component ='register-new-dermatologist'">Register new Dermatologist</button>
        <button v-on:click="component ='register-new-pharmacist'">Register new Pharmacist</button>
        <button v-on:click="component ='pharmacist-table'">Pharmacist Table</button>
        <button v-on:click="component ='dermatologist-table'">Dermatologist Table</button>
      </div>
      <component :user_id ="userId" v-bind:is="component"> </component>
    </div>
    
</template>

<script>
//import axios from "axios";

import ChangePersonalInformation from './ChangeInformationAdministrator.vue'
import ChangeAdminPassword from './ChangeAdminPassword.vue'
import AddNewMedication from './AddNewMedication.vue'
import AddNewAdministrator from './AddNewAdministrator.vue'
import AddNewDermatologist from './AddNewDermatologist.vue'
import AddNewPharmacist from './AddNewPharmacist.vue'
import PharmacistTable from '@/components/Tables/PharmacistTable.vue'
import DermatologistTable from '@/components/Tables/DermatologistTable.vue'


export default {
  name: "AdminHomePage",

  props: {
    userInfo: Object
  },

components:{
  'change-information' : ChangePersonalInformation,
  'change-password': ChangeAdminPassword,
  'add-new-medication': AddNewMedication,
  'register-new-administrator' : AddNewAdministrator,
  'register-new-dermatologist' : AddNewDermatologist,
  'register-new-pharmacist' : AddNewPharmacist,
  'pharmacist-table' : PharmacistTable,
  'dermatologist-table' : DermatologistTable
},

 data(){
    return{
      userId : Number,

      component:null,
    }
  },

  mounted() {
    this.userId = this.userInfo.userId;
    }
}

</script>

<style scoped>

</style>