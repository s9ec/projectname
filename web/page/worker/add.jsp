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
              background-image: url("${ctx}/pic/bb.png");
              background-repeat: no-repeat;
              background-size:100% 100%;
          }
      </style>
  </head>
  
  <body>
    <div class="x-body" style="opacity: 0.9;">

        <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="${ctx }/worker/list">首页</a>
        <a>
          <cite>添加员工</cite></a>
      </span>
        </div>

        <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/worker/insert">
        <input type="hidden" name="id" id="id" >
          <div class="layui-form-item" >
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
             
          </div>
            <div class="layui-form-item">
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-inline">
                    <select name="gender" id="gender">
                        <c:forEach items="${requestScope.dept_list}" var="line" varStatus="stat">
                            <option value="${line.id}">${line.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item" >
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>年龄
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="age" name="age" required="" lay-verify="number"
                           autocomplete="off" class="layui-input" onblur="isInteger(this.value)">
                    <span id="test" style="color: red">
                    </span>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>职位
                </label>
                <div class="layui-input-inline">
                    <select name="job" id="job">
                        <option value="保安">保安</option>
                        <option value="保洁">保洁</option>
                        <option value="维修员">维修员</option>
                        <option value="程序员">程序员</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item" >
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>基本工资
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="base_salary" name="base_salary" required="" lay-verify="number"
                           autocomplete="off" class="layui-input" onblur="isSalary(this.value)">
                    <span id="test02" style="color: red">

                    </span>
                </div>
            </div>


          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <input type="submit" value="提交" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="add" lay-submit=""/>
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
            	document.getElementById('deptForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
               
            });
            return false;
          });
          
          
        });

        function isInteger(obj) {
            reg = /^[-+]?\d+$/;
            if (!reg.test(obj)) {
                $("#test").html("<b>请输入数字</b>");
            } else {
                if(obj >99 || obj < 18){
                    $("#test").html("请输入18-99的数字");
                }
                 else
                $("#test").html("");
            }
            if(obj == ""){
                $("#test").html("");
            }
        }

        function isSalary(obj) {
            reg = /^[-+]?\d+$/;
            if (!reg.test(obj)) {
                $("#test02").html("<b>请输入数字</b>");
            } else {
                    $("#test02").html("");
            }
            if(obj == ""){
                $("#test02").html("");
            }
        }
    </script>
  </body>
</html>