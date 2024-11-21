import api from '@/api/api.js'

export const getRandomQuiz = async () => {
  try {
    const response = await api.get('/quiz/random')
    return response.data
  } catch (error) {
    return error.data
  }
}

export const getQuizResult = async (quizId) => {
  try {
    const response = await api.get(`/quiz/${quizId}/result`)
    return response.data
  } catch (error) {
    return error.data
  }
}

export const postQuizCreate = async (content, option1, option2, option3, option4, answer) => {
  try {
    const response = await api.post('/quiz/create', {
      content: content,
      option1: option1,
      option2: option2,
      option3: option3,
      option4: option4,
      answer: answer,
    })
    console.log(response.data);
    return response.data
  } catch (error) {
    return error.data
  }
}

