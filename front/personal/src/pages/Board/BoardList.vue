<template>

<main>
        <h3 class="title">게시판</h3>
       
        <div class="board">
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>게시자</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <BoardItem v-if="boardList" v-for="b in boardList.content" :key="b.id" :b="b"/>
                </tbody>
            </table>
        </div>
        <br />
        <PageGroup v-if="boardList" :path="'/board/'"
            :currentPage="$route.params.currentPage ? $route.params.currentPage : 1" :startPage="startPage"
            :endPage="endPage" :totalPage="boardList.totalPages" />
    </main>

</template>
<script>

import BoardItem from "./BoardItem.vue";
import PageGroup from "@/components/PageGroup.vue";
import axios from "axios";

export default {
    name: "BoardList",
    components: { BoardItem, PageGroup },
    data() {
        return {
            currentPage: 1,
            boardList: null,
            startPage: 1,
            endPage: 1,
        }
    },
    methods: {

        axiosHandler() {
            const url = `${this.backURL}/board/list`;
            axios
                .get(url)
                .then((response) => {

                    console.log(response.data);
                    this.boardList = response.data;

                    // this.boardList.id.sort((a, b) => {
                    //     return  b.id - a.id;
                    // })

                    if (this.currentPage <= this.boardList.totalPages) {
                        this.startPage = parseInt((this.currentPage - 1) / 5) * 5 + 1;
                        this.endPage = this.startPage + 5 - 1;

                        if (this.endPage > this.boardList.totalPages) {
                            this.endPage = this.boardList.totalPages;
                        }
                    }
                })
                .catch((error) => {
                    console.error("Error occurred:", error);
                });
        },

    },
    watch: {
        
        // --- 라우터값이 변경되었을 때 할 일 START ---
        // $route(newRoute, oldRoute) {
        //     console.log("라우터값이 변경" + newRoute.path + "," + oldRoute.path);
        //     if (newRoute.params.currentPage) {
        //         this.currentPage = newRoute.params.currentPage;
        //     } else {
        //         this.currentPage = 1;
        //     }
        // },
        // --- 라우터값이 변경되었을 때 할 일 END ---
    },
    created() {
        this.axiosHandler();
    }
}
</script>
<style scoped>

.title {
    text-align: center;
    font-size: 28px;
    color: #2c3e50;
    text-transform: uppercase;
    margin-top: 100px;
    margin-bottom: 20px;
    font-weight: bold;
    text-shadow: 1px 1px 1px #ccc;
}

.board {
    /* width: 90%; */
    width: 1050px;
    font-family: "Arial", sans-serif;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 20px;
    margin: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-left: 6%;
    /* width: 1450px; */
    /* max-width: 1300px; */
    /* width: 90% */
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
}

td {
    padding: 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

thead {
    text-align: center;
    background-color: #f5f5f5;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tbody tr:hover {
    background-color: #eaeaea;
}


</style>