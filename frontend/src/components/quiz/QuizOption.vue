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
  border-radius: 4px;
  background-color: #f3f3f3;
}
</style>
