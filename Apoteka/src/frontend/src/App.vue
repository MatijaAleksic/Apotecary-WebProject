<template >
  <!--Navbar -->
  <nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color">
    <a class="navbar-brand" href="#">Apothecary</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
             aria-haspopup="true" aria-expanded="false">Dropdown
          </a>
          <div class="dropdown-menu dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto nav-flex-icons">
        <li class="nav-item">
          <a class="nav-link waves-effect waves-light">
            <i class="fab fa-twitter"></i>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link waves-effect waves-light">
            <i class="fab fa-google-plus-g"></i>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
             aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right dropdown-default"
               aria-labelledby="navbarDropdownMenuLink-333">
            <a class="dropdown-item" v-if="logged_user == ''" v-on:click="component='login'">Login</a>
            <a class="dropdown-item" v-if="logged_user == ''" v-on:click="component ='register-patient'">Register</a>
            <a class="dropdown-item" v-if="logged_user != ''" v-on:click="logout">Logout</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <!--/.Navbar -->
  <div>
    <home-page v-if="logged_user =='pharmacist' && this.first_time_login == 'false' "></home-page>
    <admin-homepage v-if="logged_user == 'administrator' && this.first_time_login == 'false'"> </admin-homepage>
    <dermatologist-homepage v-if="logged_user == 'dermatologist' && this.first_time_login == 'false'"> </dermatologist-homepage>
    <patient-homepage v-if="logged_user == 'patient' && this.first_time_login == 'false'"> </patient-homepage>

    
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
import FirstLogIn from "./components/FirstLogIn.vue";
import DermatologistHomePage from "@/components/Dermatologist/DermatologistHomePage.vue";
import PatientHomePage from "@/components/Patient/PatientHomePage";
import PatientProfileCard from "@/components/Patient/PatientProfileCard";

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
    'first-login' : FirstLogIn,
    'dermatologist-homepage' : DermatologistHomePage,
    'patient-homepage':PatientHomePage,
    'patient-profile':PatientProfileCard
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
