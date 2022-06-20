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
import java.util.List;
@WebServlet("/user/list")
public class residentInformation extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
        }

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ResiDao rd = new ResiDaoImpl();
            List<Resident> resiAll = rd.getResiAll();
            request.setAttribute("L", resiAll);
            request.getRequestDispatcher("/page/user/list.jsp").forward(request, response);
        }

    }

