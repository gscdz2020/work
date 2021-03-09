package gscdz.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = "runoob,google,taobao,facebook,zhihu";
	        // 以 , 号为分隔符来分隔字符串
		 ArrayList<String> tips=new ArrayList<String>();
	        StringTokenizer st=new StringTokenizer(str,",");
	        while(st.hasMoreTokens()) { 
	        	tips.add(st.nextToken());
	        }
	        for(String x:tips) {
	        	System.out.println(x);
	        }
	        System.out.println(tips.get(0));
	}

}
