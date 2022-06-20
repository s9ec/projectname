package com.servlet.resident;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.resident.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)//
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //获取jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String home = request.getParameter("home");
		String info = request.getParameter("info");
		
		User user = new User(); //实例化一个对象，组装属性
		user.setName(name);
		user.setPwd(pwd);
		
		UserDao userDao = new UserDaoImpl();
		
		if(userDao.register(user)){
			request.setAttribute("username", name);  //向request域中放置参数
			//request.setAttribute("xiaoxi", "注册成功");
			request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
		}else{
			
			response.sendRedirect("index.jsp");//重定向到首页
		}
	}
}
