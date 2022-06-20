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
          <cite>用户信息</cite></a>
      </span>
  <button type="button" onclick="location.href='${ctx}/page/user/add.jsp'" class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"  ><i class="layui-icon"></i>增加住户</button>
  <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
    <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body" style="opacity: 0.85;">
  <div class="layui-row" style="" align="center">
    <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/user/search">
      <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
      <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
      <input type="text"  id = "names" name="name" style="width:50%;"  placeholder="请输入要查找的信息" autocomplete="off" class="layui-input">
      <button class="layui-btn" style="background-color: #248cf5;" lay-submit="" lay-filter="sreach"><i class="layui-icon"style="background-color: #248cf5;">&#xe615;</i></button>
      <select size='' id="selection" name='selection' multiple='multiple' style=" float: right" class="layui-input">
        <option  id = "se1" selected='selected' value="1" >以楼宇号查找</option>
        <option  id = "se2" value="2">以单元号查找</option>
        <option id = "se3" value="3">以房间查号查找</option>
        <option  id = "se4" value="4">以住户编号查找</option>
        <option id = "se5" value="5">以户主姓名查找</option>
      </select>
    </form>
  </div>

  <table class="layui-table">
    <thead>
    <tr>
      <th>住户编号</th>
      <th>小区编号</th>
      <th>楼宇编号</th>
      <th>单元编号</th>
      <th>房间编号</th>
      <th>户主姓名</th>
      <th>户主性别</th>
      <th>家庭电话1</th>
      <th>家庭电话2</th>
      <th>户主移动电话</th>
      <th>工作单位</th>
      <th>查看家庭成员</th>
      <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.L}" var="User" varStatus="stat">
      <tr>
        <td>${User.resi_info.hid}</td>
        <td>${User.address.communityNumber}</td>
        <td>${User.address.buildingNumber}</td>
        <td>${User.address.unitNumber}</td>
        <td>${User.address.roomNumber}</td>
        <td>${User.resi_info.houseOwnerName}</td>
        <td>${User.resi_info.houseOwnerGender}</td>
        <td>${User.resi_info.housePhoneNumber1}</td>
        <td>${User.resi_info.housePhoneNumber2}</td>
        <td>${User.resi_info.mobileNumber}</td>
        <td>${User.resi_info.workName}</td>
        <td><a href="${ctx}/user/familyMember?hid=${User.resi_info.hid }">查看</a></td>
        <td class="td-manage">
          <a title="编辑"  href="${ctx}/user/edit?id=${User.resi_info.hid }">
            <i class="layui-icon">&#xe642;</i>
          </a>
          <a title="删除" onclick="member_del(this,'${User.resi_info.hid }')" href="javascript:;">
            <i class="layui-icon">&#xe640;</i>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
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
  function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){

      if($(obj).attr('title')=='启用'){

        //发异步把用户状态进行更改
        $(obj).attr('title','停用')
        $(obj).find('i').html('&#xe62f;');

        $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
        layer.msg('已停用!',{icon: 5,time:1000});

      }else{
        $(obj).attr('title','启用')
        $(obj).find('i').html('&#xe601;');

        $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
        layer.msg('已启用!',{icon: 5,time:1000});
      }
    });
  }

  /*用户-删除*/
  function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
      //发异步删除数据
      //等以后再使用异步，这里先使用
      $.get("${ctx}/user/delete?id="+id);
      $(obj).parents("tr").remove();
      layer.msg('已删除!',{icon:1,time:1000});
    });
  }


  function delAll (argument) {

    var data = tableCheck.getData();

    layer.confirm('确认要删除吗？'+data,function(index){
      //捉到所有被选中的，发异步进行删除
      layer.msg('删除成功', {icon: 1});
      $(".layui-form-checked").not('.header').parents('tr').remove();
    });
  }

  $("#names").click(function (){
    var options=$("#selection option:selected").val();
            if(options == "2"){
              $('#names').attr('placeholder',"请输入要查找的单元号");
            }
            else if(options == "3"){
              $('#names').attr('placeholder',"请输入要查找的房间号");
            }
            else if(options == "4"){
              $('#names').attr('placeholder',"请输入要查找的住户编号");
            }
            else if(options == "5"){

              $('#names').attr('placeholder',"请输入要查找的户主姓名");
            }
            else{
              $('#names').attr('placeholder',"请输入要查找的楼宇号");
            }
  }
  )




</script>
<script>var _hmt = _hmt || []; (function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>