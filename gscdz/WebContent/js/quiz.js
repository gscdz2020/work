/**
 * 
 */
window.onload=function(){
   MathJax.Hub.Config({
    tex2jax: {
      inlineMath: [["$","$"],["\\(","\\)"]]
    }
  });


    
    let tabCon=document.getElementById("tabCon");
    let pagCon=document.getElementById("pagCon");
 



    let MathDiv=document.getElementById("MathDiv");
    let kpoints=document.getElementById("kpoints");
    let nobr;
    let stmt;
    MathJax.Hub.Queue(function(){
    nobr=document.querySelector("#MathDiv nobr");
    stmt=nobr.innerText;//MathDiv中的初始内容
    });
    
    let btnQuiz=document.getElementById("btn-quiz");    
    btnQuiz.onclick=function(){
        tabCon.style.marginLeft="10px";
        window.setTimeout(function(){pagCon.style.display="block"},2000);
    }
    let btnBack=document.getElementById("btn-back");
    btnBack.onclick=function(){
        pagCon.style.display="none";
        tabCon.style.marginLeft="25%";
    }
    let btnSub=document.getElementById("btn-submit");
    btnSub.onclick=function(){
    let stmt1=stmt.substr(1); 
    stmt1=stmt1.replace(/\\/g,"backslash");
    stmt1=stmt1.replace(/\{/g,"leftBrace");
    stmt1=stmt1.replace(/\}/g,"rightBrace");
    stmt1=stmt1.replace(/\[/g,"leftBracket");
    stmt1=stmt1.replace(/\]/g,"rightBracket");
    stmt1=stmt1.replace(/\(/g,"leftParenthese");
    stmt1=stmt1.replace(/\(/g,"rightParenthese");
    if(stmt1!=""&&kpoints.innerText!=""){
          window.location.href="user/quizsub?stmt="+stmt1+"&kpoints="+kpoints.innerText;
    }
    else{
          alert("请仔细填写哦");
    }
    }
    
        //特殊字符按钮
    let toolBtn=document.querySelectorAll(".toolBtn");
         for(let i=0;i<toolBtn.length;++i){
            let textInBtn=toolBtn[i].innerText.slice(1,toolBtn[i].innerText.length-1);//切掉$$
            toolBtn[i].onclick=function(i){
                MathJax.Hub.Queue(function(i){
                    stmt+=textInBtn;
                    let math = MathJax.Hub.getAllJax("MathDiv")[0];
                    MathJax.Hub.Queue(["Text", math,stmt]);
                    });

                }
         }
         //字符输入
    function render(){
          nobr=document.querySelector("#MathDiv nobr");
          stmt=nobr.innerText;
    }
    MathDiv.addEventListener('input', render, false);
 
    
}
	
