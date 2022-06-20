package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;
import com.entity.resident.Resident;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/edit")
public class editResident extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hid = request.getParameter("id"); // 得到了hid
        ResiDao resiDao = new ResiDaoImpl();
        List<Resident> residents = null;
        try {
             residents = resiDao.queryInfo(hid,"4");//得到这个东西
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String other = "女";
        if(residents.get(0).getResi_info().getHouseOwnerGender().equals("女")){
            other = "男";
        }
        request.setAttribute("theOther",other);
        request.setAttribute("e",residents);
        request.getRequestDispatcher("/page/user/edit.jsp").forward(request, response);
    }

}
