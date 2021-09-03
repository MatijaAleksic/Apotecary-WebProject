<template>
  <div data-app>
  <fieldset>
    <div class="field">
      <label class="labela" for="report">Report</label>
      <input type="text" name="report" id="report" v-model="report"/>
    </div>
  <div class="field">
    <label class="labela" for="price">Price</label>
    <input type="text" name="price" id="price" v-model="price"/>
  </div>

    <div class="text-center">
      <v-select
          v-model="select"
          :items="items"
          :item-text="text"
          label="Solo field"
          solo
          return-object
          single-line
      >
      </v-select>
    </div>

  <!-- Controls -->
  <div class="field">
    <input id="submit" name="submit" type="button" @click="submit" value="Submit" />
  </div>
  <div>
    <h1>{{ msg }}</h1>
  </div>
  </fieldset>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ReportVisit",

  data(){
    return{
      msg: '',
      report: '',
      price: '',

      medication: [],
      items: [],

      select: null,

      apotecary_id: Number,
      user_id : Number,
      visitId : Number,
      accessToken: null
    }
  },
  props: {
    adminINF: Object
  },

  mounted() {
    this.apotecary_id = this.adminINF.apotecary_id;
    this.user_id = this.adminINF.userId;
    this.visitId = this.adminINF.visitId;
    this.accessToken = this.adminINF.accessToken;

    axios.post("/api/medication/medication-alergies", {id: this.user_id},
        {
          headers: {
            'Authorization': `Bearer ${this.accessToken}`
          },
        })
        .then((response) => {
          this.items = response.data;
        });
  },
  methods:{
    text: item => item.name,

    submit(){
      axios.post("/api/visit/change-information", {price: this.price, report: this.report, visitID: this.visitId},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then((response) => {
            this.msg = response.data;
            this.$emit('close-component');
            this.refresh();
          });
    },

    refresh(){
      axios.post("/api/dermatologist/get-all-visits-table", { apotecaryID:this.apotecary_id,dermaID :this.userId},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then(response => {
            this.visits = response.data;
          })
    }
  }
}
</script>

<style scoped>

</style>