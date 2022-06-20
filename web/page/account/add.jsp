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
        <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/account/insert">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>账号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required|nikename"
                  autocomplete="off" class="layui-input" >
                  <span id="remind"></span>
              </div>
             
          </div>
        <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="pwd" name="pwd" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" >
              </div>
             
          </div>

            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>确认密码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="pwd2" name="pwd2" required="" lay-verify="required|repass"
                           autocomplete="off" class="layui-input" >
                </div>

            </div>


            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>姓名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="userName" name="userName" required="" lay-verify="required"
                           autocomplete="off" class="layui-input" >
                </div>

            </div>

            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-inline">
                    <select name="gender" id="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>

            </div>

         <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>账号类型
              </label>
              <div class="layui-input-inline">
                  <select name="level" id="level">
                      <option value="1">管理员</option>
                      <option value="2">员工</option>
                      <option value="3">住户</option>
                  </select>
              </div>
             
          </div>
          <div  class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <input type="submit" value=" 提交" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="add" lay-submit=""/>
          </div>
      </form>
    </div>





    <script>

        $(function(){
            $("#name").blur(function(){
                var uname = $(this).val();
                if(uname==""){
                    $("#remind").html("");
                }else{
                    // $.ajax方法实现
                    $.ajax({
                        url:"${ctx}/account/judgeRepeat",
                        type:"get",
                        data:"uname="+uname,
                        dataType:"text",
                        async:false,
                        success:function(result){
                            $("#remind").html(result);
                        }
                    });
                }
            });



        });
    </script>

    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(){
                if($('#remind').html()==""){
                    return '账号不能为空'
                }
              else if($('#remind').html()=="账号已存在"){
                return '账号已存在';
              }
            }
            ,pass: [/(.+){1,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#pwd').val()!=$('#pwd2').val()){
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
    </script>
    
  </body>

</html>