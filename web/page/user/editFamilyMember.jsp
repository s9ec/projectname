&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
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
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>编辑成员</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <form action="${ctx }/user/updateMember?id=${requestScope.memberId}" method="post" id="edition">
        <table class="layui-table">
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>家庭关系</th>
                <th>工作单位</th>
                <th>移动电话</th>
                <th>传呼</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="name" value= ${F.name}></td>
                    <td><select name="gender" id="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select></td>
                    <td><input type="text" name="relation" value= ${F.familyRelation}></td>
                    <td><input type="text" name="wp" value= ${F.workPlace}></td>
                    <td><input type="text" name="mobileNum" value= ${F.mobileNumber} lay-verify="number"></td>
                    <td><input type="text" name="chuanhu" value= ${F.chuanHu} lay-verify="number"> </td>
                    </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                <td><input type="submit" value="确认更改" class="layui-btn" style="background-color: #248cf5; margin-left:60px;"  lay-filter="edit" lay-submit=""/></td>
                </tr>
            </tbody>
        </table>
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
            layer.alert("更改成功", {icon: 6},function () {
                document.getElementById('edition').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
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