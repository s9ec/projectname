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
        <a href="${ctx}/user/list">首页</a>
        <a>
          <cite>编辑用户</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <form action="${ctx }/user/update" method="post" id="edition">
    <table class="layui-table">
        <thead>
        <tr>
            <th>住户编号</th>
            <th>小区编号</th>
            <th>楼宇编号</th>
            <th>单元编号</th>
            <th>房间编号</th>
            <th>户主姓名</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.e}" var="User" varStatus="stat">
            <tr>
                <td>
                    <input type="text" name="hid" value= ${User.resi_info.hid} readonly>
                </td>
                <td>
                    <input type="text" name="community_id" value= ${User.address.communityNumber} readonly>
                </td>
                <td>
                    <input type="text" name="building_id" value= ${User.address.buildingNumber} readonly>
                </td>
                <td>
                    <input type="text" name="unit_id" value= ${User.address.unitNumber} readonly>
                </td>
                <td><input type="text" name="room_id" value= ${User.address.roomNumber} readonly></td>
                <td><input type="text" name="household_name" value= ${User.resi_info.houseOwnerName}></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



        <table class="layui-table">
            <thead>
            <tr>
                <th>户主性别</th>
                <th>家庭电话1</th>
                <th>家庭电话2</th>
                <th>户主移动电话</th>
                <th>工作单位</th>
                <th></th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.e}" var="User" varStatus="stat">
                <tr>
                    <td>
                        <select name="sex" id="sex">
                            <option value="${User.resi_info.houseOwnerGender}">${User.resi_info.houseOwnerGender}</option>
                            <option value="${requestScope.theOther}">${requestScope.theOther}</option>
                        </select>
                    </td>
                    <td><input type="text" name="hPN" value= "${User.resi_info.housePhoneNumber1}"  required="" lay-verify="number" autocomplete="off"></td>
                    <td><input type="text" name="hPN2" value= "${User.resi_info.housePhoneNumber2}" required="" lay-verify="number"></td>
                    <td><input type="text" name="wPN" value= "${User.resi_info.mobileNumber}"  required="" lay-verify="number"> </td>
                    <td><input type="text" name="wN" value= "${User.resi_info.workName}" ></td>
                    <td><input type="submit" value="确认更改" class="layui-btn" style="background-color: #248cf5; margin-left:60px;"  lay-filter="edit" lay-submit=""/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </form>



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


    function member_update(){
        layer.confirm(function(index){
            layer.msg('更改成功!',{icon:1,time:1000});
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