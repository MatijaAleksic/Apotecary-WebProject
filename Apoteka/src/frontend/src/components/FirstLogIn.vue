<template>
  <div id="container"><div id="container-inner">
    <form style="width: 300px; position:absolute; top: 200px; left: 600px">
      <fieldset>
        <!-- Your new password -->
        <div>
          <label for="new_password">Your current password</label>
          <input type="text" name="new_password" id="new_password" v-model="new_password"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input style="position:relative; margin-top:15px; left:95px; width: 100px;" id="submit" name="submit" type="button" @click="submit" value="Save Password" />
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
      axios.post("/api/dermatologist/firstLogIn", {newPassword: this.newPassword})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>