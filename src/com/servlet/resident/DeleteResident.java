package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int hid = Integer.parseInt(id);

		ResiDao resiDao = new ResiDaoImpl();
		
		if(resiDao.delete(hid)){
			request.setAttribute("xiaoxi", "删除成功");
			request.getRequestDispatcher("/user/list").forward(request, response);
		}else{
			response.sendRedirect("/user/list");
		}
	}


}
