package com.servlet.notice;

import com.dao.ResiDao3;
import com.dao.impl.ResiDaoImpl3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/page/welcomes")
public class welcome extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        ResiDao3 rd = new ResiDaoImpl3();
        List<String> news = rd.checknewsAll();
        request.setAttribute("a", news);
        request.getRequestDispatcher("/page/welcome.jsp").forward(request, response);
//        int news_id = Integer.parseInt(request.getParameter("news_id"));//得到密码
//        UserDao ud = new UserDaoImpl();
//        String s= ud.getcontent(news_id);
//        request.setAttribute("S", s);
//        request.getRequestDispatcher("/page/welcome.jsp").forward(request, response);

    }

}
