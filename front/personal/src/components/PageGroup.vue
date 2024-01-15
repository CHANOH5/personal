<template lang="">
    <!-- <h1>{{startPage}}, {{endPage}}</h1> -->
    <div class="pagegroup">
        <ul class="pagination mx-auto">
            <li class="page-item">
                <router-link 
                    v-if= "startPage > 1"
                    class="page-link" 
                    :to="path + (startPage - 1)">
                    PREV
                </router-link>
            </li>

            <template  v-for="i in (endPage-startPage+1)">
                <li v-if="(i+startPage-1) == currentPage"
                    class="page-item active" 
                    aria-current="page">
                    <span class="page-link">{{i+startPage-1}}</span>
                </li>
                <li v-else
                    class="page-item">
                    <router-link 
                        class="page-link"            
                        :to="path+(i+startPage-1)">
                        {{i+startPage-1}}
                    </router-link>
                </li>
            </template>
            <li class="page-item"> 
                <router-link 
                    v-if= "totalPage > endPage"
                    class="page-link"  
                    :to="path+(endPage + 1)"
                    >
                    NEXT
                </router-link>
            </li>
           
        </ul>    
    </div>
</template>
<script>
export default {
    name: 'PageGroup',
    props: ["path", "currentPage", "totalPage", "startPage", "endPage"],
    data() {
        return {
            // startPage:0,
            // endPage:0
        }
    },
    methods: {
    },
    created(){
        // if(this.currentPage <=  this.totalPage){
        //     this.startPage = parseInt((this.currentPage - 1 ) / 5) * 5+1
        //     this.endPage = this.startPage + 5 - 1

        //     if(this.endPage>this.totalPage){
        //         this.endPage =this.totalPage
        //     }
        // }
    }
}
</script>
<style scoped>
    .pagegroup{
        margin-top : 100px;
        text-align: center;
    }
    ul.pagination{
        list-style-type: none;
        padding:0;
        text-align: center;
        display: inline-block;
        margin: 0;
    }
    li.page-item{
        /* display: inline; */
        display: inline-block;
        padding-right: 30px;
    }
    .page-link{
        cursor: pointer;
    }
</style>