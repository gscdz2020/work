package gscdz.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gscdz.java.Problem;
import gscdz.java.UnsolProDB;

@WebServlet("/user/ProDetails")
public class ProDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProDetailServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		UnsolProDB uspdb=new UnsolProDB();
		Problem problem=uspdb.findById(id);
		HttpSession session=request.getSession();
		session.setAttribute("problem", problem);
		String path=request.getContextPath()+"/ProDet.jsp";
		response.sendRedirect(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
