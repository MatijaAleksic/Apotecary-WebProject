<template>
  <div id="container"><div id="container-inner">
    <h1>Edit Medication Info</h1>
    <form>
      <fieldset>

          <div>
          <label for="priceDurationEndDate">Action Start Date</label>
          <input type="date" id="priceDurationEndDate" name="priceDurationEndDate" v-model="priceDurationEndDate" required>
        </div>

        <div>
          <label for="priceDurationEndDate">Price End Date</label>
          <input type="date" id="priceDurationEndDate" name="priceDurationEndDate" v-model="priceDurationEndDate" required>
        </div>

        <div>
          <label for="priceDurationEndDate">Price End Date</label>
          <input type="date" id="priceDurationEndDate" name="priceDurationEndDate" v-model="priceDurationEndDate" required>
        </div>
        <div>
          <label for="price">Price</label>
          <input type="number"  min = "1" max = "100000" step="0.01" name="price" id="price" v-model="price" required />
        </div>

        <div>
          <label for="priceDurationEndDate">Price End Date</label>
          <input type="date" id="priceDurationEndDate" name="priceDurationEndDate" v-model="priceDurationEndDate" required>
        </div>

        <div>
          <label for="priceDurationEndTime">Price End Time</label>
          <input type="time" id="priceDurationEndTime" name="priceDurationEndTime" min="00:00" max="24:00"  v-model="priceDurationEndTime" required>
        </div>

        <div>
          <label for="inStorage">In Storage</label>
          <input type="number"  min = "1" max = "100000"  name="inStorage" id="inStorage" v-model="inStorage" required />
        </div>
        
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="editMedication" value="Edit Medication Info" />
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

      medInfoId : null
    }
  },

  props: {
    medInfoID: Object
  },

  mounted() {
      this.medInfoId = this.medInfoID.id;

      axios.post("/api/medication-info/get", {apotecary_id : this.apotecary_id, medication_id: this.medication_id})
            .then(response => {
                this.price = response.data.price;
                this.priceDurationEndDate= response.data.priceDurationEndDate;
                this.priceDurationEndTime= response.data.priceDurationEndTime;
                this.inStorage= response.data.inStorage;
                this.medInfoId = response.data.id;
            })
  },

  methods:{
    editMedication(){
      axios.post("/api/medication-info/change-information", {price: this.price, priceDurationEndDate : this.priceDurationEndDate,
      priceDurationEndTime : this.priceDurationEndTime, inStorage : this.inStorage, medication_id : this.medication_id, apotecary_id : this.apotecary_id})
          .then((response) => {
            this.msg = response.data;
            this.$emit('close-component');
          });
    }
  }
}
</script>