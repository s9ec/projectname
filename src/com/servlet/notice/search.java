package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.facility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept/search")
public class search extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String m = request.getParameter("method");
        System.out.println(m);
        UsersDao ud = new UsersDaoImpl();
        int facility_id = 0;
        if(m.equals("1")){
            boolean a = true;
            String val = request.getParameter("sxy");
            for (int i = val.length();--i>=0;){//判断是否是是数字
                if (!Character.isDigit(val.charAt(i))){
                    a = false;
                }
            }
            if(a){
                facility_id = Integer.parseInt(val);
            }
            List<facility> facility = ud.search(facility_id);
            request.setAttribute("record",facility); //向request域中放置信息
            request.getRequestDispatcher("/page/dept/search.jsp").forward(request, response);//转发到成功页面
        }
        if(m.equals("2")){
            String val = request.getParameter("sxy");
            List<facility> facility = ud.search2(val);
            request.setAttribute("record",facility); //向request域中放置信息
            request.getRequestDispatcher("/page/dept/search.jsp").forward(request, response);//转发到成功页面
        }
        if(m.equals("3")){
            String val = request.getParameter("sxy");
            int money = Integer.parseInt(val);
            List<facility> facility = ud.search3(money);
            request.setAttribute("record",facility); //向request域中放置信息
            request.getRequestDispatcher("/page/dept/search.jsp").forward(request, response);//转发到成功页面
        }


    }

}
