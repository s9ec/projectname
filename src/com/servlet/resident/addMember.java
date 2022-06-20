package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/addMember")
public class addMember extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String relations = request.getParameter("relation");
        String workplace = request.getParameter("workplace");
        String mobileNumber = request.getParameter("mobileNumber");
        String fax =request.getParameter("fax");
        int hid = Integer.parseInt(request.getParameter("hid"));
        String sql = "insert into familymember_information(fname,msex,frelation,wplace,mp,fn,hid) value('" +  name
                +"','" +  gender + "','" + relations + "','" + workplace + "','" + mobileNumber + "','" + fax + "'," + hid + ")";
        ResiDao rd = new ResiDaoImpl();
         boolean b = rd.update(sql);
            request.getRequestDispatcher("/user/familyMember?hid=" + hid).forward(request, response);
        }
    }
