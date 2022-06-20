&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body{
            background-image: url("${ctx}/pic/f.png");
            background-repeat: no-repeat;
            background-size:100% 100%;
        }
    </style>
</head>

<body>
<div class="x-body" style="opacity: 0.9">

    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="${ctx }/worker/schedule">首页</a>
        <a>
          <cite>编辑排班表</cite></a>
      </span>
    </div>


    <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/worker/updateSchedule?day=${requestScope.day}">
        <div class="layui-form-item" >
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>值班保安
            </label>
            <div class="layui-input-inline">
                <select name="baoan" id="baoan">
                        <option value="${requestScope.current.baoan}">${requestScope.current.baoan}</option>
                    <c:forEach items="${requestScope.baoanji}" var="line" varStatus="stat">
                        <option value="${line}">${line}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item" >
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>值班保洁
            </label>
            <div class="layui-input-inline">
                <select name="baojie" id="baojie">
                    <option value="${requestScope.current.baojie}">${requestScope.current.baojie}</option>
                    <c:forEach items="${requestScope.baojieji}" var="line" varStatus="stat">
                        <option value="${line}">${line}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item" >
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>值班维修员
            </label>
            <div class="layui-input-inline">
                <select name="weixiu" id="weixiu">
                    <option value="${requestScope.current.weixiu}">${requestScope.current.weixiu}</option>
                    <c:forEach items="${requestScope.weixiuji}" var="line" varStatus="stat">
                        <option value="${line}">${line}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item" >
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>值班程序员
            </label>
            <div class="layui-input-inline">
                <select name="chengxu" id="chengxu">
                    <option value="${requestScope.current.chengxu}">${requestScope.current.chengxu}</option>
                    <c:forEach items="${requestScope.chengxuji}" var="line" varStatus="stat">
                        <option value="${line}">${line}</option>
                    </c:forEach>
                </select>
            </div>
        </div>




        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <input type="submit" value=" 确认" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="add" lay-submit=""/>
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
            layer.alert("修改成功", {icon: 6},function () {
                document.getElementById('deptForm').submit();
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