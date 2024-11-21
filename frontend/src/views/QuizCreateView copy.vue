<template>
  <div>
    <textarea
      v-model="text"
      class="auto-grow"
      @input="autoResize"
      placeholder="내용을 입력하세요"
    ></textarea>
  </div>
</template>


<script>
export default {
  data() {
    return {
      text: "", // 입력된 텍스트를 저장
    };
  },
  methods: {
    autoResize(event) {
      const textarea = event.target;
      textarea.style.height = "auto"; // 기존 높이를 초기화
      textarea.style.height = ${textarea.scrollHeight}px; // 내용에 맞게 높이 조절
    },
  },
};
</script>


<style>
.auto-grow {
  width: 100%; /* 원하는 기본 너비 설정 /
  min-height: 50px; / 최소 높이 설정 /
  max-height: 500px; / 필요시 최대 높이 설정 /
  overflow-y: hidden; / 스크롤 숨기기 /
  border: 1px solid #ccc;
  padding: 10px;
  font-size: 16px;
  box-sizing: border-box; / 패딩 포함하여 크기 계산 */
}
</style>