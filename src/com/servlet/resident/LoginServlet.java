
package com.servlet.resident;

import com.dao.UserDao;
import com.dao.WorkerDao;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.WorkerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String name = request.getParameter("name"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("pwd");//得到密码
		String mode = request.getParameter("tip");
		String level = request.getParameter("tip");
		int l = Integer.parseInt(level);
		UserDao ud = new UserDaoImpl();
		request.setAttribute("uname",name);//名字
		WorkerDao workerDao = new WorkerDaoImpl();
		int day = workerDao.getDay();
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		String Day = weeks[day % 7];

		if(ud.login(name, pwd, l)){
			if(mode.equals("1")) {
				request.setAttribute("valid", "yes");
				request.setAttribute("xiaoxi", "欢迎用户" + name); //向request域中放置信息
				request.getRequestDispatcher("/page/index.jsp").forward(request, response);//转发到成功页面
			}
			else if(mode.equals("2")){
				request.setAttribute("Day",Day);//设置星期几
				boolean f = false;
				try {
					 f = workerDao.getWorkerId(name,day);
				} catch (SQLException e) {
					e.printStackTrace();
				}


				String job = "无";
				try {
					job = workerDao.job(name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("myJob",job);
				request.setAttribute("bool",f);
				System.out.println(f);
				request.getRequestDispatcher("/page/index2.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/page/index3.jsp").forward(request,response);
			}
		}else{
			request.setAttribute("valid","no");
			response.sendRedirect("page/loginForm.jsp"); //重定向到首页, 重定向要加杠
		}
	}
}
