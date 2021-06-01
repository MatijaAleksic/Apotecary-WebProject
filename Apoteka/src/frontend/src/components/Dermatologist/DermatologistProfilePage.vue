<template>
  <div id="container"><div id="container-inner">
    <form >
      <fieldset style="border:white">
        <!-- Controls -->
        <change-infomration-dermatologist></change-infomration-dermatologist>
      </fieldset>
    </form>

  </div></div>
</template>

<script>

import ChangeInformationDermatologist from "@/components/Dermatologist/ChangeInformationDermatologist";

export default {
  name: "PharmacistProfilPage",
  components:{
    'change-infomration-dermatologist': ChangeInformationDermatologist,

  }

}
</script>

<style scoped>

</style>