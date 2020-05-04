package frontend;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie loginCookie = Arrays.stream(req.getCookies()).filter(cookie -> "signInLogin".equals(cookie.getName())).findFirst().orElse(null);
        String signInLogin = loginCookie.getValue();
        if (signInLogin == null || signInLogin.isEmpty()) {
            resp.sendRedirect("/authform");
        }

        Map<String, Object> pageCtx = new HashMap<>();
        pageCtx.put("signInLogin", signInLogin);

        PrintWriter writer = resp.getWriter();
        writer.println(PageGenerator.getPage("mainPage.html", pageCtx));

        System.out.println("mainPage Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("mainPage Post");
    }
}
