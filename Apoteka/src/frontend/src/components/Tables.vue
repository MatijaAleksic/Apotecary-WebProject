<template>
  <div>
    <h3>Apothecary Table</h3>
    <apothecary-table></apothecary-table>
    <br>
    <h3>Pharmacist Table</h3>
    <pharmacist-table></pharmacist-table>
    <br>
    <h3>Dermatologist Table</h3>
    <dermatologist-table></dermatologist-table>
    <br>
  </div>
</template>

<script>
import ApothecaryTable from "@/components/ApothecaryTable";
import PharmacistTable from "@/components/PharmacistTable";
import DermatologistTable from "@/components/DermatologistTable";

export default {
  name: "Tables",
  components: {
    'apothecary-table': ApothecaryTable,
    'pharmacist-table': PharmacistTable,
    'dermatologist-table': DermatologistTable,
  }
}
</script>

<style scoped>

</style>