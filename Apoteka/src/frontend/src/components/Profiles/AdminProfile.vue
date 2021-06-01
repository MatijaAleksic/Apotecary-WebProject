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

    <component :adminINF ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>

</template>

<script>

import ChangePersonalInformation from '@/components/Administrator/ChangeInformationAdministrator.vue'
import ChangeAdminPassword from '@/components/Administrator/ChangeAdminPassword.vue'
// import AdminPharmacistTable from '@/components/Tables/AdminPharmacistTable.vue'

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
      firstname: 'firstname',
      lastname: 'lastname',
      username: 'username',
      email: 'email',
      adress: 'adress',
      city: 'city',
      country: 'country',
      phone: 'phone',

      component: null,

      userId : Number,
      apotecary_id : null,
    }
  },

  mounted() {
    this.userId = this.adminINFO.userId;
    this.apotecary_id = this.adminINFO.apotecary_id;
    }
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