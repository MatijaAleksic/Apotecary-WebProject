<template>
  <div id="container"><div id="container-inner"  >
    <form>
      <fieldset>
        <div class="field">
          <label for="id">Id</label>
          <input type="number" name="id" id="id" v-model="id"/>
        </div>
        <div class="field">
          <label class="labela" for="name">Name</label>
          <input type="text" name="name" id="name" v-model="name"/>
        </div>
        <div class="field">
          <label class="labela" for="lastName">Last Name</label>
          <input type="text" name="lastName" id="lastName" v-model="lastName"/>
        </div>
        <div class="field">
          <label class="labela" for="city">Username</label>
          <input type="text" name="city" id="city" v-model="city"/>
        </div>
        <div class="field">
          <label class="labela" for="address">Address</label>
          <input type="text" name="address" id="address" v-model="address"/>
        </div>
        <div class="field">
          <label class="labela" for="country">Country</label>
          <input class="labela" type="text" name="country" id="country" v-model="country"/>
        </div>
        <div class="field">
          <label class="labela" for="phone">Phone</label>
          <input type="text" name="phone" id="phone" v-model="phone"/>
        </div>

        <!-- Controls -->
        <div class="field">
          <input id="submit" name="submit" type="button" @click="submit" value="Save Info" />
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
  name: 'Change Information Pharmacist',
  data() {
    return {
      msg: '',
      name: '',
      lastName: '',
      city: '',
      address: '',
      phone: '',
      country: '',

    }
  },
  methods:{
    submit(){
      axios.post("/api/dermatologist/change-information", {id : this.id, name: this.name, lastName: this.lastName, city: this.city,
        address: this.address, phone: this.phone, country: this.country})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>