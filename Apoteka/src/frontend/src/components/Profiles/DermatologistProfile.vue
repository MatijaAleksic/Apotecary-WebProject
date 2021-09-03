<template>
  <div>
    <form>
      <h1>Personal Information</h1>
      <div>
        <label class="personal"> <h4>First Name:</h4>  {{firstname}} </label>
      </div>
      <div>
        <label  class="personal"> <h4>Last Name:</h4>         {{lastname}} </label>
      </div>
      <div>
        <label  class="personal"><h4>Username:</h4>          {{username}} </label>
      </div>
      <div>
        <label  class="personal"><h4>Email:</h4>         {{email}} </label>
      </div>
      <div>
        <label  class="personal"><h4>Address:</h4>           {{adress}} </label>
      </div>
      <div>
        <label  class="personal"><h4>City:</h4>          {{city}} </label>
      </div>
      <div>
        <label  class="personal"><h4>Country:</h4>           {{country}} </label>
      </div>
      <div>
        <label  class="personal"><h4>Phone:</h4>  {{phone}} </label>
      </div>
    </form>

    <v-btn v-on:click="component ='change-information'">Change Personal Information</v-btn>
    <v-btn v-on:click="component ='change-password'">Change Password</v-btn>

    <component v-on:refresh-component="refreshComponent" :adminINF ="{userId : userId, apotecary_id : apotecary_id, accessToken: this.accessToken}" v-bind:is="component"> </component>
  </div>
</template>

<script>

import ChangeInformationDermatologist from "@/components/Dermatologist/ChangeInformationDermatologist";
import ChangePasswordDermatologist from "@/components/Dermatologist/ChangePasswordDermatologist";
import axios from "axios";

export default {
  name: "DermatologistProfile",
  props: {
    adminINF: Object
  },

  components:{
    'change-information' : ChangeInformationDermatologist,
    'change-password' : ChangePasswordDermatologist,
  },

  data(){
    return{
      firstname: null,
      lastname: null,
      username: null,
      email: null,
      adress: null,
      city: null,
      country: null,
      phone: null,

      component: null,

      userId : Number,
      apotecary_id : null,
      accessToken: null
    }
  },

  mounted() {
    this.userId = this.adminINF.userId;
    this.apotecary_id = this.adminINF.apotecary_id;
    this.accessToken = this.adminINF.accessToken;

    axios.post("/api/dermatologist/get-personal-info", {id : this.userId},
        {
          headers: {
            'Authorization': `Bearer ${this.accessToken}`
          },
        })
        .then(response => {
          this.firstname = response.data.firstname;
          this.lastname= response.data.lastname;
          this.username= response.data.username;
          this.email= response.data.email;
          this.adress= response.data.adress;
          this.city= response.data.city;
          this.country= response.data.country;
          this.phone= response.data.phone;
        })
  },

  methods: {

    refresh(){
      axios.post("/api/dermatologist/get-personal-info", {id : this.userId}
          ,
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then(response => {
            this.firstname = response.data.firstname;
            this.lastname= response.data.lastname;
            this.username= response.data.username;
            this.email= response.data.email;
            this.adress= response.data.adress;
            this.city= response.data.city;
            this.country= response.data.country;
            this.phone= response.data.phone;

            this.refresh();
          })
    },

    refreshComponent(){
      this.component = null;
      this.refresh();
    }


  },
}
</script>

<style scoped>

label{
  font-size: 18px;
  height: 50px;
  width: 300px;
  padding: 20px 20px;
  justify-content: left;
  display: inline-block;
  text-align: left;
  color: Black;
}

label h4 {
  margin: 8px 5px;
  text-align: left;
  justify-content: left;
  display: inline-block;
  box-sizing: border-box;
}

form {
  margin: 10px 10px;
}
</style>