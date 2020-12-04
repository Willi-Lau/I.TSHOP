<template>
    <div>
        <div class="gotop">
            <a href="#">
                <div>
                    <el-button type="success" icon="el-icon-top" circle style="font-size: 30px"></el-button>
                </div>
            </a>
        </div>
        <div class="gobottom">
            <a href="#bottom">
                <div>
                    <el-button type="danger" icon="el-icon-bottom" circle style="font-size: 30px"></el-button>
                </div>
            </a>
        </div>

    </div>

</template>

<style>
    .gotop{
        position: fixed;
        right: 40px;
        top: 250px;
    }
    .gobottom{
        position: fixed;
        right: 40px;
        top: 330px;
    }

</style>