&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>查看个人资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
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
    <form action="${ctx}/client/updateMyInfo?name=${requestScope.Users.name}" method="post" id="edition">
        <fieldset class="layui-elem-field">
            <legend>账号信息</legend>
            <div class="layui-field-box">
                <div class="layui-col-md12" style="margin-bottom: 10px; margin-top: 10px; margin-left: 15px;">
                    <div class="layui-form-item">
                        <label  class="layui-form-label" >
                            <span class="x-red">*</span>账号：
                        </label>
                        <div class="layui-input-inline" >
                            <input autocomplete="off" class="layui-input"
                                   type="text" name="names" value="${requestScope.Users.name}" disabled>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label  class="layui-form-label" >
                            <span class="x-red">*</span>密码：
                        </label>
                        <div class="layui-input-inline">
                            <input autocomplete="off" class="layui-input"
                                    type="text" name="pwd" value="${requestScope.Users.pwd}" >
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label  class="layui-form-label" >
                            <span class="x-red">*</span>账号类型：
                        </label>
                        <div class="layui-input-inline">
                            <input autocomplete="off" class="layui-input"
                                   type="text" name="kind" value="${requestScope.Users.kind}" disabled>
                        </div>
                    </div>

                </div>
            </div>
        </fieldset>

<div class="x-body">
        <fieldset class="layui-elem-field">
            <legend>个人信息</legend>
            <div class="layui-field-box">
                <div class="layui-col-md12" style="margin-bottom: 10px; margin-top: 10px; margin-left: 15px;">
                    <div class="layui-form-item">
                        <label  class="layui-form-label" >
                            <span class="x-red">*</span>姓名：
                        </label>
                        <div class="layui-input-inline">
                            <input autocomplete="off" class="layui-input" type="text" name="userName" value="${requestScope.Users.userName}">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label  class="layui-form-label" >
                            <span class="x-red">*</span>性别：
                        </label>
                        <div class="layui-input-inline">
                            <select name="gender" id="gender">
                                <option value="${requestScope.gender}">${requestScope.gender}</option>
                                <option value="${requestScope.theOther}">${requestScope.theOther}</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <input type="submit" value="确认" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="edit" lay-submit=""/>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<script>


    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(edit)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("确认成功", {icon: 6},function () {
                document.getElementById('edition').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
                window.parent.location.reload();
            });
            return false;
        });
    });



</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>