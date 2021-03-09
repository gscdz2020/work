<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nav1.css">
<link rel="stylesheet" href="css/offer.css">
<script type="text/javascript"
  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML-full">
</script>

<script src="js/offer.js"></script>
<script ></script>
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
            <div id="subject" contenteditable="true" class="inputdiv"></div>
            <div id="solution" contenteditable="true" class="inputdiv"></div>
            <div id="knowledgePoints" contenteditable="true" class="inputdiv"></div>
            <div id="analysis" contenteditable="true" class="inputdiv"></div>
            <div id="tips" contenteditable="true" class="inputdiv"></div>
           <button id="sub-btn" >提交</button>
        </div>
    </div>
</body>
</html>