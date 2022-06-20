package com.servlet.fee;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fee/code")
public class code extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("record_id");
        request.setAttribute("rid",id);
        String s = request.getParameter("s");
        DBconn.init();

        if(s.equals("1")){
            String sql = "UPDATE water_record set status = '已交' where record_id = " + id;
            DBconn.addUpdDel(sql);
            DBconn.closeConn();
        request.getRequestDispatcher("/page/fee/qrCode.jsp").forward(request, response);
        }
        else{
            String sql = "UPDATE electricity_record set status = '已交' where record_id = " + id;
            DBconn.addUpdDel(sql);
            DBconn.closeConn();
            request.getRequestDispatcher("/page/fee/qrCodeEle.jsp").forward(request, response);
        }
    }
}
