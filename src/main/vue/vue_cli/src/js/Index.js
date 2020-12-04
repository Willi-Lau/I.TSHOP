
import $ from 'jquery'
export default {
    created() {
        $(function () {
            var time = null;
            var index = 0;
            var long = 3;
            //记录进入图片的次数
            var less = 0;

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
                        if (index == long) {
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
                        if (index == long) {
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
                "../assets/USA.jpg",
                "../assets/logo.png",
                "../assets/logo.png",
                "../assets/logo.png",
                "../assets/logo.png",
                "../assets/logo.png"
            ],      value1: null,
            value2: null,
            colors: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }
            ,value11: null,
            value21: null,
            colors1: ['#99A9BF', '#F7BA2A', '#FF9900']  // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }

        };
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        address(){
            alert(123)
        }
    }
};

