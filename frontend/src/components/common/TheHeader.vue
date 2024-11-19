<template>
  <header class="header">
    <h1>너만모르조?</h1>
    <nav>문제등록 |
         <span @click="getKakaoAuth">로그인</span>
         | 내정보</nav>
  </header>
</template>

<script setup>
import { getKakaoAuth } from '@/api/oauthApi.js'

</script>

<style scoped>
.header {
  display: flex;
  flex-direction: column;
  gap: 8px;

  padding: 20px 0 12px 0;
}
</style>
