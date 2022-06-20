package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hid = request.getParameter("hid");
		String household_name = request.getParameter("household_name");
		String community_id = request.getParameter("community_id");
		String building_id = request.getParameter("building_id");
		String unit_id = request.getParameter("unit_id");
		String room_id = request.getParameter("room_id");
		String gender = request.getParameter("sex");
		String hPN = request.getParameter("hPN");
		String hPN2 = request.getParameter("hPN2");
		String wPN = request.getParameter("wPN");
		String wN = request.getParameter("wN");
		String sql = "UPDATE position_of_user SET community_id = " + community_id + ", building_id = " + building_id
				+ ", unit_id = " + unit_id + ", room_id = " + room_id + " where hid = " + hid;

		String sql2 = "UPDATE household_information SET household_name = '" + household_name + "',sex = '" + gender
				+ "', family_phone1 = '" + hPN + "', family_phone2 = '" + hPN2 + "', mobile_phone = '" + wPN + "', work = '"
				+ wN + "' where hid = " + hid ;

		ResiDao resiDao = new ResiDaoImpl();
		boolean a = resiDao.update(sql);//更新两条
		boolean b=  resiDao.update(sql2);
			request.setAttribute("xiaoxi", "更新成功");//设置request的信息
			request.getRequestDispatcher("/user/list").forward(request, response);
	}

}
