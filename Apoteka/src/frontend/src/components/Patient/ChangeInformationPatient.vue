<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form >
      <fieldset>
        <div>
          <label for="name">Name</label>
          <input type="text" name="name" id="name" v-model="name"/>
        </div>
        <div>
          <label for="lastName">Last Name</label>
          <input type="text" name="lastName" id="lastName" v-model="lastName"/>
        </div>
        <div>
          <label for="username">Username</label>
          <input type="text" name="username" id="username" v-model="username"/>
        </div>
        <div>
          <label for="address">Address</label>
          <input type="text" name="address" id="address" v-model="address"/>
        </div>
        <div>
          <label for="phoneNumber">Your new password</label>
          <input type="text" name="phoneNumber" id="phoneNumber" v-model="phoneNumber"/>
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
  name: 'Change Information',
  data() {
    return {
      msg: '',
      name: '',
      lastName: '',
      username: '',
      address: '',
      phoneNumber: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/patient/change-information", {name: this.name, lastName: this.lastName, username: this.username,
      address: this.address, phoneNumber: this.phoneNumber})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>