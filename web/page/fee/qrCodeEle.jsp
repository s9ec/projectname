&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>缴纳费用</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>

<body background="${ctx}/pic/bk.jpg">
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body" >
    <div class="layui-row" style="" align="center" >
        <img src="${ctx}/pic/qrcode.jpg" alt="缴费" style="width: 220px; height: 220px; margin-top: 50px; margin-left: 40px">
    </div>
    <form id="editions" action="${ctx }/fee/payEle?record_id=${rid }&s=1" method="post">
        <table style="margin-top: 20px">
            <tr>
                <td style="visibility: hidden"><input   href="javascript:;"  type="submit" value="缴费失败" class="layui-btn" style="background-color: #248cf5; margin-left:60px;"></td>
                <!--这里的问题-->
                <td style="visibility: hidden"><input  href="javascript:;"  type="submit" value="缴费失败" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" ></td>

                <td style="visibility: hidden"><input   href="javascript:;"  type="submit" value="缴费失败" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" ></td>
                <td><input   href="javascript:;"  type="submit" value="缴费完成" class="layui-btn" style="background-color: #248cf5; margin-left:60px;"  lay-filter="edit" lay-submit=""/></td>

            </tr>
        </table>
    </form>
</div>
</body>

<script>

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(edit)', function(data){

            console.log(data);
            //发异步，把数据提交给php
            layer.alert("成功", {icon: 6},function () {
                // 获得frame索引

                var index = parent.layer.getFrameIndex(window.name);
                document.getElementById('editions').submit();

                //关闭当前frame
                parent.layer.close(index);
                window.parent.location.reload();
            });
            return false;
        });
    });
</script>

</html>