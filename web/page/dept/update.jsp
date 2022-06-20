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
        <a href="${ctx }/dept/list">首页</a>
        <a>
          <cite>器材信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="background-color: #248cf5;line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
<%--    <div class="layui-row" style="" align="center">--%>
<%--        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/dept/list">--%>
<%--            <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">--%>
<%--            <input class="layui-input" placeholder="截止日" name="end" id="end"> -->--%>
<%--            <input type="text" name="content" style="width:50%;"  placeholder="请输入查找部门名称" autocomplete="off" class="layui-input">--%>
<%--            <button class="layui-btn" style="background-color: #248cf5;" lay-submit="" lay-filter="sreach"><i class="layui-icon" style="background-color: #248cf5;">&#xe615;</i></button>--%>
<%--            <select size='' name='' multiple='multiple' style="float: right" class="layui-input">--%>
<%--                <option selected='selected' >以设施编号查找</option>--%>
<%--                <option value="2">以设施名称查找</option>--%>
<%--                <option value="3">以设施价格查找</option>--%>
<%--            </select>--%>
<%--        </form>--%>
<%--    </div>--%>
    <%-- <xblock>
<!--        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
      <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/dept/add')"><i class="layui-icon"></i>添加</button>
      <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock> --%>
    <form action="${ctx}/dept/query">
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                设施编号
            </th>
            <th>设施名称</th>
            <th>承建商</th>
            <th>电话</th>
            <th>负责人</th>
            <th>设施管理人员</th>
            <th>设施金额</th>
            <th>  </th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.facilityAll}" var="dept" varStatus="stat">
            <tr>
                <td><input type="text" name="facility_id" value="${dept.facility_id}"></td>
                <td><input type="text"  name="facility_name" value="${dept.facility_name}"></td>
                <td><input type="text" name="facility_business" value="${dept.facility_business}"></td>
                <td><input type="text" name="phone" value="${dept.phone}"></td>
                <td><input type="text" name="duty_people" value="${dept.duty_people}"></td>
                <td><input type="text" name="control_people" value="${dept.control_people}"></td>
                <td><input type="text" name="money" value="${dept.money}"></td>
                <td> <input type="submit" value=" 提交" class="layui-btn" style="background-color: #248cf5; margin-left:60px;" lay-filter="add" lay-submit=""/></td>

                <!--  <td class="td-status">
                   <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td> -->
                <c:choose>
                    <c:when test="${sessionScope.tip  == 1 }">
                        <td class="td-manage">
                            <!--  <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                               <i class="layui-icon">&#xe601;</i>
                             </a> -->

                            <a title="编辑"  onclick="x_admin_show('编辑','${ctx}/dept/add?id=${dept.id }');" href="javascript:;">

                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="删除" onclick="member_del(this,'${dept.id }')" href="javascript:;">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </c:when>

                </c:choose>
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
            $.get("${ctx}/dept/delete?id="+id);
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
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>