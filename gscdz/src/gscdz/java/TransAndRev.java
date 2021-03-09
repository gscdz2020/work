package gscdz.java;
/*用于url无法传递特殊字符
 * translate转换为英文
 * Reverse转换为对应的特殊字符
 * 
 * */
public class TransAndRev {
	public String translate(String stmt) {
		/*translate to common character*/
		String result;
		result=stmt.replaceAll("\\\\","backslash");
		result=result.replaceAll("\\{","leftBrace");
		result=result.replaceAll("\\}","rightBrace");
		result=result.replaceAll("\\[","leftBracket");
		result=result.replaceAll("\\]","rightBracket");
		result=result.replaceAll("\\(","leftParenthese");
		result=result.replaceAll("\\)","rightParenthese");
		return result;
	}
	public String reverse(String stmt) {
		/*translate to special character*/
		String result;
		result=stmt.replaceAll("backslash","\\\\");
		result=result.replaceAll("leftBrace","\\{");
		result=result.replaceAll("rightBrace","\\}");
		result=result.replaceAll("leftBracket","\\[");
		result=result.replaceAll("rightBracket","\\]");
		result=result.replaceAll("leftParenthese","\\(");
		result=result.replaceAll("rightParenthese","\\)");
		return result;
	}

}
