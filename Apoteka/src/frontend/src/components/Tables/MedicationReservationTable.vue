<template>
  <div>
    <h3> Medication Reservation Table </h3>

    <table>
      <tr bgcolor='lightgrey'>
        <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
        <th><div @click="sortBy('firstname')" class="sortBy">fristname</div></th>
        <th><div @click="sortBy('lastname')" class="sortBy">lastname</div></th>
        <th><div @click="sortBy('endDate')" class="sortBy">End Date</div></th>
        <th><div @click="sortBy('endTime')" class="sortBy">End Time</div></th>
        <th><div @click="sortBy('quantity')" class="sortBy">quantity</div></th>
        <th><div @click="sortBy('status')" class="sortBy">status</div></th>
        <th><div @click="sortBy('consultationID')" class="sortBy">status</div></th>
        <th><div @click="sortBy('visitId')" class="sortBy">visit</div></th>
        <th><div @click="sortBy('medication')" class="sortBy">medication</div></th>
      </tr>

      <tr v-for="medicationReservation in fillteredDermatologist"  v-bind:key="medicationReservation.id">
        <td> {{medicationReservation.id}}</td>
        <td> {{medicationReservation.firstname}}</td>
        <td> {{medicationReservation.lastname}}</td>
        <td> {{medicationReservation.endDate}}</td>
        <td> {{medicationReservation.endDate}}</td>
        <td> {{medicationReservation.status}}</td>
        <td> {{medicationReservation.consultationID}}</td>
        <td> {{medicationReservation.visitId}}</td>
        <td> {{medicationReservation.status}}</td>
        <td> {{medicationReservation.medication}}</td>


      </tr>
      <component v-if="component != null" :adminINF ="{userId : patientId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
    </table>
    <div>
      <h5>{{ msg }}</h5>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MedicationReservationTable",

  data(){
    return{
      visits : [],

      mode: "BROWSE",
      selectedPharmacist: {},

      apotecary_id : null,
      userId : null,
      patientId : null,
      component:null,
      msg: ""
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
    this.apotecary_id = this.adminINF.apotecary_id;
    this.userId = this.adminINF.userId;


    axios.post("/api/dermatologist/get-all-medication-reservations", { apotecaryID:this.apotecary_id})
        .then(response => {
          this.visits = response.data;
        })

  },
}
</script>

<style scoped>

</style>