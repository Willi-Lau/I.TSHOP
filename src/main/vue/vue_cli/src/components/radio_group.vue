<template>
    <!--        侧边栏-->
    <div class="radio_group">
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;" class="radio">
            <el-radio-button :label="false" >展开</el-radio-button>
            <el-radio-button :label="true" >收起</el-radio-button>
        </el-radio-group>
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse"
                 background-color="#545c64"
                 text-color="#fff">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span slot="title">初始登陆</span>
                </template>
                <el-menu-item-group>

                    <el-menu-item index="1-1" @click="go_login">登陆页面</el-menu-item>
                    <el-menu-item index="1-2" @click="go_register">注册页面</el-menu-item>
                </el-menu-item-group>

            </el-submenu>
            <el-submenu index="2">
                <template slot="title">
                    <i class="el-icon-setting"></i>
                    <span slot="title">主要界面</span>
                </template>
                <el-menu-item-group>

                    <el-menu-item index="2-1" @click="go_main">主界面</el-menu-item>
                    <el-menu-item index="2-2" @click="go_router">服装界面</el-menu-item>
                </el-menu-item-group>

            </el-submenu>
            <el-submenu index="3">
                <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span slot="title">购物车与结算</span>
                </template>
                <el-menu-item-group>

                    <el-menu-item index="3-1" @click="gocart">购物车页面</el-menu-item>
                    <el-menu-item index="3-2" @click="gocart">结算页面</el-menu-item>
                </el-menu-item-group>

            </el-submenu>
<!--            <el-submenu index="4">-->
<!--                <template slot="title">-->
<!--                    <i class="el-icon-document"></i>-->
<!--                    <span slot="title">预留</span>-->
<!--                </template>-->
<!--                <el-menu-item-group>-->

<!--                    <el-menu-item index="4-1">预留</el-menu-item>-->
<!--                    <el-menu-item index="4-2">预留</el-menu-item>-->
<!--                </el-menu-item-group>-->

<!--            </el-submenu>-->


        </el-menu>
    </div>
</template>

<script>
    export default  {
        data(){
            return{
                isCollapse: true,
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
            },
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            go_login(){
                this.$router.push('/')
            },
            go_router(){
                this.$router.push({
                    path:'/Router',
                    query:{
                        name:this.name
                    }
                })
            },
            go_main(){
                this.$router.push({
                    path:'/Index',
                    query:{
                        name:this.name
                    }
                })
            },
            go_register(){
                this.$router.push('/Register')
            },
        }
    };
</script>
<style>
    .radio_group{
        position: fixed;
        left: 20px;
        top: 50px;
        z-index: 9999;
    }
</style>