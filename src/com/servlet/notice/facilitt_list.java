package com.servlet.notice;

import com.dao.ResiDao2;
import com.dao.impl.ResiDaoImpl2;
import com.entity.facility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept/list")
public class facilitt_list extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResiDao2 rd = new ResiDaoImpl2();
		List<facility> facilityAll = rd.getfacilityAll();
		request.setAttribute("M", facilityAll);
		request.getRequestDispatcher("/page/dept/list.jsp").forward(request, response);
	}
}
