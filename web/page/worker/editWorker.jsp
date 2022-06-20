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
        <a href="${ctx }/worker/list">首页</a>
        <a>
          <cite>编辑信息</cite></a>
      </span>
</div>
<div class="x-body">
    <table class="layui-table">
        <form action="${ctx }/worker/update" id="edition">
        <thead>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>职位</th>
            <th>基本工资</th>
            <th>当月奖金</th>
            <th></th>
        </thead>
        <tbody>
        <tr>
                <input type="text" name="id" value="${editWorker.id}" style="visibility: hidden">
                <td><input type="text" name="name" value="${editWorker.name}"></td>
                <td><input type="text" name="age" value="${editWorker.age}"></td>
                <td><select name="kinds" id="kinds">
                    <option value="${requestScope.editWorker.kind}">${requestScope.editWorker.kind}</option>
                    <c:forEach items="${requestScope.jobs}" var="line" varStatus="stat">
                        <option value="${line}">${line}</option>
                    </c:forEach>
                </select></td>
                <td><input type="text" name="base_salary" value="${editWorker.base_salary}"></td>
                <td><input type="text" name="bonus" value="${editWorker.bonus}"></td>
                <td><input type="submit" value="确认更改" class="layui-btn" style="background-color: #248cf5; margin-left:60px;"  lay-filter="edit" lay-submit=""/></td>
            </tr>
        </tbody>
        </form>
    </table>
    <!--  <div class="page">
       <div>
         <a class="prev" href="">&lt;&lt;</a>
         <a class="num" href="">1</a>
         <span class="current">2</span>
         <a class="num" href="">3</a>
         <a class="num" href="">489</a>
         <a class="next" href="">&gt;&gt;</a>
       </div>
     </div> -->

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

    /*用户-停用*/

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