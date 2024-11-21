<template>
  <button class="button" :style="borderStyle">
    <span>{{ value }}</span>
    <span>{{ isResult ? ` ${percent} %` : ''}}</span>
    <div class="graph" :style="graphStyle"></div>
  </button>
</template>

<script setup>
import { computed } from 'vue'

const props = defineProps({
  value: String,
  selected: Boolean,
  total: Number,
  votes: Number,
  isResult: Boolean,
})

const percent = computed(() => (props.votes / props.total * 100).toFixed(1))

const borderStyle = computed(() => {
  return {
    border: props.isResult && props.selected ? "2px solid #2196F3" : "1px solid #000000",
    boxShadow: props.isResult && props.selected ? "0 0 10px #2196F3" : "none"
  }
})

const graphStyle = computed(() => {
  return {
    height: `${ percent.value }%`,
    backgroundColor: props.selected ? "#E3F2FD" : "#E9E9E9",
  }
})

</script>

<style scoped>
.button {
  position: relative;
  flex-basis: 50%;
  aspect-ratio: 2;
  border: 1px solid #000000;

  font-size: 24px;
}
.graph {
  position: absolute;
  z-index: -1;
  bottom: 0;
  left: 0;
  width: 100%;
}
</style>
