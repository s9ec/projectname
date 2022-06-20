package com.servlet.worker;
import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/worker/insert")
public class insert extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        if(gender.equals("1")){
            gender = "男";
        }
        else{
            gender = "女";
        }
        int age = Integer.parseInt(request.getParameter("age"));
        int base_salary = Integer.parseInt(request.getParameter("base_salary"));
        String job = request.getParameter("job");
        int bonus = 0;
        String sql = "Insert into worker(name,gender,age,base_salary,bonus,kinds) value('" + name + "','" + gender
                + "'," + age + "," + base_salary + "," + bonus + ",'" + job +"')";
        WorkerDao workerDao = new WorkerDaoImpl();
        boolean b = workerDao.update(sql);
        sql = "insert into user(name,pwd,sex,level,userName) value('" + name + "','123456','" + gender + "',2,'"+name+"')";
        b = workerDao.update(sql);
        request.getRequestDispatcher("/worker/list").forward(request, response);
    }
}
