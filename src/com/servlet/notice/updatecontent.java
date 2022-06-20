package com.servlet.notice;

import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/updatecontent")
public class updatecontent extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		DBconn.init();
		String sql = "update message set content = '"+content+"' where id =" + id ;
		int count = DBconn.addUpdDel(sql);
		//执行语句
		System.out.println("count is " + count);
		request.getRequestDispatcher("/notice/list").forward(request, response);
	}

}
