package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/query2")
public class updatenotice extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("news_id");
		int news_id = Integer.parseInt(id);
		String news_content = request.getParameter("news_content");
		String month1 = request.getParameter("month");
		int month = Integer.parseInt(month1);
		String day1 = request.getParameter("day");
		int day = Integer.parseInt(day1);
		UsersDao ud = new UsersDaoImpl();
		if(ud.update1(news_id,news_content, month, day)){
			request.getRequestDispatcher("/notice/list").forward(request, response);
		}else{
			response.sendRedirect("/page/dept/list.jsp");
		}
	}

}
