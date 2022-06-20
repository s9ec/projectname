package com.servlet.notice;

import com.dao.UserDao;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.news;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice/update")
public class UpdateServlet2 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int news_id = Integer.parseInt(request.getParameter("news_id"));//得到密码
        UsersDao ud = new UsersDaoImpl();
        List<news> news1All = ud.getnewsAll5(news_id);
        request.setAttribute("facilityAll", news1All);
        request.getRequestDispatcher("/page/notice/update.jsp").forward(request, response);
	}

}
