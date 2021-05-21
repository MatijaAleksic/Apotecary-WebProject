<template>
  <div id="container"><div id="container-inner">
    <form style="width: 300px; position:absolute; top: 200px; left: 600px" >
      <fieldset>
        
        <!-- Your current password -->
        <h1 style="position: relative; left: 95px">Register</h1>

        <div>
          <label for="firstname">Firstname</label>
          <input style=" margin: 10px;" type="text" name="firstname" id="firstname" v-model="firstname"/> <br/>
        </div>

        <div>
          <label for="lastname">Lastname</label>
          <input style=" margin: 10px;" type="text" name="lastname" id="lastname" v-model="lastname"/> <br/>
        </div>

        <div>
          <label for="username">Username</label>
          <input style=" margin: 10px;" type="text" name="username" id="username" v-model="username"/> <br/>
        </div>

        <div>
          <label for="email">Email</label>
          <input style=" margin: 10px;" type="text" name="email" id="email" v-model="email"/> <br/>
        </div>

        <div>
          <label for="adress">Adress</label>
          <input style=" margin: 10px;" type="text" name="adress" id="adress" v-model="adress"/> <br/>
        </div>

        <div>
          <label for="city">City</label>
          <input style=" margin: 10px;" type="text" name="city" id="city" v-model="city"/> <br/>
        </div>

        <div>
          <label for="country">Country</label>
          <input style=" margin: 10px;" type="text" name="country" id="country" v-model="country"/> <br/>
        </div>

        <div>
          <label for="phone">Phone</label>
          <input style=" margin: 10px;" type="text" name="phone" id="phone" min="1" max="5" v-model="phone"/> <br/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input style="position:relative; margin-top:15px; left:95px; width: 100px;" id="submit" name="submit" type="button" @click="submit" value="Register" />
        </div>
        <div>
          <h1>{{ status }}</h1>
        </div>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import axios from "axios";
export default {
  name: 'Register',
  data() {
    return {
      firstname: '',
      lastname: '',
      username: '',
      password: '',
      email: '',
      adress: '',
      city: '',
      country: '',
      phone: '',

      status: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/unsigned/register-new", {firstname: this.firstname, lastname: this.lastname, username: this.username, password: this.password,
      email: this.email, adress: this.adress, city: this.city, country: this.country, phone: this.phone})
          .then((response) => {
            this.status = response.data;
          });
    }
  }}
</script>
