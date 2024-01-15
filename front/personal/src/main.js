import { createApp } from 'vue';
import App from "./App.vue";

//기본파일인 index.js를 사용하는 경우에는 디렉토리명만 임포트할 수 있습니다
import router from "./router";

const app = createApp(App);

app.use(router);

app.config.globalProperties.backURL = "http://localhost:8881";

app.mount("#app");