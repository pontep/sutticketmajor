<template>
  <div>
      <v-icon x-large>mdi-home</v-icon>
      <h1>
          ยินดีต้อนรับ.. {{ customer.name }}
      </h1>
  </div>
</template>

<script>
export default {
    props:{
        customer:{}
    }
}
</script>

<style>

</style>