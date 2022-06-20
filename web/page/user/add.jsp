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

      <style>
          body{
              background-image: url("${ctx}/pic/d.png");
              background-repeat: no-repeat;
              background-size:100% 1500%;
          }
      </style>
  </head>
  
  <body>
  <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="${ctx}/user/list">首页</a>
        <a>
          <cite>添加用户</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
          <i class="layui-icon" style="line-height:38px">ဂ</i></a>
  </div>


    <div class="x-body" style="opacity: 0.85">
        <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/user/add">
        <input type="hidden" name="id" id="id" >
         <div class="layui-form-item">
              <label for="小区编号" class="layui-form-label">
                  <span class="x-red">*</span>小区编号
              </label>
              <div class="layui-input-inline">
                  <select name="community" id="community">
                      <option value="1">1</option>
                      <option value="2">2</option>
                  </select>
              </div>

              <label for="楼宇编号" class="layui-form-label">
                  <span class="x-red">*</span>楼宇编号
              </label>
              <div class="layui-input-inline">
                  <select name="building" id="building">
                      <option value="1">1</option>
                      <option value="2">2</option>
                  </select>
              </div>

                <label for="单元编号" class="layui-form-label">
                    <span class="x-red">*</span>单元编号
                </label>
                <div class="layui-input-inline">
                    <select name="unit" id="unit">
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                </div>

                <label for="房间编号" class="layui-form-label">
                    <span class="x-red">*</span>房间编号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="room" name="room" required="" lay-verify="number"
                           autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label for="户主姓名" class="layui-form-label">
                    <span class="x-red">*</span>户主姓名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="houseHoldName" name="houseHoldName" required="" lay-verify="required"
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

                <label for="家庭电话1" class="layui-form-label">
                    <span class="x-red">*</span>家庭电话1
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="homePN" name="homePN" required="" lay-verify="number"
                           autocomplete="off" class="layui-input">
                </div>

                <label for="家庭电话2" class="layui-form-label">
                    <span class="x-red">*</span>家庭电话2
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="homePN2" name="homePN2" required="" lay-verify="number"
                           autocomplete="off" class="layui-input">
                </div>

            </div>



            <div class="layui-form-item">
                <label for="移动电话" class="layui-form-label">
                    <span class="x-red">*</span>移动电话
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="mBP" name="mBP" required="" lay-verify="required|number"
                           autocomplete="off" class="layui-input">
                </div>

                <label for="工作单位" class="layui-form-label">
                    <span class="x-red">*</span>工作单位
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="workN" name="workN" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>

                <label for="工作电话" class="layui-form-label">
                    <span class="x-red">*</span>工作电话
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="wPN" name="wPN" required="" lay-verify="number"
                           autocomplete="off" class="layui-input">
                </div>

                <label for="工作地址" class="layui-form-label">
                    <span class="x-red">*</span>工作地址
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="wP" name="wP" required=""
                           autocomplete="off" class="layui-input">
                </div>

            </div>


          <div class="layui-form-item">
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