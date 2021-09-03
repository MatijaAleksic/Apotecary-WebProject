<template>
  <div id="container"><div id="container-inner"  >
    <form>
      <fieldset>
        <div class="field">
          <label for="id">Consultation id</label>
          <input type="number" name="id" id="id" v-model="id"/>
        </div>
        <div class="field">
          <label for="patient_id">Patient id</label>
          <input type="number" name="patient_id" id="patient_id" v-model="patient_id"/>
        </div>
        <div class="field">
          <label class="labela" for="startDate">Pick date</label>
          <input type="date" name="startDate" id="startDate" v-model="startDate"/>
        </div>
        <div class="field">
          <label class="labela" for="startTime">Pick time</label>
          <input type="time" name="startTime" id="startTime" v-model="startTime"/>
        </div>
        <div class="field">
          <label class="labela" for="duration">Duration</label>
          <input type="text" name="duration" id="duration" v-model="duration"/>
        </div>
        <div class="field">
          <label class="labela" for="price">Price</label>
          <input type="text" name="price" id="price" v-model="price"/>
        </div>
        <div class="field">
          <label class="labela" for="status">Status</label>
          <input type="status" name="status" id="status" v-model="status"/>
        </div>
        <div class="field">
          <label class="labela" for="report">Report</label>
          <input type="text" name="report" id="report" v-model="report"/>
        </div>

        <!-- Controls -->
        <div class="field">
          <input id="submit" name="submit" type="button" @click="submit" value="Submit" />
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
  name: "new-consultation",
  data() {
    return {
      msg: '',
      id:'',
      patient_id:'',
      startDate: '',
      startTime: '',
      duration: '',
      price: '',
      status: '',
      report: '',
      pharmacist_id: null,
      apotecary_id: null,
      accessToken: null


    }
  },
  props: {
    adminINFO: Object
  },
  mounted() {
    this.pharmacist_id = this.adminINFO.userId;
    this.apotecary_id = this.adminINFO.apotecary_id;
    this.accessToken = this.adminINF.accessToken;
  },

  methods:{
    submit(){
      axios.post("/api/consultation/new-consultation", {id: this.id,startDate : this.startDate, startTime: this.startTime, duration: this.duration, price: this.price,
        status: this.status, report: this.report,pharmacist_id: this.pharmacist_id, patient_id: this.patient_id,apotecary_id : this.apotecary_id},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>

<style scoped>

</style>