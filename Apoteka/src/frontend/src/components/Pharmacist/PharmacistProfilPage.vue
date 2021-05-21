<template>
  <div id="container"><div id="container-inner">
    <form >
      <fieldset style="border:white">
        <!-- Controls -->
      <change-infomration-pharmacist></change-infomration-pharmacist>
        <change-password-pharmacist></change-password-pharmacist>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import ChangeInformationPharmacist from "@/components/Pharmacist/ChangeInformationPharmacist";
import ChangePasswordPharmacist from "@/components/Pharmacist/ChangePasswordPharmacist";

export default {
  name: "PharmacistProfilPage",
  components:{
    'change-infomration-pharmacist': ChangeInformationPharmacist,
    'change-password-pharmacist': ChangePasswordPharmacist
  }

}
</script>

<style scoped>

</style>