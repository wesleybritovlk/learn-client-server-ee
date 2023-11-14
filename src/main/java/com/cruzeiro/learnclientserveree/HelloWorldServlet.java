package com.cruzeiro.learnclientserveree;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(description = "Servlet de demonstração de criação", value = "/hello-world-servlet")
public class HelloWorldServlet extends HttpServlet {
    public HelloWorldServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        CharSequence html = "<html><body>"
                + "<h2>Hello World Servlet</h2><br>"
                + "Time on the server is: " + new Date()
                + "</body></html>";
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
