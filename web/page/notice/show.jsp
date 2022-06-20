<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>$Title$</title>
</head>
<%--<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}../../ueditor/lang/zh-cn/zh-cn.js"></script>--%>


<!-- 配置文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}../../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}../../ueditor/ueditor.all.js"></script>

<body>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container');
</script>
<form action="${pageContext.request.contextPath}/notice/updatecontent?id=${requestScope.id}" method="post">
    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">
${requestScope.message}
</script>
    <input type="submit"value="提交">
</form>
</body>
</html>
