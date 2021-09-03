<template>
  <div>
    <h3> Visit Table </h3>

    <input type="text" v-model="searchFirstname" placeholder="Firstname"/>
    <input type="text" v-model="searchLastname" placeholder="Lastname"/>

    <table>
      <tr bgcolor='lightgrey'>
        <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
        <th><div @click="sortBy('firstname')" class="sortBy">First Name</div></th>
        <th><div @click="sortBy('lastname')" class="sortBy">Last Name</div></th>
        <th><div @click="sortBy('startDate')" class="sortBy">startDate</div></th>
        <th><div @click="sortBy('startTime')" class="sortBy">startTime</div></th>
        <th><div @click="sortBy('duration')" class="sortBy">duration</div></th>
        <th><div @click="sortBy('price')" class="sortBy">price</div></th>
        <th><div @click="sortBy('status')" class="sortBy">status</div></th>
        <th><div @click="sortBy('report')" class="sortBy">report</div></th>
      </tr>

      <tr v-for="patient in fillteredPharmacist"  v-bind:key="patient.id">
        <td> {{patient.id}}</td>
        <td> {{patient.firstname}}</td>
        <td> {{patient.lastname}}</td>
        <td> {{patient.startDate}}</td>
        <td> {{patient.startTime}}</td>
        <td> {{patient.duration}}</td>
        <td> {{patient.price}}</td>
        <td> {{patient.status}}</td>
        <td> {{patient.report}}</td>
        <td><button v-on:click="selectedApotecary(patient.patientId,patient.id)">Start report</button></td>

      </tr>
      <component v-if="component != null" :adminINF ="{consultationId: consultationId ,userId : patientId, apotecary_id : apotecary_id,accessToken: accessToken}" v-bind:is="component"> </component>
    </table>
    <div>
      <h5>{{ msg }}</h5>
    </div>
  </div>
</template>

<script>

import NewConsultation from "@/components/Pharmacist/NewConsultation";
import axios from "axios";
import ReportConsultation from "@/components/Dermatologist/ReportConsultation";
export default {
  name: "PharmacistPatientTable",
  components:{
    'counsultation': NewConsultation,
    'visits': ReportConsultation,
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
      consultationId: null,
      patientId : null,
      component:null,
      msg: "",
      accessToken: null

    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
    this.apotecary_id = this.adminINF.apotecary_id;
    this.userId = this.adminINF.userId;
    this.consultationId = this.adminINF.consultationId;
    this.accessToken = this.adminINF.accessToken;

    axios.post("api/pharmacist/get-all-consultations", {pharmaId : this.userId, apotecaryId : this.apotecary_id},
        {
          headers: {
            'Authorization': `Bearer ${this.accessToken}`
          },
        })
        .then(response => {
          this.patients = response.data;
        })

  },

  methods: {

    selectedApotecary(id, consultationId){
      this.patientId = id;
      this.consultationId = consultationId;
      this.component = 'visits'

    },

  },

  computed: {
    fillteredPharmacist: function() {
      return this.patients.filter( (elem) => {
        return elem.firstname.toLowerCase().match(this.searchFirstname) && elem.lastname.toLowerCase().match(this.searchLastname)
      });
    }
  }
}
</script>

<style scoped>
</style>