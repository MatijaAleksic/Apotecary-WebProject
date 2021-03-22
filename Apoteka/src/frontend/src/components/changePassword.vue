<template>
  <div id="container"><div id="container-inner">
    <h1>Change Password</h1>
    <form >
      <fieldset>
        <!-- Your current password -->
        <div>
          <label for="password_current">Your current password</label>
          <input type="text" name="password_current" id="password_current" v-model="oldPassword"/>
        </div>

        <!-- Your new password -->
        <div>
          <label for="password_new">Your new password</label>
          <input type="text" name="password_new" id="password_new" v-model="newPassword"/>
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
      oldPassword: '',
      newPassword: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/dermatologist/changePassword", {oldPassword: this.oldPassword, newPassword: this.newPassword})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>