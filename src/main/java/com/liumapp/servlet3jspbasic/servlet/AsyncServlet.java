package com.liumapp.servlet3jspbasic.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by liumapp on 6/22/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class AsyncServlet extends HttpServlet {

    public AsyncServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("asyncServlet开始时间：" + new Date());
        AsyncContext context = req.startAsync();
        new Thread(new execute(context)).start();


    }

    public class execute implements Runnable {

        private AsyncContext context;

        public execute(AsyncContext context) {
            this.context = context;
        }

        public void run() {
            //异步过滤器将处理的业务
            try {

                Thread.sleep(1000*10);
                System.out.println("业务执行完成：" + new Date());

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }
    }
}
