/**
 * 
 */
window.onload=function(){
    MathJax.Hub.Config({
    tex2jax: {
      inlineMath: [["$","$"],["\\(","\\)"]]
    }
  });
      
	   let canvas=document.getElementById("canvas");
       let ctx=canvas.getContext("2d");
        function draw(){
            ctx.strokeStyle="gray";
            ctx.moveTo(0,0);
            ctx.lineTo(15,20);
            ctx.lineTo(30,0);
            ctx.moveTo(0,10);
            ctx.lineTo(15,30);
            ctx.lineTo(30,10);
            ctx.stroke();
        }
        draw();
        let icon=document.getElementById("icon");
        let leftNav=document.querySelector(".leftNav");
        let stateOfIcon="down";
        let chapter1=document.querySelectorAll(".chapter1");
        icon.onclick=function(){
            if(stateOfIcon=="down"){
                leftNav.style.height="500px";
                canvas.style.transform="rotateX(180deg)"; 
                window.setTimeout(function(){
                    for(let i=0;i<chapter1.length;++i){
                        chapter1[i].removeAttribute("hidden");
                        console.log("false");
                    }
                },500); 
                stateOfIcon="up";
                }
            else{
                leftNav.style.height="360px";
                canvas.style.transform="rotateX(0deg)"; 
                for(let j=0;j<chapter1.length;++j){
                    console.log("true");
                    chapter1[j].setAttribute("hidden",true);
                    }
                stateOfIcon="down";
            }
            
            
        }
        

        
        var arr = document.getElementsByClassName("slide");
		for(var i=0;i<arr.length;i++){
			arr[i].style.left = i*776+"px";
		}
        /*回头记得尝试用requestAnimationFrame方法和对象做做看 
        */
	function LeftMove(){
		for(let i=0;i<arr.length;i++){
			let left = parseFloat(arr[i].style.left);
			left-=2;
			let width = 776;//图片的宽度
			if(left<=-width){
				left=(arr.length-1)*width;//当图片完全走出显示框，拼接到末尾
				clearInterval(moveId);
			}
			arr[i].style.left = left+"px";
		}
	}
	function divInterval(){
		moveId=setInterval(LeftMove,10);
	}
	
	let moveId;
	timeId=setInterval(divInterval,6000);
	function stop(){
		clearInterval(moveId);
        clearInterval(timeId);
	}
    function start(){
        
        timeId=setInterval(divInterval,6000);
    }
        let midPic=document.getElementById("midPic");
        //鼠标悬停在上方时
        midPic.onmouseover=function(){
            stop();
        }
        midPic.onmouseout=function(){
            start();
        }
}