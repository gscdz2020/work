package gscdz.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gscdz.java.Problem;
import gscdz.java.TransAndRev;
import gscdz.java.UnsolProDB;
import gscdz.java.User;

@WebServlet("/user/soluAna")
public class ProSolAndAnalyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProSolAndAnalyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=utf-8");
		     request.setCharacterEncoding("utf-8");
		     HttpSession session=request.getSession();
		     ServletContext context=this.getServletContext();
		     Problem problem=(Problem)session.getAttribute("problem");
		     User user= (User)session.getAttribute("user");
             String solution=request.getParameter("stmt");
             String analysis=request.getParameter("analysis");
             TransAndRev rev=new TransAndRev();
             //翻译
             solution=rev.reverse(solution);
             solution=solution.replaceAll("\\\\", "\\\\\\\\");
             solution="$"+solution+"$";
             analysis=rev.reverse(analysis);
             analysis=analysis.replaceAll("\\\\", "\\\\\\\\");
             analysis="$"+analysis+"$";
           //更新信息
             UnsolProDB usdb=new UnsolProDB();
             
             String answUserId=problem.getAnswUserId();
             if(answUserId==null) {
            	 answUserId=Integer.toString(user.getId());
             }
             else {
            	 answUserId+="||";
            	 answUserId+=user.getId();
             }
             usdb.updateSoluAndAnal(problem.getId(),solution, analysis,answUserId);
             //重新读取
             ArrayList<Problem> usps=usdb.list();
     		 context.setAttribute("usps", usps);
     		response.sendRedirect("quiz");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
