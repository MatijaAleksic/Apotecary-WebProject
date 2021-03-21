<template>
  <div>
    <component v-bind:is="component"> </component>

    <button v-on:click="component ='register-dermatologist'">Register Dermathologist</button>
    <button>2.Komponenta</button>
    <button>3.Komponenta</button>


  </div>
  <div>
        <button v-on:click="component ='null'">Close</button>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import RegisterDermatologist from './components/RegisterDermatologist.vue'

export default {
  name: 'App',

  components: {
    //HelloWorld
    'register-dermatologist' : RegisterDermatologist,
  },

  data(){
    return{
      component:null
    }
  }

  // methods: {
  //   swapComponents : function(component)
  //   {
  //     this.currentComponent = component;
  //   }
  // }
}
</script>

<style>

</style>
