package gscdz.java;
/*����url�޷����������ַ�
 * translateת��ΪӢ��
 * Reverseת��Ϊ��Ӧ�������ַ�
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
