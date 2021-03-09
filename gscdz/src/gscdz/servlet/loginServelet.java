package gscdz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gscdz.java.AdminDB;
import gscdz.java.DB;
import gscdz.java.Problem;
import gscdz.java.SolProDB;
import gscdz.java.SolProblem;
import gscdz.java.UnsolProDB;
import gscdz.java.User;
import gscdz.java.UserDB;

@WebServlet("/login")
public class loginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String occupation=request.getParameter("occupation");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		ServletContext context=this.getServletContext();
		DB db=occupation.equals("Admin")?new AdminDB():new UserDB();
		if(username==""||password=="") {
			session.setAttribute("isnull", "yes");
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		}
		else if(db.findpsw(username)==null) {
			session.setAttribute("isright", "wrong");
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		}
		else if (!db.findpsw(username).equals(password)){
			session.setAttribute("isright", "wrong");
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		}
		else {
			UnsolProDB uspdb=new UnsolProDB();
			ArrayList<Problem> usps=uspdb.list();
			context.setAttribute("usps", usps);
			SolProDB spdb=new  SolProDB();
			ArrayList<SolProblem> sps=spdb.list();
			context.setAttribute("sps", sps);
			switch(occupation) {
			   case "Admin":
				   session.setAttribute("islogin", "yes");
				   request.getRequestDispatcher("WEB-INF/InnerPage/adHomePage.jsp").forward(request, response);break;
			   case "User": 
				   UserDB userdb=(UserDB)db;
				   session.setAttribute("islogin", "yes");
				   User user=userdb.getUserInfor(username);//用户的信息
				   session.setAttribute("user", user);//存键值对
				   request.getRequestDispatcher("homepage.jsp").forward(request, response);break;
                 
			}
		}
	}

}
