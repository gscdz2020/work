
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="gscdz.java.*,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="css/proDet.css">
    <link rel="stylesheet" href="css/nav1.css">
    <script src="js/proDet.js"></script>
  <script type="text/javascript"
  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML-full">
</script>
<title>Insert title here</title>

</head>

<body>

   <div id="web-nav-container">
        <div id="m-navTop-func">
            <div id="m-navTop-func-i">
                <div id="u-navLogin-container">
                    <div class="u-navLogin-logo new-nav-spoc-logo">
                        <a href="homepage.jsp">
                            <image src="images/logo.png">
                        </a>
                    </div>
                    <div class="e-hover-quiz u-navLogin-quiz">
                        <a href="user/quiz" target="_top">
                           <span class="nav">提问</span>
                        </a>
                        
                    </div>
                    <div class="u-navLogin-practice normal">
                        <a href="user/test" target="_top">
                        <span class="nav">练习</span>
                        </a>
                    </div>
                    <div class="u-navLogin-p normal">
                        <a href="offer.jsp" target="_top">
                            <span class="nav">提供题目</span>
                        </a>
                    </div>
                    <div class="u-navLogin-p normal">
                        <a href="CuoTiJi.jsp" target="_top">
                            <span class="nav">错题集</span>
                        </a>
                    </div>
                    <div class="u-navLogin-xiazai normal">
                        <a href="#" target="_top">
                            <span class="nav">
                                下载APP(暂无)
                            </span>
                        </a>
                    </div>
                    <div class="web-nav-right-part">
                        <div class="u-navLogin-searchFunc"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

   <div id="web-body-container">
       <div id="middle">
       <% Problem  problem =(Problem)session.getAttribute("problem");
              if(problem!=null){
                UserDB userdb=new UserDB();
                User user=userdb.getUserByid(problem.getCreUserId());
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
   %>
           <div id="proInfo">
               <div id="subject" class="text1"><%=problem.getSubject() %>
               </div>
               <P id="else" class="text1">相关知识点：<%=problem.getKnowledgePoints() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cteateTime：<%=formatter.format(problem.getCreateTime())%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建者：<%=user.getUername() %>
               </P>
           </div>
           <div id="container">
           <div id="elseAnswer"  class="box">
               <!--弹性和布局呈现其他答案-->
               <div class="elAs"></div>
               <div class="elAs"></div>
               <div class="elAs"></div>
               <div class="elAs"></div>
               <div class="elAs"></div>
           
           </div>
           <div id="resize" >
               <!--中间的移动块
               <div class="resize-icon" id="resize-icon-left"></div>
               <div class="resize-icon" id="resize-icon-mid"></div>
               <div class="resize-icon" id="resize-icon-right"></div>
               -->
               <canvas id="resize-canvas" width="11px" height="50px"></canvas>
               </div>
           <div id="answerPos"  class="box">
               <div id="pageHeader">答题区</div>
                <div id="pageContent">
                  <div id="pageContent-Tool">
                    <button  class="toolBtn">$\infty$</button>
                    <button  class="toolBtn">$\cup$</button>
                    <button  class="toolBtn">$\cap$</button>
                    <button  class="toolBtn">$\in$</button>
                    <button  class="toolBtn">$\notin$</button>
                    <button  class="toolBtn">$\varnothing$</button>
                    <button  class="toolBtn">$\forall$</button>
                    <button  class="toolBtn">$\exists$</button>
                    <button  class="toolBtn">$\nabla$</button>
                    <button  class="toolBtn">$\partial$</button>
                    <button  class="toolBtn">$\sum$</button>
                    <button  class="toolBtn">$\int$</button>
                    <button  class="toolBtn">$\sqrt[x]{y}$</button>
                    <button  class="toolBtn">$\frac{x}{y}$</button>
                    </div>
                  <div id="MathDiv" contenteditable="true">
                    $abc$
                    </div>
                   <div id="analysis" contenteditable="true"></div>
                </div>
                 <div id="pageFooter">
                     <button id="btn-submit" class="btn" >提交</button>

                </div>
               
               </div>
           </div>
           <%} %>
       </div>
     </div>
</body>
</html>