<template>
  <div id="container"><div id="container-inner">
    <h1>Change Password</h1>
    <form >
      <fieldset>
        <!-- Your current password -->
        <div>
          <label for="id">Id</label>
          <input type="number" name="id" id="id" v-model="id"/>
        </div>
        <!-- Your new password -->
        <div>
          <label for="newPassword">Your new password</label>
          <input type="text" name="newPassword" id="newPassword" v-model="newPassword"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Save Password" />
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
  name: 'Change Password',
  data() {
    return {
      msg: '',
      newPassword: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/pharmacist/change-password", {id : this.id, newPassword: this.newPassword})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>