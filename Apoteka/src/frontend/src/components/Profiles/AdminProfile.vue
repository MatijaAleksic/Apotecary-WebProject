<template>
    
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

    <button v-on:click="component ='change-information'">Change Personal Information</button>
    <button v-on:click="component ='change-password'">Change Password</button>

    <component v-on:refresh-component="refreshComponent" :adminINF ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>

</template>

<script>

import ChangePersonalInformation from '@/components/Administrator/ChangeInformationAdministrator.vue'
import ChangeAdminPassword from '@/components/Administrator/ChangeAdminPassword.vue'
import axios from "axios";


export default {
  name: "AdminProfile",

    props: {
        adminINFO: Object
    },

  components:{
  'change-information' : ChangePersonalInformation,
  'change-password' : ChangeAdminPassword,
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
    }
  },

  mounted() {
    this.userId = this.adminINFO.userId;
    this.apotecary_id = this.adminINFO.apotecary_id;

    axios.post("/api/administrator/get-personal-info", {id : this.userId})
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
            axios.post("/api/administrator/get-personal-info", {id : this.userId})
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