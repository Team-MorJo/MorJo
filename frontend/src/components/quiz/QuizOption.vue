<template>
  <div class="answer" :class="{ selected }" :style="answerStyle" @mouseenter="handleMouseEnter" @mouseleave="handleMouseLeave">
    <span class="option">{{ option }}</span>
    <div v-show="isResult" class="graph" :style="graphStyle"></div>
    <span v-show="isResult">{{ percent }}%</span>
  </div>
</template>

<script setup>
import { computed, ref } from 'vue'

const mouseIn = ref(false)
const props = defineProps({
  option: String,
  selected: Boolean,
  total: Number,
  votes: Number,
  isResult: Boolean,
  isAnswer: Boolean
})

const percent = computed(() => (props.votes / props.total * 100).toFixed(1))

const answerStyle = computed(() => {
  return {
    border: (props.isResult ? ((props.isAnswer ? '#4CAF50' : '#D14D72') + " 2px") : '#000000 1px') + " solid",
    boxShadow: (props.selected ? "0 0 10px" : "0 0 0") + " " + (props.isResult ? (props.isAnswer ? "#4CAF50" : "#D14D72") : '#616161')
  }
})

const graphStyle = computed(() => {
  return {
    width: `${ percent.value }%`,
    backgroundColor: props.isAnswer ? '#DFF2E1' : '#FCC8D1'
  }
})

const handleMouseEnter = () => {
  if (props.isResult) {
    return
  }
  mouseIn.value = true
}

const handleMouseLeave = () => {
  mouseIn.value = false
}
</script>

<style scoped>
.answer {
  position: relative;
  display: flex;
  justify-content: space-between;
  height: 50px;
  line-height: 25px;
  padding: 12px;
  font-size: 16px;
  cursor: pointer;
}

.graph {
  position: absolute;
  z-index: -1;
  top: 0;
  left: 0;
  width: 0;
  height: 100%;
}
</style>
