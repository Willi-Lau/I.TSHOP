<template>

    <div class="all">
        <div class="h_header">
            <i class="el-icon-shopping-cart-2" ></i> <span class="left1">购物免费配送</span> <span class="right1">I.T有限公司</span>
        </div>
        <div class="header">
            <i class="el-icon-loading" ></i>
            <i class="el-icon-location" ></i>
            <i class="el-icon-mobile-phone" ></i>
            <i class="el-icon-tableware" ></i>
            <i class="el-icon-s-promotion" ></i>
            <i class="el-icon-grape" ></i>
            <i class="el-icon-ice-drink" ></i>
            <br>
            <el-link @click="address1" class="el1" style="color:white;">A BATHING APE®</el-link>
            <el-link @click="address2" class="el2" style="color:white;">NEIGHBORHOOD</el-link>
            <el-link @click="address3" class="el3" style="color:white;">VALENTINO</el-link>
            <el-link @click="address4" class="el4" style="color:white;">OAMC</el-link>
            <el-link @click="address5" class="el5" style="color:white;">MR. GENTLEMAN</el-link>
            <el-link @click="address6" class="el6" style="color:white;">CHILDREN</el-link>
            <el-link @click="address7" class="el7" style="color:white;">D'DEMOO</el-link>

        </div>
        <div class="main">
<!--            欢迎-->
            <div class="welcome">
               &nbsp;I.T&nbsp;
            </div>
            <div class="welcome2">


              <span>多元时尚灵感</span> <br><br>

                <span>A BATHING APE®</span>   <br><br>

                <span>ACNE STUDIOS</span>  <br><br>

                <span>OFF-WHITE c/o VIRGIL ABLOH™</span>  <br><br>

                <span>PLAY COMME des GARÇONS</span>   <br><br>

                <span>THOM BROWNE</span>  <br><br>
            </div>





        </div>
        <div class="green_pict">
            <img src="../assets/IThead.jpg" style="width: 100%">
        </div>

<!--        轮播图 -->
        <div id="all_lunbo">
            <div class="new">新品上市</div>
            <!-- 图片 -->
            <div id="all_img">

                <img src="../assets/Bape.jpg" alt="" id="img_01" class="img" @click="buy">
                <img src="../assets/offwhite2.jpg" alt="" id="img_02" class="img" @click="buy">
                <img src="../assets/offwhite.jpg" alt="" id="img_03" class="img" @click="buy">


            </div>
            <!-- 数字导播 -->
            <div id="num">
                <input type="button" value="1" class="num" id="num_1" style="border: none" >
                <input type="button" value="2" class="num" id="num_2" style="border: none">
                <input type="button" value="3" class="num" id="num_3" style="border: none">

            </div>
        </div>
            <div class="bape_offwhite_inf">

                    <div>A BATHING APE®</div>
                <br>
                    <div style="font-size: 10px">诞生于日本原宿的潮流品牌 A BATHING APE®
                        灵感来源于电影《猿人星球》，设计师 Nigo 从
                        中获取灵感于 1993 年创立品牌，并将电影中的
                        台词“Ape shall never kill ape”作为标语
                        大加推广。作为原宿文化的始祖， A BATHING
                        APE® 引领了街头潮流，其标识性迷彩印花和猿人
                        形象深入人心，形成自成一派不二风格。</div>
                <br>
                    <div class="block">

                    <el-rate
                            v-model="value2"
                            :colors="colors">
                    </el-rate>
                    </div>
                <br><br><br>



                <div>OFF-WHITE c/o VIRGIL ABLOH™</div>
                <br>
                <div style="font-size: 10px">美国品牌 OFF-WHITE c/o VIRGIL ABLOH™
                    于 2014 年由 Virgil Abloh 创办，行走于
                    街头文化与人气时尚之间，以当代元素诠释青年
                    文化，精细做工诠释潮流服饰，照片、画作和抢
                    眼的图形印花都是设计师的灵感源泉。白色条纹
                    和箭头图案则令其走红的代表设计。</div>
                <br>
                <div class="block1">

                    <el-rate
                            v-model="value21"
                            :colors="colors1">
                    </el-rate>
                </div>
            </div>
<!--        轮播图2-->
        <div class="index_img_002">
            <div class="wenzi_img002">热卖爆款</div>
            <br><br>
            <div class="index_img_002_b"></div>
            <el-carousel :interval="2000" type="card" height="600px">
                <el-carousel-item v-for="item in item1" :key="item">
                    <img :src="item.src" alt="" style="width: 100%" class="index_img_002_img" @click="buy">
                </el-carousel-item>
            </el-carousel>
        </div>

