<template>
    <div class="router_all">
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
        </div>
        <div class="router_buy_all">
            <el-tabs type="border-card" @tab-click="clear()">
                <el-tab-pane >
                    <span slot="label"><i class="el-icon-date"></i> 男装</span>
                   <div class="router_buy_all_man">
                       <ul>


                           <li v-for="(item,index) in men_clothes" class="router_buy_all">

<!--                               <div>{{item.id}}</div>-->
                               <img class="router_buy_all_img" :src=item.src >
                               <div class="router_buy_all_brand">{{item.brand}}</div>
                               <div class="router_buy_all_inf">{{item.info}}</div>
                               <div class="router_buy_all_money">超值售价 &nbsp;￥{{item.money}}.00</div>
                               <div class="router_buy_all_num">库存: {{item.num}}</div>
                               <div class="add_cart">
                                   <el-button type="warning" icon="el-icon-minus" circle @click="cutcartmun_men(index)"></el-button>
                                   {{item.cart_num}}
                                   <el-button type="warning" icon="el-icon-plus" circle @click="addcartmun_men(index)"></el-button>
                                   <br>
                                   <br>
                                   <br>
                                   <el-button type="success" plain  @click="addtocart_men(item.cart_num,item.id,index)">添加到购物车</el-button>

                                   <el-button type="success" plain @click="paymoney()">查看购物车</el-button>
                               </div>

                           </li>
                       </ul>
                   </div>
                </el-tab-pane>

                <el-tab-pane label="女装"  >
                    <div class="router_buy_all_woman">
                        <ul>


                            <li v-for="(item,index) in women_clothes" class="router_buy_all">

                                <!--                               <div>{{item.id}}</div>-->
                                <img class="router_buy_all_img" :src=item.src >
                                <div class="router_buy_all_brand">{{item.brand}}</div>
                                <div class="router_buy_all_inf">{{item.info}}</div>
                                <div class="router_buy_all_money">超值售价 &nbsp;￥{{item.money}}.00</div>
                                <div class="router_buy_all_num">库存: {{item.num}}</div>
                                <div class="add_cart">
                                    <el-button type="warning" icon="el-icon-minus" circle @click="cutcartmun_women(index)"></el-button>
                                    {{item.cart_num}}
                                    <el-button type="warning" icon="el-icon-plus" circle @click="addcartmun_women(index)"></el-button>
                                    <br>
                                    <br>
                                    <br>
                                    <el-button type="success" plain  @click="addtocart_women(item.cart_num,item.id,index)">添加到购物车</el-button>

                                    <el-button type="success" plain @click="paymoney()">查看购物车</el-button>
                                </div>

                            </li>
                        </ul>
                    </div>
                </el-tab-pane>

                <el-tab-pane label="童装"  >
                    <div class="router_buy_all_baby">
                        <ul>


                            <li v-for="(item,index) in baby_clothes" class="router_buy_all">

                                <!--                               <div>{{item.id}}</div>-->
                                <img class="router_buy_all_img" :src=item.src >
                                <div class="router_buy_all_brand">{{item.brand}}</div>
                                <div class="router_buy_all_inf">{{item.info}}</div>
                                <div class="router_buy_all_money">超值售价 &nbsp;￥{{item.money}}.00</div>
                                <div class="router_buy_all_num">库存: {{item.num}}</div>
                                <div class="add_cart">
                                    <el-button type="warning" icon="el-icon-minus" circle @click="cutcartmun_baby(index)"></el-button>
                                    {{item.cart_num}}
                                    <el-button type="warning" icon="el-icon-plus" circle @click="addcartmun_baby(index)"></el-button>
                                    <br>
                                    <br>
                                    <br>
                                    <el-button type="success" plain  @click="addtocart_baby(item.cart_num,item.id,index)">添加到购物车</el-button>

                                    <el-button type="success" plain @click="paymoney()">查看购物车</el-button>
                                </div>
                            </li>
                        </ul>
                    </div>
                </el-tab-pane>

                <el-tab-pane label="条件筛选" >
                    <div class="router_buy_all_dream">
<!--                        条件-->
                        <div class="dream_type" >
                            <el-form ref="form" :model="form" label-width="80px">

                                <el-form-item label="选择品牌">
                                    <el-select v-model="form.brand" placeholder="请选择品牌" style="margin-left: 20px">
                                        <el-option label="全部品牌" value="全部品牌"></el-option>
                                        <ul v-for="(item,index) in brand_clothes" >

                                                <el-option :label="item" :value="item"></el-option>


                                        </ul>

                                    </el-select>
                                </el-form-item>


                                <el-form-item label="衣服种类">
                                    <el-radio-group v-model="form.resource">
                                        <el-radio label="男"></el-radio>
                                        <el-radio label="女"></el-radio>
                                        <el-radio label="童"></el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <div class="block">
                                    <span>价钱区间:{{this.form.money}}</span>
                                    <el-slider
                                            v-model="form.money"
                                            :max=this.max_money

                                            range
                                            show-input

                                    >
                                    </el-slider>

                                </div>
                                <el-form-item class="router_dream_button">
                                    <el-button type="primary" @click="onSubmit">查询</el-button>
