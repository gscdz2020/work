package gscdz.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/quiz")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuizServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String path=request.getContextPath()+"/quiz.jsp";
		if(request.getSession().getAttribute("islogin")=="yes") {
		response.sendRedirect(path);
		}
		//request.getRequestDispatcher(path).include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
