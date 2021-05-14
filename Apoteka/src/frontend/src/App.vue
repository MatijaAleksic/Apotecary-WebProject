<template >
  <div>
    <div style="background-color: #5f9ea0; height: 20% "></div>
    <div style="background-color: cadetblue; height: 80px; border-radius: 8px;">
      <div>
        <h1 style="font-family: sans-serif; color: white; position:absolute; left: 40px;">A p o t e k a</h1>
        <button  v-if="logged_user == ''" v-on:click="component ='login'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:110px">Login</button>
        <button  v-if="logged_user == ''" v-on:click="component ='register-patient'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Register</button>
        <button v-if="logged_user != ''" v-on:click="logout" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Logout</button>
      </div>
    </div>
    <home-page v-if="logged_user =='pharmacist' && this.first_time_login == 'false' "></home-page>
    <admin-homepage v-if="logged_user == 'administrator' && this.first_time_login == 'false'"> </admin-homepage>
    <first-login :userInfo ="{ logged_user : this.logged_user, userId : this.user_id }" v-if="logged_user != '' && this.first_time_login == 'true'" v-on:updateinfo="updateInformation"></first-login>

    <component v-bind:is="component"  v-on:update-logged-user="updatLoggedUser"> </component>

  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import RegisterDermatologist from './components/RegisterDermatologist.vue'
import changePassword from "@/components/changePassword.vue";
import ChangeInformation from "@/components/ChangeInformation.vue";
import SearchDermatologist from "@/components/SearchDermatologist.vue";
import LoginForm from "@/components/LoginForm";
import RegisterPatientForm from "@/components/RegisterPatientForm";
import HomePage from "@/components/Pharmacist/HomePage";
import AdminHomePage from "@/components/Administrator/AdminHomePage";
import FirstLogIn from "./components/FirstLogIn.vue"

export default {
  name: 'App',

  components: {
    'register-dermatologist' : RegisterDermatologist,
    'change-password': changePassword,
    'change-information': ChangeInformation,
    'search-dermatologist': SearchDermatologist,
    'login': LoginForm,
    'register-patient' : RegisterPatientForm,
    'home-page': HomePage,
    'admin-homepage': AdminHomePage,
    'first-login' : FirstLogIn
  },

  data(){
    return{
      component: '',
      logged_user : '',
      first_time_login: 'false',
      user_id : null
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
      this.logged_user = ''
    },
  },
}
</script>

<style>

</style>
