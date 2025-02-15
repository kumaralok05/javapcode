package leetCodeCoding;

import java.util.Stack;

public class ValidPranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "({}[])";
		//isValid(s);
		if(isValid(s)) {
			System.out.println("true");
			}else {
				System.out.println("false");
			}
			}
		
		
		

	

	public static boolean isValid(String s) {
		if (s == null || s.length() % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;

			case ')':
				if (stack.isEmpty() || stack.pop() != ')') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '}') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != ']') {
					return false;
				}
				break;
			//default:
			//	return false;

			}
			

		}

		return stack.isEmpty();

	}

}
