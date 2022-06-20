package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.facility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept/update")
public class UpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int facility_id = Integer.parseInt(request.getParameter("facility_id"));//得到密码
		System.out.println(facility_id);
        UsersDao ud = new UsersDaoImpl();
        List<facility> facilityAll = ud.getfacilityAll(facility_id);
        request.setAttribute("facilityAll", facilityAll);
        request.getRequestDispatcher("/page/dept/update.jsp").forward(request, response);
	}

}
