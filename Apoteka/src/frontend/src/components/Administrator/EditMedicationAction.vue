<template>
  <div id="container"><div id="container-inner">
    <h1>Edit Medication Action</h1>
    <form>
      <fieldset>

          <div>
          <label for="actionStartDate">Action Start Date</label>
          <input type="date" id="actionStartDate" name="actionStartDate" v-model="actionStartDate" required>
        </div>

        <div>
          <label for="actionStartTime">Action Start Time</label>
          <input type="time" id="actionStartTime" name="actionStartTime" min="00:00" max="24:00"  v-model="actionStartTime" required>
        </div>

        <div>
          <label for="actionEndDate">Action End Date</label>
          <input type="date" id="actionEndDate" name="actionEndDate" v-model="actionEndDate" required>
        </div>

        <div>
          <label for="actionEndTime">Action End Time</label>
          <input type="time" id="actionEndTime" name="actionEndTime" min="00:00" max="24:00"  v-model="actionEndTime" required>
        </div>

        <div>
          <label for="procentage">Procentage</label>
          <input type="number"  min = "1" max = "100" name="procentage" id="procentage" v-model="procentage" required />
        </div>
        
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="editAction" value="Edit Medication Action" />
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
  name: 'EditMedicationInfo',
  data() {
    return {
      msg: '',
      apotecary_id: null, 
      medication_id: null,

      actionStartDate: null,
      actionStartTime: null,
      actionEndDate: null,
      actionEndTime: null,
      procentage: null,
      medicationAction_id: null,

      medInfoId : null,
      accessToken: null
    }
  },

  props: {
    medInfoID: Object
  },

  mounted() {
      this.medInfoId = this.medInfoID.id;
      this.accessToken = this.medInfoID.accessToken;
      
      axios.post("/api/medication-action/get", {id: this.medInfoId}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.medicationAction_id = response.data.id;
                this.actionStartDate= response.data.actionStartDate;
                this.actionStartTime= response.data.actionStartTime;
                this.actionEndDate= response.data.actionEndDate;
                this.actionEndTime= response.data.actionEndTime;

                this.procentage= response.data.procentage;
            })
  },

  methods:{
    editAction(){
      axios.post("/api/medication-action/add-new", {id: this.medicationAction_id, actionStartDate : this.actionStartDate, actionStartTime: this.actionStartTime, actionEndDate: this.actionEndDate, 
      actionEndTime: this.actionEndTime, medicationInfo_id: this.medInfoId, procentage: this.procentage}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
          .then((response) => {
            this.msg = response.data;
            this.$emit('close-component');
          });
    }
  }
}
</script>