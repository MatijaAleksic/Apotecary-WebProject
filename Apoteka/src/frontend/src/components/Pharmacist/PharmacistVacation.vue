<template>
  <div id="container"><div id="container-inner">
    <h1>Request vacation</h1>
    <form>
      <fieldset>
        <div>
          <label for="startDate">Start Date</label>
          <input type="date" id="startDate" name="start date" v-model="startDate" required>
        </div>

        <div>
          <label for="finishDate">End Date</label>
          <input type="date" id="finishDate" name="end date" v-model="finishDate" required>
        </div>

        <div>
          <label for="description">Description</label>
          <input type="text" id="description" text="description" v-model="description">
        </div>

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Request vacation" />
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
  name: "PharmacistVacation",
  data(){
    return{
      msg: '',

      startDate : '',
      finishDate: '',
      description:'',
      pharmacist_id: null

    }
  },
  props: {
    adminINFO: Object
  },
  mounted() {
    this.pharmacist_id = this.adminINFO.userId;
  },
  methods:{
    submit(){
      axios.post(axios.post("/api/pharmacist/vacation",{startDate : this.startDate, finishDate : this.finishDate,
        description:this.description, pharmacist_id: this.pharmacist_id, approdved:false})
          .then((response) => {
            this.msg = response.data;
          }));
    }
  }
}
</script>

<style scoped>

</style>