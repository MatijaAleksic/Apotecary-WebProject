<template>
  <h3> Patient Table </h3>

  <input type="text" v-model="searchFirstname" placeholder="Firstname"/>
  <input type="text" v-model="searchLastname" placeholder="Lastname"/>

  <table>
    <tr bgcolor='lightgrey'>
      <th><div @click="sortBy('name')" class="sortBy">Firstname</div></th>
      <th><div @click="sortBy('lastName')" class="sortBy">Lastname</div></th>
      <th><div @click="sortBy('address')" class="sortBy">Address</div></th>
      <th><div @click="sortBy('city')" class="sortBy">City</div></th>
      <th><div @click="sortBy('country')" class="sortBy">Country</div></th>
      <th><div @click="sortBy('phone')" class="sortBy">Phone</div></th>
    </tr>

    <tr v-for="patient in fillteredPharmacist"  v-bind:key="patient.id">
      <!-- v-on:click="selectPharmacist(p)" -->
      <td> {{patient.name}}</td>
      <td> {{patient.lastName}}</td>
      <td> {{patient.address}}</td>
      <td> {{patient.city}}</td>
      <td> {{patient.country}}</td>
      <td> {{patient.phone}}</td>
    </tr>
  </table>
  <div>
    <h5>{{ msg }}</h5>
  </div>
</template>

<script>


import axios from "axios";
export default {
  name: "PharmacistPatientTable",

  data(){
    return{
      patients : [],

      mode: "BROWSE",
      selectedPharmacist: {},
      searchField: "",

      searchFirstname: "",
      searchLastname: "",

      apotecary_id : null,
      userId : null,

      msg: ""
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
    this.apotecary_id = this.adminINF.apotecary_id;
    this.userId = this.adminINF.userId;

    alert(this.userId);

    axios.post("/api/pharmacist/view-patients", {id :this.userId})
        .then(response => {
          this.patients = response.data;
        })

  },

  methods: {


    refresh(){
      axios.post("/api/pharmacist/view-patients", {id : 19})
          .then(response => {
            this.patients = response.data;
          })
    }
  },

  computed: {
    fillteredPharmacist: function() {
      return this.patients.filter( (elem) => {
        return elem.name.match(this.searchFirstname) && elem.lastName.match(this.searchLastname)
      });
    }
  }
}
</script>

<style scoped>
</style>