<!--       猜你喜欢-->
        <div class="index_you_like">
            <div class="wenzi_you_like">猜你喜欢</div>
            <div class="fengexian"></div>
            <div class="index_you_like_main">
                <div style="display: inline-block" class="m1 buy_pict" @click="buy">
                    <img src="../assets/c1.jpg" alt="" style="width: 200px">
                    <span class="c_head">A BATHING APE®</span><br>
                    <span class="c_main">Alpha Industries 联乘系列 Gradation Camo logo 印花 T 恤</span><br><br>
                    <span class="c_money">¥1999.00</span>

                </div>

                <div style="display: inline-block" class="m2 buy_pict" @click="buy">
                    <img src="../assets/c2.jpg" alt="" style="width: 200px">
                    <span class="c_head">JUNYA WATANABE</span><br>
                    <span class="c_main">Canada Goose 联乘系列 连帽羽绒服</span><br><br><br>
                    <span class="c_money">¥12,399.00</span>
                </div>

                <div style="display: inline-block" class="m3 buy_pict" @click="buy">
                    <img src="../assets/c3.jpg" alt="" style="width: 200px">
                    <span class="c_head">MR. GENTLEMAN</span><br>
                    <span class="c_main">拼色连帽外套</span><br><br><br>
                    <span class="c_money">¥16,899.00</span>
                </div>

                <div style="display: inline-block" class="m4 buy_pict" @click="buy">
                    <img src="../assets/c4.jpg" alt="" style="width: 200px">
                    <span class="c_head">D'DEMOO</span><br>
                    <span class="c_main">配围脖绗缝羽绒外套</span><br><br><br>
                    <span class="c_money">¥9,999.00</span>
                </div>

                <div style="display: inline-block" class="m5 buy_pict" @click="buy">
                    <img src="../assets/c5.jpg" alt="" style="width: 200px">
                    <span class="c_head">PortsPURE</span><br>
                    <span class="c_main">流苏坠饰撞色细节针织衫</span><br><br><br>
                    <span class="c_money">¥6,999.00</span></div>

                <div class="index_you_like_buynow" @click="buy">立即选购</div>

            </div>



        </div>
<!--        底部-->
        <div class="index_bottom">
            <div class="index_bottmo_logo">I.T</div>
            <span>© 2020采廷商贸（上海）有限公司</span>
            <span>服务条款</span>
            <span>隐私政策</span>
             <span>     Cookie政策</span>
              <span>    沪ICP备15007211号-3</span>
              <span>    上海工商</span>
             <span>     沪公网安备 31010102004473号</span>
            <div id="bottom"></div>
        </div>
<!--        侧边栏-->
        <radio_group></radio_group>
        <Gotop></Gotop>




    </div>




