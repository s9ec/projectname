&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-body">
    <form class="layui-form" method="POST" id="addMember"  action="${ctx}/user/addMember">
        <input type="hidden" name= "hid"  id="hid" value="${sessionScope.currentId}">
        <div class="layui-form-item">
         <%--@declare id="性别"--%><%--@declare id="姓名"--%><%--@declare id="家庭关系"--%><%--@declare id="工作单位"--%><label for="姓名" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" required=""
                       autocomplete="off" class="layui-input">
            </div>

            <label for="性别" class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-inline">
                <select name="gender" id="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <label for="家庭关系" class="layui-form-label">
                <span class="x-red">*</span>家庭关系
            </label>
            <div class="layui-input-inline">
                <input type="text" id="relation" name="relation" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>

            <label for="工作单位" class="layui-form-label">
                <span class="x-red">*</span>工作单位
            </label>
            <div class="layui-input-inline">
                <input type="text" id="workplace" name="workplace" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <%--@declare id="l_repass"--%><%--@declare id="户主姓名"--%><label for="户主姓名" class="layui-form-label">
                <span class="x-red">*</span>移动电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="mobileNumber" name="mobileNumber" required="" lay-verify="number"
                       autocomplete="off" class="layui-input">
            </div>

            <label for="户主姓名" class="layui-form-label">
                <span class="x-red">*</span>传呼
            </label>
            <div class="layui-input-inline">
                <input type="text" id="fax" name="fax" required="" lay-verify="number"
                       autocomplete="off" class="layui-input">
            </div>
            <label for="L_repass" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="add" lay-submit=""/>

        </div>
    </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){

            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                document.getElementById('addMember').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);

            });
            return false;
        });


    });


</script>

</body>

</html>