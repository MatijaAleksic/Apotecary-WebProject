<template>
  <div id="container"><div id="container-inner">
    <h1>Request vacation</h1>
    <form >
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
  name: "DermatologistVacation",
  data(){
    return{
      msg: '',

      startDate : '',
      finishDate: '',
      description:'',
      dermatologist_id: null,
      accessToken: null

    }
  },
  props: {
    adminINF: Object
  },
  mounted() {
    this.dermatologist_id = this.adminINF.userId;
    this.accessToken = this.adminINF.accessToken;

  },
  methods:{
    submit(){
      axios.post(axios.post("/api/dermatologist/vacation",{startDate : this.startDate, finishDate : this.finishDate,
        description:this.description, dermatologist_id: this.dermatologist_id, approdved:false},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then((response) => {
            this.msg = response.data;
          }));
    }
  }
}
</script>

<style scoped>

</style>