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

      startDate: '',
      startTime: '',
      duration: '',
      price: '',
      dermatologist: '',

      apotecary_id: Number,
      user_id : Number,

      items: [],
      dermatologists: [],

      select: null,
      accessToken: null
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
      this.apotecary_id = this.adminINF.apotecary_id;
      this.user_id = this.adminINF.userId;
      this.accessToken = this.adminINF.accessToken;
      
      axios.post("/api/dermatologist/get-all-admin", {id : this.apotecary_id}, 
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
    text: item => item.firstname + ' ' + item.lastname,
    
    submit(){
      axios.post("/api/visit/new-visit", {startDate: this.startDate, startTime: this.startTime, duration : this.duration, price : this.price,
                                          dermatologis_id: this.select.id, apotecary_id : this.apotecary_id }, 
        {
          headers: {
            'Authorization': `Bearer ${this.accessToken}`
          },
      })
          .then((response) => {
            this.msg = response.data;
            this.$emit('refresh');
          });

    }
  }
}
</script>