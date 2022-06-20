package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/delete")
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int facilityId = Integer.parseInt(id);
		
		UsersDao ud = new UsersDaoImpl();
		
		if(ud.delete(facilityId)){
			request.getRequestDispatcher("/dept/list").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}


}
