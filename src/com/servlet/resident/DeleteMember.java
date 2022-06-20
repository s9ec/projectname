package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user/deleteMember")
public class DeleteMember extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Id = request.getParameter("id");
        int id = Integer.parseInt(Id);

        ResiDao resiDao = new ResiDaoImpl();

        if(resiDao.deleteMember(id)){
            request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/user/list").forward(request, response);
        }else{
            response.sendRedirect("/user/list");
        }
    }


}
