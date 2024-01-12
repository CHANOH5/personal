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
                    <BoardItem></BoardItem>
                    <!-- <AttendanceItem :a="a" v-if="attendanceList" v-for="a in attendanceList.content" :key="a.id" /> -->
                </tbody>
            </table>
        </div>
        <br />
        <div>페이징 처리 부분</div>
    </main>

</template>
<script>

import BoardItem from "./BoardItem.vue";

export default {

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