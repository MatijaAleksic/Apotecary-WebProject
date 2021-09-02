<template>
  <div id="container"><div id="container-inner">
    <h1>Change Password</h1>
    <form >
      <fieldset>

        <div>
          <label for="newPassword">Your new password</label>
          <input type="text" name="newPassword" id="newPassword" v-model="newPassword"/>
        </div>

        <div>
          <label for="reNewPassword">Redo your password</label>
          <input type="text" name="reNewPassword" id="reNewPassword" v-model="reNewPassword"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Change Password" />
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
  name: "ChangePasswordPharmacist",

  data() {
    return {
      msg: '',
      newPassword: '',
      reNewPassword: '',

      userId: null
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {


    this.userId = this.adminINF.userId;
  },

  methods: {
    submit() {
      if (this.reNewPassword == this.newPassword) {
        axios.post("/api/pharmacist/change-password", {id: this.userId, newPassword: this.newPassword})
            .then((response) => {
              this.msg = response.data;
            });
      } else {
        alert("Passwords dont match!")
      }
    }
  }
}
</script>

<style scoped>

</style>