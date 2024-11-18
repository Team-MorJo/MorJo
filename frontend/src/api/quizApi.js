import axios from 'axios'

const BASE_URL = 'http://localhost:8080'

export const getRandomQuiz = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/quiz/random`)
    return response.data
  } catch (error) {
    console.error(error)
  }
}
