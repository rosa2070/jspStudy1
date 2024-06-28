package init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/init1", loadOnStartup = 2 )
public class InitServlet1 extends HttpServlet {

    @Override
    public void init(ServletConfig cibfug) throws ServletException {
        System.out.println("InitServlet1 init(ServletConfig config) 호출");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);

    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("InitServlet1 doProcess() 호출");
    }
}
