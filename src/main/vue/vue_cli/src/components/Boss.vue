<template>
    <div class="boss">
         <div class="boss_header">
                <span class="boss_header_it">I.T后台管理系统</span>
         </div>
         <div class="boss_left">
            <el-row class="tac">

                <el-col :span="12">

                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            @open="handleOpen"
                            @close="handleClose"
                            background-color="#545c64"
                            text-color="#fff"
                            active-text-color="#ffd04b">
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>服装仓库</span>
                            </template>

                            <el-menu-item-group >
                                <el-menu-item index="1-3" @click="goaddclothes">增加商品</el-menu-item>
                                <el-menu-item index="1-4" @click="goallclothes">总览仓库</el-menu-item>
<!--                                <el-menu-item index="1-5">条件筛选</el-menu-item>-->
                            </el-menu-item-group>

                        </el-submenu>
                        <el-submenu index="2">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>用户管理</span>
                            </template>

                            <el-menu-item-group >
                                <el-menu-item index="2-3" @click="goBossUser">用户名单</el-menu-item>
                                <el-menu-item index="2-4" @click="goBossUserCartHistory">用户消费历史记录</el-menu-item>
                                <el-menu-item index="2-5" @click="goUsertime">用户登陆历史</el-menu-item>
                            </el-menu-item-group>

                        </el-submenu>
                        <el-submenu index="3">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>管理员</span>
                            </template>

                            <el-menu-item-group >
                                <el-menu-item index="3-3" @click="goadmininf">管理员信息</el-menu-item>
                                <el-menu-item index="3-4" @click="goadmintime">管理员登陆历史</el-menu-item>
                            </el-menu-item-group>


                        </el-submenu>

                        <el-submenu index="4">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>可视化数据</span>
                            </template>

                            <el-menu-item-group >
                                <el-menu-item index="4-3" @click="goBossUserpoint">I.T&i.t</el-menu-item>
                            </el-menu-item-group>

                        </el-submenu>
                        <el-submenu index="5">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>跳转</span>
                            </template>

                            <el-menu-item-group >
                                <el-menu-item index="5-3" @click="gologin">登陆界面</el-menu-item>
                            </el-menu-item-group>

                        </el-submenu>
                    </el-menu>
                </el-col>
            </el-row>
        </div>
        <div class="boss_header_2">
             <sapn>welcome {{name}}</sapn>
        </div>


    </div>

</template>
<style scoped>
    @import "../css/Boss.css";

</style>
<script>
    export default {
        data(){

            return{
                name:this.$route.query.name

            }
        },
        components :{

        },
        methods:{
            goUsertime(){
                this.$router.push("/BossUsertime");
            },
            goadmintime(){
                this.$router.push("/BossAdmintime");
            },
            goBossUserCartHistory(){
                this.$router.push("/BossUserCartHistory");
            },
            goBossUserpoint(){
                this.$router.push("/BossUserPoint");
            },
            goaddclothes(){
                this.$router.push("/BossAddClothes");
            },
            goadmininf(){
                this.$router.push("/BossAdmin");
            },
            goallclothes(){
                this.$router.push("/BossLogin");
            },
            goBossUser(){
                this.$router.push("/BossUser");
            },
            gologin(){
                this.$router.push("/");
            },
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>