<template>
  <div>
    <header>
      <admin-nav-bar v-on:change-main-component="changeMainComponent"></admin-nav-bar>
    </header>

      <component :adminINFO ="{userId : userId, apotecary_id : apotecary_id, accessToken: accessToken}" v-bind:is="component"> </component>

  </div>
    
</template>

<script>
import axios from "axios";


import AdminNavBar from "./AdminNavBar";
import AdminProfile from "@/components/Profiles/AdminProfile.vue";
import ApotecaryProfile from "@/components/Profiles/ApotecaryAdminProfile.vue";

export default {
  name: "AdminHomePage",

  props: {
    userInfo: Object
  },

components:{
  'admin-nav-bar' : AdminNavBar,

  'admin-profile' : AdminProfile,
  'apotecary-profile' : ApotecaryProfile,

},

 data(){
    return{
      userId : Number,
      apotecary_id : null,

      component: '',
      accessToken: null
    }
  },

  beforeMount() {
    this.userId = this.userInfo.userId;
    this.accessToken = this.userInfo.accessToken;

    axios.post("/api/administrator/get-apotecary-id", {id : this.userId}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
          .then((response) => {
            this.apotecary_id = response.data;
            this.component = 'apotecary-profile';
          });
    },
    

  methods: {
    changeMainComponent(value)
    {
      if(value == 'profile')
      {
        this.component = 'admin-profile';
      }
      else{
        this.component = 'apotecary-profile';
      }
    },
  }
}

</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

header{
  width: 100vw;
  background-color: #5f9ea0;
  padding: 15px;
}

</style>