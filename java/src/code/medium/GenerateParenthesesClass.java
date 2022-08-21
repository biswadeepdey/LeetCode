package code.medium;

import java.util.*;

public class GenerateParenthesesClass {

	public static boolean isValidCombo(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : arr) {
			if (c == '(')
				stack.push(c);
			else if (stack.size() > 0) {
				stack.pop();
			}
		}
		return stack.size() == 0;
	}

	public static String swap(String str, int i, int j) {
		char[] ca = str.toCharArray();
		char t = ca[i];
		ca[i] = ca[j];
		ca[j] = t;
		return String.valueOf(ca);
	}

	public static void permuteCheck(String str, Set<String> finalList, int start, int n) {
		if (start == n) {
			if (isValidCombo(str)) {
				finalList.add(str);
			}
		}

		for (int i = start; i < n; i++) {
			str = swap(str, start, i);
			permuteCheck(str, finalList, start + 1, n);
			str = swap(str, start, i);
		}
	}

	private static void createParenthesis(String str, int n, ArrayList<String> finalList, int openCount,
			int closeCount) {
		if (closeCount > openCount)
			return;

		if (str.length() == n * 2) {
			finalList.add(str);
			return;
		}

		if (openCount < n)
			createParenthesis(str + "(", n, finalList, openCount + 1, closeCount);
		if (closeCount < n)
			createParenthesis(str + ")", n, finalList, openCount, closeCount + 1);
	}

	public static List<String> generateParenthesis(int n) {
		ArrayList<String> finalList = new ArrayList<String>();
		createParenthesis("", n, finalList, 0, 0);
		return finalList;

	}

	public static void main(String[] args) {
		for (String s : generateParenthesis(3)) {
			System.out.println(s);
		}
	}

}
