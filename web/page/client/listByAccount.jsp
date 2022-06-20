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
        <a href="${ctx }/account/list">首页</a>
        <a>
          <cite>用户查询</cite></a>
      </span>
    <button type="button" onclick="location.href='${ctx}/employee/add'" class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"  ><i class="layui-icon"></i>录入成员</button>
    <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right"href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">

    <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/account/searchAccount">
            <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
            <input type="text" id="name" name="name" style="width:50%;"  placeholder="请输入要查找的账号" autocomplete="off" class="layui-input">
            <button class="layui-btn" style="background-color: #248cf5;" lay-submit="" lay-filter="sreach"><i class="layui-icon" style="background-color: #248cf5;">&#xe615;</i></button>
        </form>
    </div>
    <fieldset class="layui-elem-field">
        <legend>账号一览</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <th>id</th>
                <th>账号</th>
                <th>密码</th>
                <th>账户类型</th>
                <th>操作</th>
                <c:forEach items="${requestScope.info}" var="user" varStatus="stat">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.pwd}</td>
                        <td>${user.kind}</td>
                        <td><a title="编辑"  href="${ctx}/user/getInfo?id=${user.id}">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                            <a title="删除" onclick="member_del(this,'${user.id }')" href="javascript:;">
                                <i class="layui-icon">&#xe640;</i>
                            </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </fieldset>
</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            //等以后再使用异步，这里先使用
            $.get("${ctx}/user/deleteUser?id="+id);
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>