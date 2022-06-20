package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/delete")
public class DeleteServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int news_Id = Integer.parseInt(id);
		UsersDao ud = new UsersDaoImpl();
		if(ud.delete2(news_Id)){
			request.getRequestDispatcher("/notice/list").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}


}
