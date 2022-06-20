<%--
  Created by IntelliJ IDEA.
  User: qulxiangxin
  Date: 2022/6/9
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <!-- 配置文件 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
  <!-- 编辑器源码文件 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>

  <body>
   <!-- 实例化编辑器 -->
  <script type="text/javascript">
    var ue = UE.getEditor('container');
  </script>
  <form action="index2.jsp" method="get">
    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" value="${content}" type="text/plain">

    </script>
    <input type="submit"value="提交">
  </form>
  </body>
</html>
