/**
 * 
 */
 window.onload=function(){
                      MathJax.Hub.Config({
    tex2jax: {
      inlineMath: [["$","$"],["\\(","\\)"]]
    }
  });
                let middle=document.getElementById("middle");
                let proInfo=document.getElementById("proInfo");
           
                let container=document.getElementById("container");
                let elseAnswer=document.getElementById("elseAnswer");
                let resize=document.getElementById("resize");
                let answerPos=document.getElementById("answerPos");
           
           
                let height=proInfo.clientHeight+elseAnswer.clientHeight+50;
                 middle.style.height=height+"px";
               let resizeIcon=document.getElementById("resize-canvas");
               let ctx=resizeIcon.getContext("2d");
               ctx.strokeStyle="black";
               ctx.moveTo(3,0);
               ctx.lineTo(3,50);
               ctx.moveTo(8,0);
               ctx.lineTo(8,50);
               
               ctx.stroke();
               
               resize.onmousedown = function (e) {
                var startX = e.clientX;
                resize.left = resize.offsetLeft;
                document.onmousemove = function (e) {
                    var endX = e.clientX;
 
                    var moveLen = resize.left + (endX - startX);
                    var maxT = container.clientWidth - resize.offsetWidth;
                    if (moveLen < 150) moveLen = 150;
                    if (moveLen > maxT - 150) moveLen = maxT - 150;
 
                    resize.style.left = moveLen;
                    elseAnswer.style.width = moveLen + "px";
                    answerPos.style.width = (container.clientWidth - moveLen - 14) + "px";
                }
                document.onmouseup = function (evt) {
                    document.onmousemove = null;
                    document.onmouseup = null;
                    resize.releaseCapture && resize.releaseCapture();
                }
                resize.setCapture && resize.setCapture();
                return false;
            }
               
    //answerPos部分           
    let MathDiv=document.getElementById("MathDiv");
    let analysis=document.getElementById("analysis");
    let nobr;
    let stmt;
    MathJax.Hub.Queue(function(){
    nobr=document.querySelector("#MathDiv nobr");
    stmt=nobr.innerText;//MathDiv中的初始内容
    });
    

    let btnSub=document.getElementById("btn-submit");
    btnSub.onclick=function(){
    stmt1=stmt.replace(/\\/g,"backslash");
    stmt1=stmt1.replace(/\{/g,"leftBrace");
    stmt1=stmt1.replace(/\}/g,"rightBrace");
    stmt1=stmt1.replace(/\[/g,"leftBracket");
    stmt1=stmt1.replace(/\]/g,"rightBracket");
    stmt1=stmt1.replace(/\(/g,"leftParenthese");
    stmt1=stmt1.replace(/\(/g,"rightParenthese");
    if(stmt1!=""&&analysis.innerText!=""){
          window.location.href="user/soluAna?stmt="+stmt1+"&analysis="+analysis.innerText;
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