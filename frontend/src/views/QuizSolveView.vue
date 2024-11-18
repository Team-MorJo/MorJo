<template>
  <div class="container">
    <quiz-conent :content="content"></quiz-conent>
    <quiz-option v-for="option in options" :key="option.id" :option="option"></quiz-option>
  </div>
</template>

<script setup>
import QuizConent from '@/components/quiz/QuizConent.vue'
import QuizOption from '@/components/quiz/QuizOption.vue'

import { ref } from 'vue'
const content = ref("지금 내 마음은?")
const options = ref([
  "안녕하세요",
  "여긴싸피에요",
  "살려주세요",
  "집에가고싶어"
])

</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 12px;

  width: 40%;
  padding: 20px;
  border-radius: 10px;
  background-color: #d9d9d9;
}
</style>
