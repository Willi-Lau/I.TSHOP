<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="block">
            <el-table
                    :data="usertime"
                    border
                    style="width: 100%">
                <el-table-column
                        prop="id"
                        label="编号"
                        width="380">
                </el-table-column>
                <el-table-column
                        prop="username"
                        label="姓名"
                        width="380">
                </el-table-column>
                <el-table-column
                        prop="time"
                        label="登陆时间"
                width="380px">
                </el-table-column>
            </el-table>
            <br>
            <div class="ye">

                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage4"
                        :page-sizes="[100, 200, 300, 400]"
                        :page-size="100"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="400">
                </el-pagination>
            </div>
        </div>



    </div>

</template>
<style scoped>
    @import "../css/BossLogin.css";
    .block{
        position: absolute;
        left: 100px;
    }
    .ye{
        position: relative;
        left: -30px;
    }
</style>
<script>
    import Boss from '../components/Boss'
    import $ from 'jquery'
    export default {
        data(){

            return{
                reverse: true,
                usertime:{},
                currentPage4: 1,
            }
        },
        components :{
            Boss
        },
        methods:{
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            }
        },
        created() {
            //    selectallcarthistory
            //进行条件查询
            this.$axios.post('UserController/selectusertime',this.$qs.stringify(
                {

                }
            )).then(response=>{      //返回值部分
                this.usertime = response.data
                console.log(this.usertime)

            }).catch(error=>{
                console.log(error)
            });
        }
    }
</script>