<template>
  <div>
      <div >
        <h1>Dermatologist homepage</h1>
      </div>
      <component v-bind:is="component"> </component>
    </div>
    
</template>

<script>
//import axios from "axios";

export default {
  name: "DermatologistHomePage",

components:{
},

 data(){
    return{
      component:null,
    }
  },

}
</script>

<style scoped>

</style>