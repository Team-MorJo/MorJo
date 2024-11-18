<template>
  <div class="answer">
    {{ option }}
  </div>
</template>

<script setup>
defineProps({
  option: String,
})
</script>

<style scoped>
.answer {
  padding: 12px;
  font-size: 16px;
  border: 1px solid #000000;
  cursor: pointer;
}
</style>
