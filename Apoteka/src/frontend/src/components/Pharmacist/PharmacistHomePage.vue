<template>
  <div id="container"><div id="container-inner">
    <form >
      <fieldset style="border:white">
        <!-- Controls -->
        <div class="btn-group">
          <div>
            <input id="clientList" name="clientList" type="button" @click="clientList" value="Client List" />
          </div>
          <div>
            <input id="counselling" name="counselling" type="button" @click="counselling" value="Counselling" />
          </div>
          <div >
            <input id="calendar" name="calendar" type="button" @click="calendar" value="Calendar" />
          </div>
          <div>
            <input id="drugs" name="drugs" type="button" @click="drugs" value="Drugs" />
          </div>
          <div>
            <input id="vacation" name="vacation" type="button" @click="vacation" value="Vacation" />
          </div>
          <div>
            <input id="profile" type="button" name="profile" @click="component ='pharmacist-profile'" value="User Profile" />
          </div>
          <div>
            <input id="orderNew" name="orderNew" type="button" @click="orderNew" value="Order New Counselling" />
          </div>
          <div>
            <h1>{{ msg }}</h1>
          </div>
        </div>
      </fieldset>
    </form>

  </div></div>
  <component v-bind:is="component"> </component>
</template>
<style>
  .btn-group{
    margin: auto;
    display: flex;
    flex-direction: row;
    justify-content: center;
    border: white;

  }
  .btn-group input {
    background-color: #5f9ea0; /* Green background */
    border: 1px solid white; /* Green border */
    color: white; /* White text */
    padding: 15px 30px; /* Some padding */
    cursor: pointer; /* Pointer/hand icon */
    float: left; /* Float the buttons side by side */
    border-radius: 8px;

  }

  .btn-group button:not(:last-child) {
    border-right: none; /* Prevent double borders */
  }

  /* Clear floats (clearfix hack) */
  .btn-group:after {
    content: "";
    clear: both;
    display: table;
  }

  /* Add a background color on hover */
  .btn-group button:hover {
    background-color: #3e8e41;
  }
</style>
<script>
import axios from "axios";
import PharmacistProfilPage from "@/components/Pharmacist/PharmacistProfilPage";
export default {
  name: "PharmacistHomePage",
  components: {
    'pharmacist-profile': PharmacistProfilPage,
  },
  data(){
    return{
      component:null,
    }
  },
  methods:{
    clientList(){
      axios.post("/api/pharmacist/client-list")
          .then((response) => {
            this.msg = response.data;
          });
    },
    counselling(){
      axios.post("/api/pharmacist/counselling")
          .then((response) => {
            this.msg = response.data;
          });
    },
    calendar(){
      axios.post("/api/pharmacist/calendar")
          .then((response) => {
            this.msg = response.data;
          });
    },
    drugs(){
      axios.post("/api/pharmacist/drugs")
          .then((response) => {
            this.msg = response.data;
          });
    },
    vacation(){
      axios.post("/api/pharmacist/vacation")
          .then((response) => {
            this.msg = response.data;
          });
    },
    profile(){
      axios.post("/api/pharmacist/profile")
          .then((response) => {
            this.msg = response.data;
          });
    },
    orderNew(){
      axios.post("/api/pharmacist/orderNew")
          .then((response) => {
            this.msg = response.data;
          });
    },
  }
}
</script>

<style scoped>

</style>