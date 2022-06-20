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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/search")
public class Searchall extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String info = request.getParameter("name");//得到内容
		String method = request.getParameter("selection");//得到方式
		List<Resident> residents = new ArrayList<>();
		ResiDao rd = new ResiDaoImpl();
		try {
			residents = rd.queryInfo(info,method);//查询一下
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("queryAll", residents);
		request.getRequestDispatcher("/page/user/queryAll.jsp").forward(request, response);
	}
}
