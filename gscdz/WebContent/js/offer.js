/**
 *          <div id="subject" contenteditable="true" class="inputdiv"></div>
            <div id="solution" contenteditable="true" class="inputdiv"></div>
            <div id="knowledgePoints" contenteditable="true" class="inputdiv"></div>
            <div id="analysis" contenteditable="true" class="inputdiv"></div>
            <div id="tips" contenteditable="true" class="inputdiv"></div>
 */
window.onload=function(){
	let inputDivs=document.getElementsByClassName("inputdiv");
let subBtn=document.getElementById("sub-btn");
        subBtn.onclick=function(){
	       for(let i=0;i<inputDivs.length;++i){
               console.log(inputDivs[i].innerText);
               if(inputDivs[i].innerText==""){
                   alert("有内容为空哦");
                   return;
               }
           }
           window.location.href="user/offerSolvedProblem?subject='"+inputDivs[0].innerText+"'&solution='"+inputDivs[1].innerText+"'&knowledgePoints='"+inputDivs[2].innerText+"'&analysis='"+inputDivs[3].innerText+"'&tips='"+inputDivs[4].innerText+"'";
       }
}
