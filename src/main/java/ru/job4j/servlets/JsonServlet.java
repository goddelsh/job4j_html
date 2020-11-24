package ru.job4j.servlets;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> parsedRequest = new Gson().fromJson(
                new InputStreamReader(req.getInputStream(),
                        StandardCharsets.UTF_8), Map.class);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (parsedRequest != null && parsedRequest.containsKey("name")) {
            writer.println(new Gson().toJson(Map.of("name", parsedRequest.get("name"))));
        } else {
            writer.println(new Gson().toJson(Map.of("name", "Ошибка параметров")));
        }
        writer.flush();
    }
}