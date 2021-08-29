<template>
<div>
  <div id="container"><div id="container-inner">
    <h1>Add new visit</h1>
    <form>
      <fieldset>
        <div>
          <label for="startDate">Start Date</label>
          <input type="date" id="startDate" name="startDate" v-model="startDate" required>
        </div>

        <div>
          <label for="startTime">Start Time</label>
          <input type="time" id="startTime" name="startTime" min="00:00" max="24:00"  v-model="startTime" required>
        </div>

        <div>
          <label for="duration">Duration</label>
          <input type="number"  min = "1" max = "200"  name="duration" id="duration" v-model="duration" required />
        </div>

        <div>
          <label for="price">Price</label>
          <input type="number"  min = "1" max = "100000" step="0.01" name="price" id="price" v-model="price" required />
        </div>

        <div>
          <label for="dermatologist">Dermatologist</label>
          <input type="text" name="dermatologist" id="dermatologist" v-model="dermatologist"/>
        </div>

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Add new visit" />
        </div>
        <div>
          <h1>{{ msg }}</h1>
        </div>
      </fieldset>
    </form>
    </div></div>
</div>
</template>

<script>

import axios from "axios";

export default {
  name: 'AddNewVisit',
  data() {
    return {
      msg: '',
      apotecary_id: null, 

      startDate: '',
      startTime: '',
      duration: '',
      price: '',
      dermatologist: ''
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
      axios.post("/api/dermatologist/register-new", {firstname: this.firstname, lastname: this.lastname,
      username: this.username, password: this.password, email: this.email, adress : this.adress,
       city: this.city,country: this.country, phone: this.phone, apotecary_id: this.apotecary_id,
       startHours: this.startHours, endHours:this.endHours})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }
}
</script>