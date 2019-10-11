<template>
  <div>
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