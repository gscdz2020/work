package gscdz.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gscdz.java.SolProDB;
import gscdz.java.SolProblem;

@WebServlet("/user/offerSolvedProblem")
public class OfferSolProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OfferSolProblemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	  String subject=request.getParameter("subject");
      subject=subject.substring(1, subject.length()-1);
      String solution=request.getParameter("solution");
      solution=solution.substring(1,solution.length()-1);
      String knowledgePoints=request.getParameter("knowledgePoints");
      knowledgePoints=knowledgePoints.substring(1, knowledgePoints.length()-1);
      String analysis=request.getParameter("analysis");
      analysis=analysis.substring(1, analysis.length()-1);
      String tips=request.getParameter("tips");
      tips=tips.substring(1,tips.length()-1);
	  //创建对象solvedTime 
      //      createTime
      //      creUserId
      SolProblem solpro=new SolProblem();
      solpro.setSubject(subject);//subject
      solpro.setSolution(solution);//solution
      solpro.setKnowledgePoints(knowledgePoints);
      solpro.setAnalysis(analysis);
      solpro.setTips(tips);
      //添加到数据库
      SolProDB db=new  SolProDB();
      db.addSolProblem(solpro);
      //重新读取
      ServletContext context=this.getServletContext();
      ArrayList<SolProblem> sps=db.list();
	  context.setAttribute("sps", sps);
	  String path=request.getContextPath()+"/homepage.jsp";
      response.getWriter().println("<html><body>"
      		+"<p>添加成功</p><a href='"+path+"'>返回</a>"+ "</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
