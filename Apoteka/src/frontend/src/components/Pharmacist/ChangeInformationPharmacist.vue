<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form >
      <fieldset>
        <div>
          <label for="id">Id</label>
          <input type="number" name="id" id="id" v-model="id"/>
        </div>
        <div>
          <label for="name">Name</label>
          <input type="text" name="name" id="name" v-model="name"/>
        </div>
        <div>
          <label for="lastName">Last Name</label>
          <input type="text" name="lastName" id="lastName" v-model="lastName"/>
        </div>
        <div>
          <label for="city">Username</label>
          <input type="text" name="city" id="city" v-model="city"/>
        </div>
        <div>
          <label for="address">Address</label>
          <input type="text" name="address" id="address" v-model="address"/>
        </div>
        <div>
          <label for="country">Country</label>
          <input type="text" name="country" id="country" v-model="country"/>
        </div>
        <div>
          <label for="phone">Phone</label>
          <input type="text" name="phone" id="phone" v-model="phone"/>
        </div>

        <!-- Controls -->
        <div class="controls">
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
      axios.post("/api/pharmacist/change-information", {id : this.id, name: this.name, lastName: this.lastName, city: this.city,
      address: this.address, phone: this.phone, country: this.country})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>