<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form >
      <fieldset>
        <!-- Controls -->
        <div class="controls">
          <input id="clientList" name="clientList" type="button" @click="clientList" value="Client List" />
        </div>
        <div class="controls">
          <input id="counselling" name="counselling" type="button" @click="counselling" value="Counselling" />
        </div>
        <div class="controls">
          <input id="calendar" name="calendar" type="button" @click="calendar" value="Calendar" />
        </div>
        <div class="controls">
          <input id="drugs" name="drugs" type="button" @click="drugs" value="Drugs" />
        </div>
        <div class="controls">
          <input id="vacation" name="vacation" type="button" @click="vacation" value="Vacation" />
        </div>
        <div class="controls">
          <input id="profile" name="profile" type="button" @click="profile" value="User Profile" />
        </div>
        <div class="controls">
          <input id="orderNew" name="orderNew" type="button" @click="orderNew" value="Order New Counselling" />
        </div>
        <div>
          <h1>{{ msg }}</h1>
        </div>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import axios from "axios";

export default {
  name: "HomePage",
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