import java.util.Stack;

class Solution {
	public int calPoints(String[] ops) {
		int lastPos = 0;
		int[] isValid = new int[ops.length];
		int grade = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < ops.length; i++) {
			switch (ops[i]) {
			case "+":
				int secondRound = stack.pop();
				int firstRound = stack.pop();
				grade += secondRound + firstRound;
				stack.add(firstRound);
				stack.add(secondRound);
				stack.add(firstRound + secondRound);
				break;
			case "D":
				int lastRound = stack.peek();
				grade += lastRound * 2;
				stack.add(lastRound * 2);
				break;
			case "C":
				lastRound = stack.pop();
				grade -= lastRound;
				break;
			default:
				int number = Integer.parseInt(ops[i]);
				grade += number;
				stack.add(number);
				break;
			}
		}
		return grade;
	}
}