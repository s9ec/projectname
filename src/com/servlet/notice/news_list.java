package com.servlet.notice;

import com.dao.ResiDao3;
import com.dao.impl.ResiDaoImpl3;
import com.entity.news;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice/list")
public class news_list extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResiDao3 rd = new ResiDaoImpl3();
		List<news> facilityAll = rd.getnewsAll();
		request.setAttribute("M", facilityAll);
		request.getRequestDispatcher("/page/notice/list.jsp").forward(request, response);
	}
}
