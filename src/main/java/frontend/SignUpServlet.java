package frontend;

import service.AccountService;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("signUpResult", "");
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.println(PageGenerator.getPage("//authform.html", pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Map<String, Object> pageVariables = new HashMap<>();

        boolean isDataValid = isDataValid(login, password);
        boolean success = false;
        if (isDataValid) {
            success = AccountService.addUser(login, "", password);
            if (success) {
                pageVariables.put("signUpResult", String.format("New user created! Login - <strong>%s<strong>", login));
            } else {
                pageVariables.put("signUpResult", String.format("Failed to create new user, login - <strong>%s</strong> already exists.", login));
            }

        } else {
            pageVariables.put("signUpResult", "Login or password is incorrect. Please try again");
        }

        PrintWriter responseWriter = resp.getWriter();
        responseWriter.println(PageGenerator.getPage("//authform.html", pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);

        if (success) {
            resp.addCookie(new Cookie("signInLogin", login));
            resp.sendRedirect("/mainPage");
        }
    }

    private boolean isDataValid(String login, String password) {
        return !(login == null || password == null || login.isEmpty() || password.isEmpty());
    }


}
