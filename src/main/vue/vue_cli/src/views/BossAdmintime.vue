<template>
    <div class="bosslogin">

        <Boss></Boss>
        <br><br>
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
                        :current-page="pageNo"
                        :page-sizes="pagesizes"
                        :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
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
        background-color: #dffff5;
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
                pagesizes:[5,10,20],
                total:10,
                pageSize:10,
                pageNo:1,
            }
        },
        components :{
            Boss
        },
        methods:{
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.pageSize = val;
                this.$axios.post('AdminController/selectadmintime',this.$qs.stringify(
                    {
                        pageSize:this.pageSize,
                        pageNo:this.pageNo
                    }
                )).then(response=>{      //返回值部分
                    this.usertime = response.data


                }).catch(error=>{
                    console.log(error)
                });

            },
            handleCurrentChange(val) {
                this.pageNo = val;
                console.log(`当前页: ${val}`);
                this.$axios.post('AdminController/selectadmintime',this.$qs.stringify(
                    {
                        pageSize:this.pageSize,
                        pageNo:this.pageNo
                    }
                )).then(response=>{      //返回值部分
                    this.usertime = response.data


                }).catch(error=>{
                    console.log(error)
                });

            }
        },
        created() {
            //    selectallcarthistory
            //进行条件查询
            this.$axios.post('AdminController/selectadmintime',this.$qs.stringify(
                {
                    pageSize:this.pageSize,
                    pageNo:this.pageNo
                }
            )).then(response=>{      //返回值部分
                this.usertime = response.data


            }).catch(error=>{
                console.log(error)
            });
            //查询总数

            this.$axios.post('AdminController/countadmintime',this.$qs.stringify(
                {

                }
            )).then(response=>{      //返回值部分
                this.total = response.data
                this.pagesizes.push(this.total)

            }).catch(error=>{
                console.log(error)
            });
        }
    }
</script>