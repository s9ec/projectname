<%@page import="java.sql.*"%>
<%--
  Created by IntelliJ IDEA.
  User: qulxiangxin
  Date: 2022/6/9
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
          String url = "jdbc:mysql://127.0.0.1:3306/test01?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull";

          String user = "root";

          String password = "Qr977207";

          Connection connection = null;

          Statement stmt = null;

          ResultSet rs = null;
          try {
                  //导入驱动
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  //建立连接
                  connection = DriverManager.getConnection(url, user, password);

                  //获取执行器
                  stmt = connection.createStatement();

                  //String sql = "insert into emp_back value ('1123','qulx','shf')";
                  //String sql = "update emp_back set ename = 'csdf' where empno = '2523'";
                  //String sql = "delete from emp_back where empno = 1111";
                  String content = request.getParameter("content");

                  String sql = "insert into message(content) value ('"+content+"')";
                  //执行语句

                  int count = -1;

                  count = stmt.executeUpdate(sql);


                  String sql2 = "select * from message where id = 1";
                  //执行语句

                  rs = stmt.executeQuery(sql2);


                  if(rs .next()) {
                          session.setAttribute("content",content);
                          response.sendRedirect("index3.jsp");
                  }
          }catch(ClassNotFoundException e) {
                  e.printStackTrace();
          }catch(SQLException e) {
                  e.printStackTrace();
          }catch(Exception e){
                  e.printStackTrace();
          }

          finally {
                  try {
                          if(rs != null)rs.close();
                          if(stmt != null)stmt.close();
                          if(connection != null)connection.close();
                  } catch (SQLException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                  }
          }
  %>
</body>
</html>
