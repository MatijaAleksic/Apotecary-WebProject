<template>
  <div id="container"><div id="container-inner">
    <h1>Register new dermatologist</h1>
    <form>
      <fieldset>
        <div>
          <label for="firstname">First Name</label>
          <input type="text" name="firstname" id="firstname" v-model="firstname"/>
        </div>

        <div>
          <label for="lastname">Last Name</label>
          <input type="text" name="lastname" id="lastname" v-model="lastname"/>
        </div>

        <div>
          <label for="username">Username</label>
          <input type="text" name="username" id="username" v-model="username"/>
        </div>

        <div>
          <label for="email">Email</label>
          <input type="text" name="email" id="email" v-model="email"/>
        </div>

        <div>
          <label for="adress">Address</label>
          <input type="text" name="adress" id="adress" v-model="adress"/>
        </div>

        <div>
          <label for="city">City</label>
          <input type="text" name="city" id="city" v-model="city"/>
        </div>

        <div>
          <label for="country">Country</label>
          <input type="text" name="country" id="country" v-model="country"/>
        </div>

        <div>
          <label for="phone">Phone</label>
          <input type="text" name="phone" id="phone" v-model="phone"/>
        </div>

        <div>
          <label for="phone">Apotecary</label>
          <input type="number" name="apotecary_id" id="apotecary_id" v-model="apotecary_id"/>
        </div>

        <div>
          <label for="startHours">StartHours</label>
          <input type="time" id="startHours" name="startHours" min="00:00" max="24:00"  v-model="startHours" required>
        </div>

        <div>
          <label for="endHours">EndHours</label>
          <input type="time" id="endHours" name="endHours" min="00:00" max="24:00"  v-model="endHours" required>
        </div>

        

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Create New Dermatologist" />
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
  name: 'AddNewDermatologist',
  data() {
    return {
      msg: '',
      firstname: '',
      lastname: '',
      username: '',
      password: '',
      email: '',
      adress: '',
      city: '',
      country: '',
      phone: '',
      apotecary_id: 0,
      startHours : '',
      endHours : ''
    }
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