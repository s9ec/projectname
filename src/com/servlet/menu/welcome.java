package com.servlet.menu;
import com.dao.ResiDao3;
import com.dao.impl.ResiDaoImpl3;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/page/welcome1")
public class welcome extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        DBconn.init();
        Date date = new Date();
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<=0){
            week_index = 7;
        }
        String sql = "SELECT * FROM schedule a,worker b where a.worker_id = b.worker_id and day = " + week_index;
        ResultSet rs = DBconn.selectSql(sql);
        String baoan = "今日休息";
        String baojie ="今日休息";
        String chengxu = "今日休息";
        String weixiu = "今日休息";
        while(true){
            try {
                if (!rs.next()) break;
                if(rs.getString("job").equals("保安")){
                    baoan = rs.getString("name");
                }
                if(rs.getString("job").equals("保洁")){
                    baojie = rs.getString("name");
                }
                if(rs.getString("job").equals("维修员")){
                    weixiu = rs.getString("name");
                }
                if(rs.getString("job").equals("程序员")){
                    chengxu = rs.getString("name");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        String month = String.format("%tm", date);
        String day = String.format("%te", date);
        request.setAttribute("cmonth",month);
        request.setAttribute("cday",day);
        request.setAttribute("xingqiji",weeks[week_index%7]);
        request.setAttribute("baoan",baoan);
        request.setAttribute("baojie",baojie);
        request.setAttribute("weixiu",weixiu);
        request.setAttribute("chengxu",chengxu);

        ResiDao3 rd = new ResiDaoImpl3();
        List<String> news = rd.checknewsAll();
        request.setAttribute("a", news);
        if(request.getParameter("a").equals("1"))
        request.getRequestDispatcher("/page/welcome.jsp").forward(request, response);
        else{
            request.getRequestDispatcher("/page/welcome3.jsp").forward(request, response);
        }
    }
}
