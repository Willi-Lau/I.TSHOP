<template>
    <div class="cart_all">
        <div class="router_all_hrader">
            <span class="router_all_hrader_it">I.T</span>
            <el-dropdown class="router_all_hrader_dropdown-link">
                        <span class="el-dropdown-link">
                        <span style="color: black;font-size: 20px">服装种类</span><i class="el-icon-arrow-down el-icon--right"style="font-size: 20px;color: black"></i>
                        </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item class="router_all_hrader_dropdown-link_men">男装</el-dropdown-item>
                    <el-dropdown-item class="router_all_hrader_dropdown-link_women">女装</el-dropdown-item>
                    <el-dropdown-item class="router_all_hrader_dropdown-link_baby">童装</el-dropdown-item>


                </el-dropdown-menu>
                <div class="dropdown_img">
                    <img src="../assets/clothes/b1.jpg" alt="" width="100px" class="dropdown_img_men">
                    <img src="../assets/clothes/c1.jpg" alt="" width="100px" class="dropdown_img_women">
                    <img src="../assets/clothes/d1.jpg" alt="" width="100px" class="dropdown_img_baby">
                </div>
            </el-dropdown>

<!--            把购物车的内容进行渲染到用户界面-->
            <br><br><br><br><br>
            <div class="youcart">
                <ul>


                    <li v-for="(item,index) in youcartclothes" class="cart_buy_all">

                        <!--                               <div>{{item.id}}</div>-->
                        <img class="cart_buy_all_img" :src=item.clothes_src >
                        <div class="cart_buy_all_cloinf">
                            <div class="cart_buy_all_brand">{{item.clothes_brand}}</div>
                            <div class="cart_buy_all_inf">{{item.clothes_info}}</div>
                            <div class="cart_buy_all_money">超值售价 &nbsp;￥{{item.clothes_money}}.00</div>
                            <br>
                            <div class="cart_buy_all_num_1">
                                <div class="cart_buy_all_num">你购物车里的数量: {{item.cart_num}}</div>
                                <div class="cart_buy_all_num">单品总价 ￥{{item.cart_num*item.clothes_money}}.00</div>
                                <div class="cart_buy_add_cart">
                                    <el-button type="warning" icon="el-icon-minus" circle @click="cutcartmun(item.clothes_id,index)"></el-button>
                                    {{item.cart_num}}
                                    <el-button type="warning" icon="el-icon-plus" circle @click="addcartmun(item.clothes_id,index)"></el-button>
                                    <br><br>
                                    <el-button type="success" plain @click="removecart(item.clothes_id,index)">移除此物品</el-button>
                                </div>
                            </div>
                        </div>


                    </li>
                </ul>
                 <div class="cart_allmoney">
<!--                     结账-->
                    <span>你的购物车总价格
                     ￥{{this.cartallmoney}}.00</span>
                     <el-button class="pay" type="info" plain @click="paymoney()" style="{width: 100px}">付款</el-button>
                 </div>
                <div id="bottom"></div>
                <radio_group></radio_group>
                <Gotop></Gotop>

            </div>



        </div>


    </div>

</template>
<script>
    import radio_group from "../components/radio_group";
    import Gotop from "../components/Gotop";

    export default {
        inject:['reload'],
        data(){

            return{
                   name:this.$route.query.name,
                   youcartclothes:{},
                   cartallmoney:0
            }
        },
        components :{
            radio_group,
            Gotop
        },
        created() {
            //根据用户的name进行查询购物车的货物情况
            this.$axios.post('CartController/selectcartclothes',this.$qs.stringify(
                {
                    name:this.name
                }
            )).then(response=>{      //返回值部分
                this.youcartclothes = response.data;
                //把拿到的每个图片的格式转换为VUE可识别正确格式
                for(let i=0;i<this.youcartclothes.length;i++){
                    this.youcartclothes[i].clothes_src = require("../assets/clothes/"+this.youcartclothes[i].clothes_src);
                    console.log(this.youcartclothes[i].clothes_src)
                    //购物车总价格
                    this.cartallmoney += this.youcartclothes[i].cart_num * this.youcartclothes[i].clothes_money;
                }
            }).catch(error=>{
                console.log(error)
            });
        },
        methods:{
            removecart(clothes_id,index){


                //每日此点击从数据库减少值
                //根据用户的name进行查询购物车的货物情况
                this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                    {
                        name:this.name,
                        clothes_id:clothes_id,
                        num:-this.youcartclothes[index].cart_num
                    }
                )).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });
                this.cartallmoney -= this.youcartclothes[index].clothes_money *this.youcartclothes[index].cart_num;
                //移除购物车
                this.youcartclothes.splice(index,1)
            },
            cutcartmun(clothes_id,index){


                if(this.youcartclothes[index].cart_num>0){
                    //每日此点击从数据库减少值
                    //根据用户的name进行查询购物车的货物情况
                    this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                        {
                            name:this.name,
                            clothes_id:clothes_id,
                            num:-1
                        }
                    )).then(response=>{      //返回值部分

                    }).catch(error=>{
                        console.log(error)
                    });

                    this.youcartclothes[index].cart_num -= 1;

                    this.cartallmoney -= this.youcartclothes[index].clothes_money;
                }

                if(this.youcartclothes[index].cart_num === 0){
                   this.youcartclothes.splice(index,1)
                }

            },
            addcartmun(clothes_id,index){

                //每日此点击从数据库减少值
                //根据用户的name进行查询购物车的货物情况
                this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                    {
                        name:this.name,
                        clothes_id:clothes_id,
                        num:1
                    }
                )).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });
                this.youcartclothes[index].cart_num += 1;
                this.cartallmoney += this.youcartclothes[index].clothes_money;

            },
            paymoney(){
                //

                //向后台发送用户名，清空该用户的购物车信息
                this.$axios.post('CartController/paycartclothes',this.$qs.stringify(
                    {
                        name:this.name,

                    }
                )).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });
                //修改该用户的消费总金额
                this.$axios.post('CartController/grossmoney',this.$qs.stringify(
                    {
                        name:this.name,
                        grossmoney:this.cartallmoney
                    }
                )).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });

                this.$alert('恭喜您消费CNY:'+this.cartallmoney+'元，欢迎下次光临I.T旗舰店', '购买成功', {
                    confirmButtonText: '确定',

                });
                //跳转到主界面
                this.$router.push({
                    path:'/Index',
                    query:{
                        name:this.name
                    }
                })



            }
        }
    }
</script>
<style scoped>
    @import "../css/Router.css";
    @import "../css/Cart.css";
</style>
