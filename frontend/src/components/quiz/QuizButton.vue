<template>
  <button class="button">
    {{ value }}
  </button>
</template>

<script setup>
defineProps({
  value: String,
})
</script>

<style scoped>
.button {
  flex-basis: 50%;
  aspect-ratio: 2;
  border: 1px solid #000000;

  font-size: 24px;
}
</style>
