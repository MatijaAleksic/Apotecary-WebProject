<template>
  <div id="container"><div id="container-inner">
    <form >
      <fieldset>
        <!-- Controls -->
      <change-infomration-pharmacist></change-infomration-pharmacist>
        <change-password-pharmacist></change-password-pharmacist>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import ChangeInformationPharmacist from "@/components/Pharmacist/ChangeInformationPharmacist";
import changePassword from "@/components/changePassword";

export default {
  name: "PharmacistProfilPage",
  components:{
    'change-infomration-pharmacist': ChangeInformationPharmacist,
    'change-password-pharmacist': changePassword
  }

}
</script>

<style scoped>

</style>