</template>
<script>
    import $ from 'jquery'
    import radio_group from '../components/radio_group'
    import Gotop from '../components/Gotop'
    export default {

        created() {
            //JQ
            $(function () {
                var time = null;
                var index = 0;
                var long = 3;
                //记录进入图片的次数
                var less = 0;

                //鼠标进入显示周围的框  5个衣服
                $('.index_you_like_main .buy_pict').hover(
                    function () {
                        //鼠标移入，显示
                         $(this).css("border","1px solid black")
                    },
                    function () {
                        //鼠标移出，不显示
                        $(this).css("border","none")
                    }
                )

                //立即选购
                $('.index_you_like_buynow').hover(
                    function () {
                        $(this).css({"background-color":"black","color":"white"})
                    },
                    function () {
                        $(this).css({"background-color":"white","color":"black"})
                    }
                )

                // 鼠标一次没进入时不触发自动轮播事件，再进入一次时开始自动轮播
                $('#all_lunbo').hover(
                    //鼠标移入，记录次数加一
                    function () {
                        clearInterval(time)
                        less += 1;
                    },
                    function () {
                        time = setInterval(function () {
                            img_go(index);
                            index++;
                            if (index === long) {
                                index = 0
                            }
                        }, 3000)
                    })

                // 一次没进入时候自动执行
                if (less === 0) {
                    $(function () {
                        time = setInterval(function () {
                            img_go(index);
                            index++;
                            if (index === long) {
                                index = 0
                            }
                        }, 3000)
                    })
                }

                // 设置图片播放事件,自动执行

                $('#num input').mouseover(function () {

                    //   获取此时鼠标所在Index
                    index = $('#num input').index(this);
                    // alert(index);
                    // 传入index 执行图片切换
                    $('#all_img').find('img').eq(index).css('z-index', 100).siblings().css('z-index', 1);

                })

                //根据index 切换图片
                function img_go(index) {
                    $('#all_img').find('img').eq(index).css('z-index', 100).siblings().css('z-index', 1);


                }

            });
        },
        data() {
            return {

                name:this.$route.query.name,
                isCollapse: true,
                item1:[
            {src : require("../assets/clothes/"+"c1.jpg")},
            {src : require("../assets/clothes/"+"c2.jpg")},
            {src : require("../assets/clothes/"+"b3.jpg")},
            {src : require("../assets/clothes/"+"b4.jpg")},
            {src : require("../assets/clothes/"+"b1.jpg")},

        ],      value1: null,
                value2: null,
                colors: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }
                ,value11: null,
                value21: null,
                colors1: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }

            };
        },
        components: {
            radio_group,
            Gotop
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            address1(){
                const h = this.$createElement;

                this.$notify({
                    title: 'A BATHING APE®',
                    message: h('i', { style: 'color: teal'}, 'A BATHING APE，又名Bape，是著名的日本里原宿潮流品牌，由NIGO在1993年11月创立。\n' +
                        '作为日本里原宿的旗帜品牌，A BATHING APE的全名是A Bathing Ape in Lukewater，意思是一只泡温泉的猿人，暗指安于现状，不思进取的东京年轻人。Bape的logo由里原宿重要人物中村晋一郎（SKATE THING）设计，其灵感来源于著名的科幻电影《人猿星球》。')
                });
            },
            address2(){
                const h = this.$createElement;

                this.$notify({
                    title: 'NEIGHBORHOOD',
                    message: h('i', { style: 'color: teal'}, 'Neighborhood起源于92年，原名为Neighborhood NYC (NEW YORK CITY)，简称NBHD, 原本在S\n' +
                        'OHO区的UNION里贩售。由于其当时的设计师是美国人的关系，所以初始的设计的风格在比较偏向于军事化的图案并兼备简约的涂鸦。\n' +
                        'Neighborhood在美国虽然未成为一级的大牌，不过出道至今，已进驻整个亚洲市场，尤其日本更是全民为之疯狂。Neighborhood于1994年在日本正式成立品牌（区别与美版Neighborhood NYC）。将版权及设计交付给日本人，所以在GRAPHIC上也带点日式的设计，简单的字体设计都可以看得出他们的用心和特性。'
                        )
                });
            },
            address3(){
                const h = this.$createElement;

                this.$notify({
                    title: 'VALENTINO'
                    ,
                    message: h('i', { style: 'color: teal'}, '\n' +
                        'Valentino（瓦伦蒂诺） [1]  是全球高级定制和高级成衣奢侈品品牌，产品包括，高级订制服、成衣以及一系列配饰，包括手袋、皮鞋、小型皮具、腰带、眼镜、腕表及香水。 [2-5] \n' +
                        'Valentino创作表达现代人本主义，着重穿戴者的个性。理念、产品、零售店都可找到相同的特质：从独一无二的高级定制作品到男女成衣系列及配饰，从眼镜到香熏和专门店，尽显Valentino气质优雅、清新脱俗、工艺卓越、与众不同的典范。\n')
                        });
            },
            address4(){
                const h = this.$createElement;

                this.$notify({
                    title: 'OAMC',
                    message: h('i', { style: 'color: teal'}, '由Supreme前任创意总监Luke Meir创立而成的美国时装品牌OAMC，一直遵循简主义美学设计，将潮流与高街时尚互相融合，体现“Tough High Fashion”品牌理念。OAMC秉承品牌风范的同时，融合了现代化的设计元素，带来全新时尚品味。每个款型都是自己手绘设计图，之后再经过精雕细琢最终呈现。而全钛结构、飞行员式、学院派以及复古样式等多元设计风格、元素将AMC 的理念精髓完美诠释，强调时尚外观与卓越功能的同等重要性。')});
            },
            address5(){
                const h = this.$createElement;

                this.$notify({
                    title: 'MR. GENTLEMAN',
                    message: h('i', { style: 'color: teal'}, 'MR.GENTLEMAN 由 Takeshi Osumi (aka BigO)与 Yuichi Yoshii 在 2012 年创立，品牌设计理念崇尚后现代主义，设计风格简约大气，融合了美式街头美学元素与日本时装的复古气质。全新店铺坐落于北京 CBD 商业区的银泰中心，其装修风格延续了品牌服饰设计中的简约风，以白色基调为主，讲究细节精致体现。产品方面，店铺内陈列了 MR.GENTLEMAN 最新一季节的服饰以及 Lifestyle 产品供顾客选购。\n' +
                        '\n' +
                        '')});
            },
            address6(){
                const h = this.$createElement;

                this.$notify({
                    title: 'CHILDREN',
                    message: h('i', { style: 'color: teal'}, 'AMIKI Children填补了儿童睡衣市场的空白，那里往往充满了普通卡通主题的睡衣和无透气，过于紧身且缺乏风格的无聊合成睡裙。AMIKI Children从经典的女孩和男孩的睡衣套装，舒适的睡袍到复古风格的精致睡裙，应有尽有。')});
            },
            address7(){
                const h = this.$createElement;

                this.$notify({
                    title: 'D\'DEMOO',
                    message: h('i', { style: 'color: teal'}, 'D\'DEMOO是韩国大茂旗下具有代表性的时尚设计师品牌，创意总监朴春茂是韩国时尚界的代表设计师，以独特的前卫风格享誉盛名。D\'DEMOO女装消费群体定位为彰显自我风格、对时尚敏感、追求与众不同风格并可以驾驭夸张设计的20-30岁女性。作为韩国知名设计师女装品牌，D\'DEMOO主打偏休闲的时尚女装，无论在产品的用色上还是款式上，都有品牌自身的个性，以时尚、个性、前卫、自由搭配为主，充分展示韩国的穿着方式，深受韩智敏、朴诗妍等一众韩国演艺名人的青睐。')});
            },
            buy(){
                this.$router.push({
                    path:'/Router',
                    query:{
                        name:this.name
                    }
                })
            }
        }
    };

</script>


<style scoped>
    @import '../css/Index.css';
</style>