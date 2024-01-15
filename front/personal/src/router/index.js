import { createRouter, createWebHistory } from "vue-router";

// import App from '/App.vue'
import BoardList from "@/pages/Board/BoardList.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/board/list", component: BoardList },
        { path: "/board/:currentPage", component: BoardList },
    ]
})

export default router;