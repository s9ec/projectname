package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user/updateMember")
public class updateMember extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String relation = request.getParameter("relation");
        String workplace = request.getParameter("wp");
        String mobileNum = request.getParameter("mobileNum");
        String chuanhu = request.getParameter("chuanhu");
        String sql = "UPDATE familymember_information set fname ='" + name + "',msex = '" + gender + "',frelation ='"
                +relation+"',wplace ='" + workplace + "',mp ='" + mobileNum + "',fn ='"+chuanhu + "' where id = " + id;
        ResiDao resiDao = new ResiDaoImpl();
        Boolean b = resiDao.update(sql);
        System.out.println(b);
        request.getRequestDispatcher("/user/list").forward(request, response);
    }


}
