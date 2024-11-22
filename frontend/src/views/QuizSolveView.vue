<template>
  <div class="container">
    <quiz-content :content="content"></quiz-content>
    <quiz-option v-for="(option, index) in options" :key="option" :option="option" :selected="index === userAnswer - 1"
                 @click="handleAnswerClick(index)"></quiz-option>
    <hr>
    <div class="this-is">이건</div>
    <div class="quiz-buttons">
      <quiz-button value="상식이다" :selected="isCommonSense === true" @click="handleButtonClick(true)"></quiz-button>
      <quiz-button value="아니다" :selected="isCommonSense === false" @click="handleButtonClick(false)"></quiz-button>
    </div>
  </div>
</template>

<script setup>
import QuizContent from '@/components/quiz/QuizContent.vue'
import QuizOption from '@/components/quiz/QuizOption.vue'
import QuizButton from '@/components/quiz/QuizButton.vue'

import { ref, onMounted } from 'vue'
import { getRandomQuiz } from '@/api/quizApi.js'

const content = ref('지금 내 마음은?')
const options = ref([
  '안녕하세요',
  '여긴싸피에요',
  '살려주세요',
  '집에가고싶어'
])
const userAnswer = ref(0)
const isCommonSense = ref(0)

const handleAnswerClick = (index) => {
  userAnswer.value = index + 1
}

const handleButtonClick = (val) => {
  isCommonSense.value = val
}

onMounted(async () => {
  const data = await getRandomQuiz()
  content.value = data.content;
  options.value[0] = data.option1;
  options.value[1] = data.option2;
  data.option4 ? options.value[3] = data.option4 : options.value.length = 3;
  data.option3 ? options.value[2] = data.option3 : options.value.length = 2;
})
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 12px;

  width: 40%;
  padding: 20px;
  border: 1px solid #000000;
  min-width: 450px;
}

.this-is {
  font-size: 20px;
}

.quiz-buttons {
  display: flex;
  gap: 20px;
}
</style>
