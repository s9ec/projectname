package com.servlet.worker;

import com.entity.worker.Add;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee/add")
public class add extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        List<Add> list = new ArrayList<>();
        Add add = new Add();
        add.setId(1);
        add.setName("男");
        list.add(add);

        Add adds = new Add();
        adds.setId(2);
        adds.setName("女");
        list.add(adds);
        request.setAttribute("dept_list",list);
        request.getRequestDispatcher("/page/worker/add.jsp").forward(request, response);
    }
}
