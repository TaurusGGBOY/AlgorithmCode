import java.util.Stack;

class Solution {
	public String removeOuterParentheses(String S) {
		Stack<Character> characterStack = new Stack<>();

		int flag=0;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c=='(')
			{
				characterStack.add(c);
				if(characterStack.size()!=1)
					stringBuilder.append(c);
			}
			else{
				characterStack.pop();
				if(characterStack.size()!=0)
				{
					stringBuilder.append(')');
				}
			}
		}
		return stringBuilder.toString();
	}
}