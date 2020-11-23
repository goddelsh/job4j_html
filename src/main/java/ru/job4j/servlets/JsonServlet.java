package ru.job4j.servlets;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonServlet extends HttpServlet {

    private class NameClass {
        final private String name;

        public NameClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        NameClass nameObject = new NameClass(req.getParameter("name"));
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println(new Gson().toJson(nameObject));
        writer.flush();
    }
}