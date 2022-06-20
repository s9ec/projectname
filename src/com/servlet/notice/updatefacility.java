package com.servlet.notice;

import com.dao.UserDao;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/query")
public class updatefacility extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("facility_id");
		int facility_id = Integer.parseInt(id);
		String facility_name = request.getParameter("facility_name");
		String facility_business = request.getParameter("facility_business");
		String phone = request.getParameter("phone");
		String duty_people = request.getParameter("duty_people");
		String control_people = request.getParameter("control_people");
		String money1 = request.getParameter("money");
		int money = Integer.parseInt(money1);
		UsersDao ud = new UsersDaoImpl();
		if(ud.update(facility_id,facility_name, facility_business, phone,duty_people,control_people,money)){
			request.getRequestDispatcher("/dept/list").forward(request, response);
		}else{
			response.sendRedirect("/page/dept/list.jsp");
		}
	}

}