<!--                                    <el-button @click="resetForm('form')">清空</el-button>-->
                                </el-form-item>
                            </el-form>
                            <br><br><br><br>

                            <div class="jieguo">
                                <ul>


                                    <li v-for="(item,index) in brand_clothes_inf" class="router_buy_all">


                                        <img class="router_buy_all_img" :src=item.src >
                                        <div class="router_buy_all_brand">{{item.brand}}</div>
                                        <div class="router_buy_all_inf">{{item.info}}</div>
                                        <div class="router_buy_all_money">超值售价 &nbsp;￥{{item.money}}.00</div>
                                        <div class="router_buy_all_num">库存: {{item.num}}</div>
                                        <div class="add_cart">
                                            <el-button type="warning" icon="el-icon-minus" circle @click="cutcartmun_dream(index,item.type)"></el-button>
                                            {{item.cart_num}}
                                            <el-button type="warning" icon="el-icon-plus" circle @click="addcartmun_dream(index,item.type)"></el-button>
                                            <br>
                                            <br>
                                            <br>
                                            <el-button type="success" plain  @click="addtocart_dream(item.cart_num,item.id,index,item.type)">添加到购物车</el-button>

                                            <el-button type="success" plain @click="paymoney()">查看购物车</el-button>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
<!--引入侧边栏-->
        <radio_group></radio_group>
        <!--        回到顶部-->
        <Gotop></Gotop>

        <div id="bottom"></div>

    </div>


</template>

<style scoped>
    @import "../css/Router.css";
</style>

