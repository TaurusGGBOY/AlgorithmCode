import java.util.Stack;

class Solution {
  public String reverseOnlyLetters(String S) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
          || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
        stack.add(S.charAt(i));
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
          || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
        stringBuilder.append(stack.pop());
      } else {
        stringBuilder.append(S.charAt(i));
      }
    }
    return stringBuilder.toString();

  }
}
