package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.news;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice/list2")
public class search2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String m = request.getParameter("method");
        UsersDao ud = new UsersDaoImpl();
        if(m.equals("1")){
            String val = request.getParameter("sxy");
            int news_id = Integer.parseInt(val);
            List<news> news_list = ud.search4(news_id);
            request.setAttribute("record",news_list); //向request域中放置信息
            request.getRequestDispatcher("/page/notice/search.jsp").forward(request, response);//转发到成功页面
        }
        if(m.equals("2")){
            String val = request.getParameter("sxy");
            List<news> news_list = ud.search5(val);
            request.setAttribute("record",news_list); //向request域中放置信息
            request.getRequestDispatcher("/page/notice/search.jsp").forward(request, response);//转发到成功页面
        }
        if(m.equals("3")){
            String val = request.getParameter("sxy");
            List<news> news_list = ud.search6(val);
            request.setAttribute("record",news_list); //向request域中放置信息
            request.getRequestDispatcher("/page/notice/search.jsp").forward(request, response);//转发到成功页面
        }


    }

}
