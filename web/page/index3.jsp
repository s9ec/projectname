<%@ page import="com.dao.ResiDao3" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.impl.ResiDaoImpl3" %>
&#160
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>

</head>
<body>

<%
    String uname = (String)request.getAttribute("uname");
    session.setAttribute("userName",uname);

    ResiDao3 rd = new ResiDaoImpl3();
    List<String> news = rd.checknewsAll();
    session.setAttribute("a", news);
%>
<!-- 顶部开始 -->
<div class="container" style="background-color: #248cf5">
    <div class="logo"><a href="./index.html">住户社区系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;" style="color:#2816a1;font-size: 15px;font-weight: bolder;">${requestScope.uname }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','${ctx }/user/myInformation?name=${requestScope.uname}')">个人信息</a></dd>
                <dd><a href="${ctx}/user/logout">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a>欢迎登录</a></li>
    </ul>
</div>

<div class="left-nav"  style="margin-top: 20px">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>缴费管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>费用类型</cite>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a _href="${ctx }/fee/waterList3?name=${sessionScope.userName}">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>水费</cite>
                                </a>
                            </li>
                            <li>
                                <a _href="${ctx }/fee/eleList3?name=${sessionScope.userName}">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>电费</cite>
                                </a>
                            </li>
                        </ul>

                    </li >
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content"  style="margin-top: 20px">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${ctx}/page/welcome1?a=3' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer" style="background-color: #248cf5">
    <div class="copyright" style="background-color: #248cf5">成都六人组有限公司&nbsp;&nbsp;&nbsp;&nbsp;联系电话：123-456-789</div>
</div>
<!-- 底部结束 -->

</body>
</html>