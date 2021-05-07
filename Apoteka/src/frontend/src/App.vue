<template>
  <div>
    <div style="background-color: cadetblue; height: 20% "></div>
    <div style="background-color: cadetblue; height: 80px; border-radius: 8px;">
      <div >
        <h1 style="font-family: sans-serif; color: white; position:absolute; left: 40px;">A p o t e k a</h1>
        <button v-if="logged_user == ''" v-on:click="component ='login'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:110px"  @userlogged="updateUser">Login</button>
        <button  v-if="logged_user == ''" v-on:click="component ='register-patient'" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Register</button>
        <button v-if="logged_user != ''" v-on:click="logout" style="height: 50px; width: 80px; background: azure; border-radius: 8px; margin: 5px; position: absolute; top:15px; right:20px">Logout</button>
      </div>
    </div>
    <home-page v-if="logged_user =='pharmacist' && isHidden"></home-page>
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
import RegisterPatientForm from "@/components/RegisterPatientForm";
import HomePage from "@/components/Pharmacist/HomePage";

export default {
  name: 'App',

  components: {
    //HelloWorld
    'register-dermatologist' : RegisterDermatologist,
    'change-password': changePassword,
    'change-information': ChangeInformation,
    'search-dermatologist': SearchDermatologist,
    'login': LoginForm,
    'register-patient' : RegisterPatientForm,
    'home-page': HomePage
  },

  data(){
    return{
      component:null,
      logged_user : 'pharmacist',
      isHidden : true
    }
  },

  methods: {
    // swapComponents : function(component)
    // {
    //   this.currentComponent = component;
    // }
    updateUser (value) {
      alert('hello')
      alert(value); // someValue
      this.logged_user = value;
    },

    logout()
    {
      this.logged_user = ''
    }
  },
}
</script>

<style>

</style>
