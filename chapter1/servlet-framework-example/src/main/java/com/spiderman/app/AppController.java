package com.spiderman.app;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");
        Page page = resolvePage(req);
        if (page != null) {
            resp.getWriter().write("Page Model info: " +
                    page.getPageModelInfo() + "<br/>");
            resp.getWriter().write("Page View info: " +
                    page.getPageViewInfo());
        }
    }

    private Page resolvePage(HttpServletRequest req) {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        Object obj = req.getServletContext().
                getAttribute("pages");

        if (obj instanceof List) {
            Optional<Page> first = ((List<Page>) obj).stream()
                    .filter(p -> path.equals(p.getPath()))
                    .findFirst();

            if (first.isPresent()) {
                return first.get();
            }
        }
        return null;
    }
}