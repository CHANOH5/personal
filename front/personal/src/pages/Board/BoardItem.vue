<template>

    <tr>
        <td>{{ b.id }}</td>
        <td>{{ b.title }}</td>
        <td>{{ b.memberId }}</td>
        <td>{{ b.regDate }}</td>
    </tr>

</template>
<script>
export default {
    name: "BoardItem",
    props: ["b"],
    data() {},
    methods: {

    }

}
</script>
<style>
    
</style>