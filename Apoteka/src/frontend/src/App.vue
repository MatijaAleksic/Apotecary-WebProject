<template >
  <div>
    <div style="background-color: #5f9ea0; height: 20% "></div>
    <div style="background-color: cadetblue; height: 80px;">
      <div>
        <h1 @click="homePage()" style="font-family: sans-serif; color: white; position:absolute; left: 40px; top: 10px;">A p o t e k a</h1>
        <button  v-if="logged_user == ''" v-on:click="component ='login'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:110px">Login</button>
        <button  v-if="logged_user == ''" v-on:click="component ='register-patient'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Register</button>
        <button v-if="logged_user != ''" v-on:click="logout" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Logout</button>
      </div>
    </div>

    <pharmacist-homepage :userInfo ="{userId : this.user_id}" v-if="logged_user =='pharmacist' && this.first_time_login == 'false' "></pharmacist-homepage>
    <admin-homepage :userInfo ="{userId : this.user_id}" v-if="logged_user == 'administrator' && this.first_time_login == 'false'"> </admin-homepage>
    <dermatologist-homepage :userInfo ="{userId : this.user_id}" v-if="logged_user == 'dermatologist' && this.first_time_login == 'false'"></dermatologist-homepage>
    <patient-homepage v-if="logged_user == 'patient' && this.first_time_login == 'false'"> </patient-homepage>

    <first-login :userInfo ="{ logged_user : this.logged_user, userId : this.user_id }" v-if="logged_user != '' && this.first_time_login == 'true'" v-on:updateinfo="updateInformation"></first-login>

    <apotecary-table v-if="logged_user == '' && this.component == '' && this.selectedApotecary == ''" v-on:selected-apotecary="selectApotecary"> </apotecary-table>
    <unsigned-medication-table v-if="logged_user == '' && this.component == '' && this.selectedApotecary != ''" :apotecaryID ="{apotecary_id : this.selectedApotecary}"> </unsigned-medication-table>

    <component v-bind:is="component"  v-on:update-logged-user="updatLoggedUser" > </component>


  </div>
</template>

<script>
import LoginForm from "./components/Unsigned/LoginForm.vue";
import RegisterPatientForm from "./components/Unsigned/RegisterPatientForm.vue";
import FirstLogIn from "./components/Unsigned/FirstLogIn.vue";
import PharmacistHomePage from "@/components/Pharmacist/PharmacistHomePage";
import AdminHomePage from "@/components/Administrator/AdminHomePage";
import PatientHomePage from "@/components/Patient/PatientHomePage";
import PatientProfileCard from "@/components/Patient/PatientProfileCard";
import NewDermatologistHomePage from "@/components/Dermatologist/NewDermatologistHomePage";
import ApotecaryTable from "@/components/Tables/ApotecaryTable";
import UnsignedMedicationTable from "@/components/Tables/UnsignedMedicationTable";

import Calendar from "@/components/Calendar"

export default {
  name: 'App',
  components: {
    'login': LoginForm,
    'register-patient' : RegisterPatientForm,
    'first-login' : FirstLogIn,
    'pharmacist-homepage': PharmacistHomePage,
    'admin-homepage': AdminHomePage,
    'dermatologist-homepage' : NewDermatologistHomePage,
    'patient-homepage':PatientHomePage,
    'apotecary-table' : ApotecaryTable,
    'unsigned-medication-table':UnsignedMedicationTable,
    'patient-profile':PatientProfileCard,

    'calendar' : Calendar,
    Calendar
  },
  data(){
    return{
      component: '',
      logged_user : '', //'administrator', //'',
      first_time_login: 'false',
      user_id : null,
      selectedApotecary : '',
    }
  },
  methods: {
    updatLoggedUser (value) {
      this.logged_user = value.userType;
      this.first_time_login = value.firstTimeLogin;
      this.user_id = value.userId;
      this.component = null;
    },
    updateInformation(value){
      this.first_time_login = value;
    },
    logout()
    {
      this.component= ''
      this.selectedApotecary=''
      this.logged_user = ''
    },
    selectApotecary(value)
    {
      this.selectedApotecary = value;
    },
    homePage(){
      this.component = '';
      this.selectedApotecary = '';
    }
  },
}
</script>

<style>
</style>