<script>
    import $ from 'jquery'
    import radio_group from '../components/radio_group'
    import  Gotop from '../components/Gotop'
    export default {
        data() {

            return {

                name:this.$route.query.name,
                men_clothes:{},
                women_clothes:{},
                baby_clothes:{},
                num:1,

                brand_clothes:{},
                max_money:'',
                brand_clothes_inf:{},

                form: {
                    id: null,
                    resource: "男",
                    brand: "全部品牌",
                    money: ''


                }

            }
        },
        components:{
            radio_group,
            Gotop
        },
        methods:{
            clear(){
                //条件查询
                //清空
                this.brand_clothes_inf.cart_num = 0;
                //条件查询衣服

                this.$axios.post('ClothesController/select_dreamclothes',this.$qs.stringify(
                    {
                        form:this.form
                    }
                )).then(response=>{      //返回值部分
                    this.brand_clothes_inf = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.brand_clothes_inf.length;i++){
                        this.brand_clothes_inf[i].src = require("../assets/clothes/"+this.brand_clothes_inf[i].src);
                        console.log(this.brand_clothes_inf[i])
                    }
                }).catch(error=>{
                    console.log(error)
                });
                //男
                //清空
                this.men_clothes.cart_num = 0;
                //重新查询数量，并返回

                //男装所有
                this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                    {
                        sex:"男"
                    }
                )).then(response=>{      //返回值部分
                    this.men_clothes = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.men_clothes.length;i++){
                        this.men_clothes[i].src = require("../assets/clothes/"+this.men_clothes[i].src);
                        console.log(this.men_clothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });
                //女

                //清空
                this.women_clothes.cart_num = 0;
                //重新查询数量，并返回

                //女装所有
                this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                    {
                        sex:"女"
                    }
                )).then(response=>{      //返回值部分
                    this.women_clothes = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.women_clothes.length;i++){
                        this.women_clothes[i].src = require("../assets/clothes/"+this.women_clothes[i].src);
                        console.log(this.women_clothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });
                //童
//清空
                this.baby_clothes.cart_num = 0;
                //重新查询数量，并返回

                //童装所有
                this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                    {
                        sex:"童"
                    }
                )).then(response=>{      //返回值部分
                    this.baby_clothes = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.baby_clothes.length;i++){
                        this.baby_clothes[i].src = require("../assets/clothes/"+this.baby_clothes[i].src);
                        console.log(this.baby_clothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });

            },
            //查看购物车
            paymoney(){
                this.$router.push({path:"/Cart",
                    query:{
                        name:this.name
                    }}

                );
            },
            cutcartmun_dream(index,type){
                if(type == "男")
                {
                    this.cutcartmun_men(index)
                }
                if(type == "女"){
                    this.cutcartmun_women(index)
                }
                if(type == "童"){
                    this.cutcartmun_baby(index)
                }
            },
            addcartmun_dream(index,type){


                if(type == "男")
                {
                    this.addcartmun_men(index)
                }
                if(type == "女"){
                    this.addcartmun_women(index)
                }
                if(type == "童"){
                    this.addcartmun_baby(index)

                }
            },
            //brand_clothes_inf
            addcartmun_men(index){
                if(this.men_clothes[index].cart_num < this.men_clothes[index].num){
                this.men_clothes[index].cart_num += 1;
                }
                if(this.brand_clothes_inf[index].cart_num < this.brand_clothes_inf[index].num){
                    this.brand_clothes_inf[index].cart_num += 1;
                }
            },
            cutcartmun_men(index){
                if(this.men_clothes[index].cart_num >0){
                this.men_clothes[index].cart_num -= 1;
                }
                if(this.brand_clothes_inf[index].cart_num >0){
                    this.brand_clothes_inf[index].cart_num -= 1;
                }
            },
            addcartmun_women(index){
                if(this.women_clothes[index].cart_num < this.women_clothes[index].num){
                    this.women_clothes[index].cart_num += 1;
                }
                if(this.brand_clothes_inf[index].cart_num < this.brand_clothes_inf[index].num){
                    this.brand_clothes_inf[index].cart_num += 1;
                }
            },
            cutcartmun_women(index){
                if(this.women_clothes[index].cart_num >0){
                    this.women_clothes[index].cart_num -= 1;
                }
                if(this.brand_clothes_inf[index].cart_num >0){
                    this.brand_clothes_inf[index].cart_num -= 1;
                }
            },
            addcartmun_baby(index){
                if(this.baby_clothes[index].cart_num < this.baby_clothes[index].num){
                    this.baby_clothes[index].cart_num += 1;

                }
                if(this.brand_clothes_inf[index].cart_num < this.brand_clothes_inf[index].num){
                    this.brand_clothes_inf[index].cart_num += 1;

                }
            },
            cutcartmun_baby(index){
                if(this.baby_clothes[index].cart_num >0){
                    this.baby_clothes[index].cart_num -= 1;
                }
                if(this.brand_clothes_inf[index].cart_num >0){
                    this.brand_clothes_inf[index].cart_num -= 1;
                }
            },
            //添加到购物车，条件筛选
            addtocart_dream(cart_num,id,index,type){
                //写入数据库
                this.$axios.post('CartController/addtocart',this.$qs.stringify(
                    {
                        name:this.name,
                        cart_num:cart_num,
                        id:id
                    }
                )).then(response=>{
                }).catch(error=>{
                    console.log(error)
                });
                //清空
                this.brand_clothes_inf[index].cart_num = 0;
                //条件查询衣服

                this.$axios.post('ClothesController/select_dreamclothes',this.$qs.stringify(
                    {
                        form:this.form
                    }
                )).then(response=>{      //返回值部分
                    this.brand_clothes_inf = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.brand_clothes_inf.length;i++){
                        this.brand_clothes_inf[i].src = require("../assets/clothes/"+this.brand_clothes_inf[i].src);
                        console.log(this.brand_clothes_inf[i])
                    }
                }).catch(error=>{
                    console.log(error)
                });
            },
            //添加到购物车   男
            addtocart_men(cart_num,id,index){
                //写入数据库
                this.$axios.post('CartController/addtocart',this.$qs.stringify(
                    {
                        name:this.name,
                        cart_num:cart_num,
                        id:id
                    }
                )).then(response=>{
                }).catch(error=>{
                    console.log(error)
                });

                //清空
                this.men_clothes[index].cart_num = 0;
                //重新查询数量，并返回

                    //男装所有
                    this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                        {
                            sex:"男"
                        }
                    )).then(response=>{      //返回值部分
                        this.men_clothes = response.data;
                        //把拿到的每个图片的格式转换为VUE可识别正确格式
                        for(let i=0;i<this.men_clothes.length;i++){
                            this.men_clothes[i].src = require("../assets/clothes/"+this.men_clothes[i].src);
                            console.log(this.men_clothes[i].src)
                        }
                    }).catch(error=>{
                        console.log(error)
                    });

            },
            //添加到购物车  女
            addtocart_women(cart_num,id,index){
                //写入数据库
                this.$axios.post('CartController/addtocart',this.$qs.stringify(
                    {
                        name:this.name,
                        cart_num:cart_num,
                        id:id
                    }
                )).then(response=>{
                }).catch(error=>{
                    console.log(error)
                });

                //清空
                this.women_clothes[index].cart_num = 0;
                //重新查询数量，并返回

                //女装所有
                this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                    {
                        sex:"女"
                    }
                )).then(response=>{      //返回值部分
                    this.women_clothes = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.women_clothes.length;i++){
                        this.women_clothes[i].src = require("../assets/clothes/"+this.women_clothes[i].src);
                        console.log(this.women_clothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });

            },
            //添加到购物车   baby
            addtocart_baby(cart_num,id,index){
                //写入数据库
                this.$axios.post('CartController/addtocart',this.$qs.stringify(
                    {
                        name:this.name,
                        cart_num:cart_num,
                        id:id
                    }
                )).then(response=>{
                }).catch(error=>{
                    console.log(error)
                });

                //清空
                this.baby_clothes[index].cart_num = 0;
                //重新查询数量，并返回

                //童装所有
                this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                    {
                        sex:"童"
                    }
                )).then(response=>{      //返回值部分
                    this.baby_clothes = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.baby_clothes.length;i++){
                        this.baby_clothes[i].src = require("../assets/clothes/"+this.baby_clothes[i].src);
                        console.log(this.baby_clothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });

            },

            onSubmit() {
                //条件查询衣服

                this.$axios.post('ClothesController/select_dreamclothes',this.$qs.stringify(
                    {
                        form:this.form
                    }
                )).then(response=>{      //返回值部分
                    this.brand_clothes_inf = response.data;
                    //把拿到的每个图片的格式转换为VUE可识别正确格式
                    for(let i=0;i<this.brand_clothes_inf.length;i++){
                        this.brand_clothes_inf[i].src = require("../assets/clothes/"+this.brand_clothes_inf[i].src);
                        console.log(this.brand_clothes_inf[i])
                    }
                }).catch(error=>{
                    console.log(error)
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            //男装所有
            this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                {
                    sex:"男"
                }
            )).then(response=>{      //返回值部分
                this.men_clothes = response.data;
                //把拿到的每个图片的格式转换为VUE可识别正确格式
                for(let i=0;i<this.men_clothes.length;i++){
                    this.men_clothes[i].src = require("../assets/clothes/"+this.men_clothes[i].src);
                    console.log(this.men_clothes[i].src)
                }
            }).catch(error=>{
                console.log(error)
            });
            //女装所有
            this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                {
                    sex:"女"
                }
            )).then(response=>{      //返回值部分
                this.women_clothes = response.data;
                //把拿到的每个图片的格式转换为VUE可识别正确格式
                for(let i=0;i<this.women_clothes.length;i++){
                    this.women_clothes[i].src = require("../assets/clothes/"+this.women_clothes[i].src);
                    console.log(this.women_clothes[i].src)
                }
            }).catch(error=>{
                console.log(error)
            });

            //童装所有
            this.$axios.post('ClothesController/selectallclothes',this.$qs.stringify(
                {
                    sex:"童"
                }
            )).then(response=>{      //返回值部分
                this.baby_clothes = response.data;
                //把拿到的每个图片的格式转换为VUE可识别正确格式
                for(let i=0;i<this.baby_clothes.length;i++){
                    this.baby_clothes[i].src = require("../assets/clothes/"+this.baby_clothes[i].src);
                    console.log(this.baby_clothes[i].src)
                }
            }).catch(error=>{
                console.log(error)
            });

            //所有的衣服品牌
            this.$axios.post('ClothesController/select_allclothesbrand',this.$qs.stringify(

            )).then(response=>{      //返回值部分
                this.brand_clothes = response.data;
                console.log(response.data)
            }).catch(error=>{
                console.log(error)
            });

            //衣服价格里最大值
            this.$axios.post('ClothesController/select_maxmoney',this.$qs.stringify(
                {}
            )).then(response=>{      //返回值部分
                this.max_money = response.data;
            }).catch(error=>{
                console.log(error)
            });



            //JQuery部分
            $(function(){
                 $('.router_all_hrader_dropdown-link_men').hover(
                     function () {
                        $('.dropdown_img_men').css('display','inline')
                     },
                     function () {
                         $('.dropdown_img_men').css('display','none')
                     }
                 )

                $('.router_all_hrader_dropdown-link_women').hover(
                    function () {
                        $('.dropdown_img_women').css('display','inline')
                    },
                    function () {
                        $('.dropdown_img_women').css('display','none')
                    }
                )

                $('.router_all_hrader_dropdown-link_baby').hover(
                    function () {
                        $('.dropdown_img_baby').css('display','inline')
                    },
                    function () {
                        $('.dropdown_img_baby').css('display','none')
                    }
                )



            })

        }
    };
</script>