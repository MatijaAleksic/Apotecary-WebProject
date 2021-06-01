<template>
  <h3> Patient Table </h3>

  <input type="text" v-model="searchFirstname" placeholder="Firstname"/>
  <input type="text" v-model="searchLastname" placeholder="Lastname"/>

  <table>
    <tr bgcolor='lightgrey'>
      <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
      <th><div @click="sortBy('name')" class="sortBy">Firstname</div></th>
      <th><div @click="sortBy('lastName')" class="sortBy">Lastname</div></th>
      <th><div @click="sortBy('address')" class="sortBy">Address</div></th>
      <th><div @click="sortBy('city')" class="sortBy">City</div></th>
      <th><div @click="sortBy('country')" class="sortBy">Country</div></th>
      <th><div @click="sortBy('phone')" class="sortBy">Phone</div></th>
    </tr>

    <tr v-for="patient in fillteredDermatologist"  v-bind:key="patient.id">
      <!-- v-on:click="selectPharmacist(p)" -->
      <td> {{patient.id}}</td>
      <td> {{patient.name}}</td>
      <td> {{patient.lastName}}</td>
      <td> {{patient.address}}</td>
      <td> {{patient.city}}</td>
      <td> {{patient.country}}</td>
      <td> {{patient.phone}}</td>
      <td><button v-on:click="component ='visits'">Visits</button></td>
    </tr>
    <component v-if="component != null" :adminINFO ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
  </table>
  <div>
    <h5>{{ msg }}</h5>
  </div>
</template>

<script>
import axios from "axios";
import NewVisit from "@/components/Dermatologist/NewVisit";

export default {
  name: "DermatologistPatientTable",
  components:{
    'visits':NewVisit,
  },

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

      component:null,
      msg: ""
    }
  },

  props: {
    adminINFO: Object
  },

  mounted() {
    this.apotecary_id = this.adminINFO.apotecary_id;
    this.userId = this.adminINFO.userId;


    axios.post("/api/dermatologist/view-patients", {id :this.userId})
        .then(response => {
          this.patients = response.data;
        })

  },

  methods: {


    refresh(){
      axios.post("/api/dermatologist/view-patients", {id : 19})
          .then(response => {
            this.patients = response.data;
          })
    }
  },

  computed: {
    fillteredDermatologist: function() {
      return this.patients.filter( (elem) => {
        return elem.name.match(this.searchFirstname) && elem.lastName.match(this.searchLastname)
      });
    }
  }
}
</script>

<style scoped>

</style>