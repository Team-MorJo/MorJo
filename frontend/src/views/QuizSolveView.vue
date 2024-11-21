<template>
  <div class="container">
    <quiz-content :content="quiz.content"></quiz-content>
    <quiz-option v-for="(option, index) in quiz.options" :key="option" :option="option" :total="result.total"
                 :isResult="isResult" :votes="result.userAnswers[index]" :isAnswer="result.answer - 1 === index"
                 :selected="index === userAnswer - 1" @click="onAnswerClick(index)"></quiz-option>
    <hr>
    <div class="this-is">이건</div>
    <div class="quiz-buttons">
      <quiz-button value="상식이다" :selected="isCommonSense === true" :total="result.total" :votes="result.isCommonSense"
                   @click="onButtonClick(true)"></quiz-button>
      <quiz-button value="아니다" :selected="isCommonSense === false" :total="result.total" :votes="result.notCommonSense"
                   @click="onButtonClick(false)"></quiz-button>
    </div>
  </div>
</template>

<script setup>
import QuizContent from '@/components/quiz/QuizContent.vue'
import QuizOption from '@/components/quiz/QuizOption.vue'
import QuizButton from '@/components/quiz/QuizButton.vue'

import { ref, onMounted } from 'vue'
import { getQuizResult, getRandomQuiz } from '@/api/quizApi.js'
import { useUser } from '@/stores/user.js'
import router from '@/router/index.js'

const user = useUser()

const quiz = ref({
  quizId: 0,
  content: '지금 내 마음은?',
  options: [
    '안녕하세요',
    '여긴싸피에요',
    '살려주세요',
    '집에가고싶어'
  ]
})
const userAnswer = ref(0)
const isCommonSense = ref(0)

const isResult = ref(false)
const result = ref({
  answer: 0,
  userAnswers: [],
  isCommonSense: 0,
  notCommonSense: 0,
  total: 0
})

const onAnswerClick = async (index) => {
  if (isResult.value) {
    return
  }

  userAnswer.value = index + 1
  await submit()
}

const onButtonClick = async (val) => {
  if (isResult.value) {
    return
  }

  isCommonSense.value = val
  await submit()
}

const submit = async () => {
  if (userAnswer.value === 0 || isCommonSense.value === 0) {
    return
  }

  if (user.isLoggedIn) {
    // 로그인상태면 결과제출 api 호출
  }
  const data = await getQuizResult(quiz.value.quizId)
  console.log(data)

  if (data === null) {
    await router.push({ name: 'home' })
  }

  result.value.answer = data.answer
  result.value.userAnswers = data.userAnswers
  result.value.isCommonSense = data.isCommonSense
  result.value.notCommonSense = data.notCommonSense
  result.value.total = data.isCommonSense + data.notCommonSense

  if (!user.isLoggedIn) {
    result.value.total++
    result.value.userAnswers[userAnswer.value - 1]++
    isCommonSense.value ? result.value.isCommonSense++ : result.value.notCommonSense++
  }

  isResult.value = true
}

onMounted(async () => {
  const data = await getRandomQuiz()
  quiz.value.quizId = data.quizId
  quiz.value.content = data.content
  quiz.value.options[0] = data.option1
  quiz.value.options[1] = data.option2
  data.option4 ? quiz.value.options[3] = data.option4 : quiz.value.options.length = 3
  data.option3 ? quiz.value.options[2] = data.option3 : quiz.value.options.length = 2
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
}

.this-is {
  font-size: 20px;
}

.quiz-buttons {
  display: flex;
  gap: 20px;
}
</style>
