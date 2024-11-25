<template>
  <div class="container">
    <div class="title">닉네임을 정해주세요</div>
    <div class="nickname-container">
      <input type="text" v-model="nickname" class="nickname">
      <div v-show="error" class="error">{{ error }}</div>
    </div>
    <button class="register" @click="handleRegisterClick">가입하기</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { postJoin } from '@/api/userApi.js'
import router from '@/router/index.js'

const nickname = ref('')
const error = ref('')

const checkValidNickname = () => {
  if (!nickname.value) {
    error.value = '닉네임을 입력해주세요'
    return
  }

  const maxByte = 32
  let totalByte = 0
  for (let character of nickname.value) {
    totalByte += (character.charCodeAt(0)) >> 7 ? 2 : 1
    if (totalByte > maxByte) {
      error.value = '영문 32자, 한글 16자까지 입력 가능합니다'
      return
    }
  }

  const rNickname = /^[가-힣a-zA-Z0-9]*$/;
  if (!rNickname.test(nickname.value)) {
    error.value = '영문, 숫자, 완성형 한글만 사용 가능합니다'
    return
  }

  error.value = ''
}

const handleRegisterClick = async () => {
  checkValidNickname()
  if (error.value) {
    return
  }

  try {
    await postJoin(nickname.value)
    await router.push({
      name: 'home'
    })
  } catch (e) {
    if (e.message.include("중복")) {
      error.value = e.message;
      return
    }
    alert(e.message)
    await router.push({
      name: 'home'
    })
  }

}
</script>

<style scoped>
.container {
  padding-top: 80px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 16px;
  width: 20%;
  min-width: 250px;
}

.title {
  font-size: 24px;
  padding: 20px 0;
}

.nickname-container {
  display: flex;
  flex-direction: column;
  width: 100%;
}
.nickname {
  width: 100%;
  aspect-ratio: 7;
  padding: 0 8px;
  font-size: 16px;
}

.error {
  font-size: 12px;
  color: red;
}

.register {
  width: 100%;
  aspect-ratio: 7;
  border: 1px solid #000000;
}

.register:hover {
  border: 2px solid;
}
</style>
