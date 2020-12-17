<template>
    <div>
        <div class="gotop">
            <a href="#">
                <div>
                    <el-button type="success" icon="el-icon-top" circle style="font-size: 30px"></el-button>
                </div>
            </a>
        </div>
        <div class="gobottom1">
            <a href="#bottom">
                <div>
                    <el-button type="success" icon="el-icon-bottom" circle style="font-size: 30px"></el-button>
                </div>
            </a>
        </div>

        <div class="goshoppingcart">

                <div>
                    <el-button type="danger" icon="el-icon-shopping-cart-2" circle style="font-size: 30px" @click="gocart"></el-button>
                </div>

        </div>

    </div>

</template>

<script>
    export default  {
        data(){
            return{

                name:this.$route.query.name
            }
        },

        methods:{
            gocart(){
                this.$router.push({
                    path:'/Cart',
                    query:{
                        name:this.name
                    }
                })
            }
        }
    };
</script>
<style>
    .gotop{
        position: fixed;
        right: 40px;
        top: 250px;
    }
    .gobottom1{
        position: fixed;
        right: 40px;
        top: 410px;

    }
    .goshoppingcart{
        position: fixed;
        right: 40px;
        top: 330px;
    }


</style>