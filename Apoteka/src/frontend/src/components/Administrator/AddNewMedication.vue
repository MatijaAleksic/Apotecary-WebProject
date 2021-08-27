<template>
<div>
  <div id="container"><div id="container-inner">
    <h1>Add new Medication</h1>
    <form >
      <fieldset>

        <div>
          <label for="name">Name</label>
          <input type="text" name="name" id="name" v-model="name" required />
        </div>

        <div>
          <label for="medicationType">Medication Type</label>
          <input type="number" name="medicationType" id="medicationType" v-model="medicationType" required />
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

        <div>
          <label for="contradictions">Contradictions</label>
          <input type="text" name="contradictions" id="contradictions" v-model="contradictions" required />
        </div>

        <div>
          <label for="composition">Composition</label>
          <input type="text" name="composition" id="composition" v-model="composition" required />
        </div>

        <div>
          <label for="dailyIntake">Daily Intake</label>
          <input type="text" name="dailyIntake" id="dailyIntake" v-model="dailyIntake" required />
        </div>

        <div>
          <label for="replacementDrugs">Replacement Drugs</label>
          <input type="text" name="replacementDrugs" id="replacementDrugs" v-model="replacementDrugs" required />
        </div>

        
        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Add medication" />
        </div>
        <div>
          <h1>{{ msg }}</h1>
        </div>
      </fieldset>
    </form>
</div></div></div>
</template>

<script>
import axios from "axios";
export default {
  name: 'AddNewMedication',

  data() {
    return {
      msg: '',

      medication_id: Number,
      apotecary_id: Number,

      name: null,
      medicationType: null,

      price: null,
      priceDurationEndDate: null,
      priceDurationEndTime: null,
      inStorage: null,
      contradictions: null,
      composition: null,
      dailyIntake: null,
      replacementDrugs: null,

  
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
      this.apotecary_id = this.adminINF.apotecary_id;
  },

  methods:{
    submit(){
      axios.post("/api/medication/add-new", {name : this.name, medicationType: this.medicationType})
          .then((response) => {
            this.medication_id = response.data;

            axios.post("/api/medication-info/add-new", {price : this.price, priceDurationEndDate: this.priceDurationEndDate, priceDurationEndTime: this.priceDurationEndTime,
                                                 inStorage: this.inStorage, apotecary_id : this.apotecary_id, medication_id: response.data })

            axios.post("/api/medication-specifications/add-new", {contradictions : this.contradictions, composition: this.composition, dailyIntake: this.dailyIntake,
                                                 replacementDrugs: this.replacementDrugs, medication_id: response.data })
            .then((response) => {
              this.msg = response.data;
            });
          });
    }

    

    
  }}
</script>w2