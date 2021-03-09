package gscdz.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
import gscdz.java.UserDB;

@WebServlet("/user/quizsub")
public class QuizSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuizSubmitServlet() {
        super();
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ServletContext context=this.getServletContext();
		HttpSession session=request.getSession();
		String kpoints=request.getParameter("kpoints");//knowledgePoints
		String subject=request.getParameter("stmt");
		TransAndRev tool =new TransAndRev();
		subject=tool.reverse(subject);//subject
		subject=subject.replaceAll("\\\\", "\\\\\\\\");
		subject="$"+subject+"$";
		Date date = new Date(System.currentTimeMillis());//createTime
		//创建对象
		Problem p=new Problem();
		p.setSubject(subject);
		p.setKnowledgePoints(kpoints);
		p.setCreateTime(date);
		User user=(User)session.getAttribute("user");//user
		p.setCreUserId(user.getId());
		UnsolProDB db=new UnsolProDB();
		db.addPro(p);
		//重新读取数据库中的unsolved_problem
		ArrayList<Problem> usps=db.list();
		context.setAttribute("usps", usps);

		session.setAttribute("issuc", "yes");
		//修改user的信息并重新读取
		UserDB userDB=new UserDB();
		p=usps.get(usps.size()-1);
		System.out.println(p.getId());
		int problemId=p.getId();
		userDB.updateCP(user.getUername(), problemId);
		user=userDB.getUserInfor(user.getUername());//update User Information
		session.setAttribute("user", user);
		
		response.sendRedirect("quiz");//页面跳转
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
