package leetcode;


/**
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author yanfeixiang
 * 
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		return evalRPN(tokens, 0, tokens.length - 1);
	}

	public int evalRPN(String[] tokens, int start, int end) {

		if (start == end)
			return Integer.valueOf(tokens[start]);
		String op = tokens[end];
		int dif = 0;
		int i = end - 1;
		for (; i >= start; i--) {
			if (tokens[i].equals("*") || tokens[i].equals("/")
					|| tokens[i].equals("-") || tokens[i].equals("+")) {
				dif++;
			} else {
				dif--;
			}
			if (dif == -1)
				break;
		}
		// System.out.println(i);
		int left = evalRPN(tokens, start, i - 1);
		int right = evalRPN(tokens, i, end - 1);

		int result;
		if (op.equals("*"))
			result = left * right;
		else if (op.equals("/"))
			result = left / right;
		else if (op.equals("+"))
			result = left + right;
		else
			result = left - right;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new EvaluateReversePolishNotation()
				.evalRPN(new String[] { "3", "-19", "-", "13", "33", "+", "-",
						"-1", "-", "3", "34", "+", "21", "+", "-", "39", "+",
						"-6", "16", "14", "-", "-", "/", "-20", "+", "-5", "-",
						"2", "-", "32", "-", "10", "+", "30", "-", "2", "+",
						"29", "+", "-4", "-2", "+", "+", "-13", "+", "26", "-",
						"11", "+", "16", "-10", "+", "-", "-19", "+", "-5",
						"+", "21", "-13", "+", "-", "31", "+", "24", "+", "37",
						"-", "10", "-", "34", "-", "-10", "+", "-12", "-",
						"17", "+", "-1", "+", "38", "-", "11", "31", "30", "+",
						"+", "+", "3", "+", "5", "+", "36", "-", "7", "-", "8",
						"+", "1", "26", "-7", "+", "-", "-", "-4", "-", "-20",
						"-", "-10", "19", "+", "+", "24", "-", "24", "-",
						"-12", "-10", "+", "+", "-10", "-", "-16", "+", "38",
						"+", "22", "-7", "+", "+", "28", "+", "19", "-", "17",
						"-7", "*", "-9", "-", "+", "-18", "+", "10", "-", "20",
						"+", "-13", "+", "4", "-6", "-", "+", "3", "-", "28",
						"25", "+", "-17", "4", "-", "-1", "-", "+", "+", "-15",
						"+", "31", "-", "19", "+", "-9", "-", "17", "17",
						"-19", "+", "-", "+", "1", "-", "-18", "-17", "+", "+",
						"15", "-", "-11", "+", "-1", "+", "12", "-", "39", "+",
						"6", "+", "4", "-8", "-", "+", "25", "+", "33", "-",
						"27", "-", "5", "-11", "8", "26", "-11", "-", "-10",
						"/", "15", "-", "+", "15", "+", "-", "5", "-", "18",
						"+", "-9", "38", "-", "32", "-", "-17", "5", "25", "+",
						"+", "-7", "-16", "-11", "+", "-", "25", "24", "-",
						"+", "-", "-", "+", "+", "+", "8", "-", "6", "-", "28",
						"+", "9", "-19", "-1", "-", "+", "-", "37", "31", "-6",
						"-", "-3", "33", "-14", "-", "+", "+", "-4", "+", "-",
						"4", "17", "+", "+", "+", "20", "-", "-7", "+", "8",
						"-", "30", "-", "36", "14", "-", "+", "9", "-", "-20",
						"18", "38", "+", "10", "+", "+", "-", "37", "-", "28",
						"-", "15", "-", "22", "34", "+", "31", "-17", "+", "+",
						"7", "-", "+", "33", "+", "35", "-", "26", "+", "28",
						"+", "-17", "+", "11", "-3", "+", "+", "30", "+", "-3",
						"-14", "-", "-", "23", "-", "19", "9", "30", "28", "-",
						"-3", "+", "+", "10", "-", "27", "30", "+", "-", "-12",
						"1", "+", "-", "+", "-20", "+", "-", "-18", "24", "+",
						"24", "33", "26", "-", "+", "*", "24", "29", "-",
						"-13", "17", "+", "+", "*", "-", "38", "+", "5", "-4",
						"-", "-", "-7", "-", "11", "+", "-14", "-", "30", "-",
						"-3", "37", "-", "+", "5", "22", "+", "-", "23", "+",
						"21", "-20", "+", "-", "30", "+", "17", "+", "30", "-",
						"10", "20", "+", "-", "3", "+", "23", "8", "-3", "-",
						"-18", "-", "+", "-", "39", "+", "-11", "+", "23", "-",
						"8", "+", "34", "-", "-2", "+", "-5", "-", "2", "+",
						"1", "+", "-8", "34", "+", "27", "-", "+", "36", "-",
						"-7", "-20", "12", "20", "-", "-3", "+", "-19", "+",
						"+", "-", "9", "+", "-", "15", "+", "6", "-", "37",
						"+", "-16", "-", "37", "13", "+", "+", "12", "0", "+",
						"-", "-18", "-", "-1", "7", "+", "+", "24", "-", "-18",
						"+", "39", "+", "-13", "-", "29", "-", "0", "-6", "+",
						"-", "-1", "39", "-17", "+", "-", "+", "23", "+", "3",
						"+", "9", "13", "35", "-", "-", "-", "9", "+", "4",
						"+", "26", "+", "18", "+", "35", "-15", "-", "6", "-",
						"-", "19", "14", "5", "-", "-", "-", "28", "-", "24",
						"5", "21", "+", "28", "+", "+", "+", "35", "-20", "+",
						"+", "-20", "-", "-13", "-", "-19", "+", "-6", "+",
						"-2", "-", "8", "-", "14", "12", "+", "+", "-18", "-4",
						"+", "30", "-", "+", "27", "-10", "-", "-", "-8", "-",
						"15", "12", "-", "-", "21", "+", "35", "+", "32", "-",
						"6", "+", "-3", "38", "+", "-1", "4", "+", "+", "-",
						"34", "+", "-14", "-", "-9", "26", "+", "-", "11", "+",
						"-10", "-", "37", "-", "20", "+", "38", "-", "-12",
						"-18", "-", "-", "-12", "+", "-2", "34", "-", "-",
						"-10", "12", "+", "+", "-8", "-", "-17", "+", "36",
						"-", "-16", "+", "18", "-", "25", "+", "16", "7", "-",
						"31", "10", "15", "22", "-1", "-", "+", "19", "/",
						"12", "13", "-", "-", "4", "-", "-", "+", "+", "34",
						"+", "-", "5", "+", "-15", "12", "32", "+", "-4", "7",
						"29", "-", "+", "-8", "-", "-", "+", "+", "-4", "12",
						"-", "-", "0", "-", "27", "+", "26", "-20", "-12", "+",
						"-", "-8", "19", "-", "+", "23", "-19", "-", "+", "+",
						"-20", "12", "+", "-", "37", "/", "29", "10", "+", "-",
						"30", "36", "+", "30", "-", "-", "-5", "-", "31", "+",
						"-11", "+", "36", "+", "13", "-", "-6", "-", "-19",
						"+", "12", "-5", "30", "-9", "-", "+", "35", "+", "-",
						"+", "18", "+", "1", "-6", "+", "7", "-", "-", "2",
						"9", "-", "+", "-15", "36", "2", "+", "+", "+", "-8",
						"+", "20", "+", "4", "-", "17", "+", "13", "-", "-20",
						"-", "17", "-", "-9", "+", "-4", "34", "-14", "24",
						"-", "-", "+", "-15", "-3", "+", "-", "+", "32", "+",
						"2", "17", "-", "+", "-14", "24", "+", "+", "12", "-",
						"6", "+", "-5", "-", "5", "-", "7", "-", "19", "-16",
						"+", "/", "12", "-", "29", "-", "1", "+", "35", "+",
						"-18", "+", "1", "-3", "-", "-", "-15", "-", "-8",
						"-20", "-", "-5", "+", "21", "+", "+", "15", "35", "+",
						"-", "-15", "+", "24", "-", "-15", "-", "-5", "+",
						"-1", "+", "9", "-", "3", "-", "-9", "38", "+", "-7",
						"+", "-", "31", "-", "-11", "+", "15", "13", "+", "+",
						"19", "-8", "-", "+", "13", "-", "35", "-", "-1", "-",
						"-14", "-", "19", "+", "-18", "+", "30", "/", "34",
						"-", "37", "-", "32", "-", "36", "-", "12", "+", "29",
						"26", "+", "35", "-", "-", "-15", "-1", "15", "+", "+",
						"10", "+", "-", "-8", "+", "-2", "+", "21", "27", "-",
						"+", "-9", "-", "34", "-", "6", "-", "4", "+", "23",
						"-", "19", "-", "-3", "-", "-11", "-", "0", "+", "-4",
						"-", "-3", "3", "+", "+", "-5", "11", "21", "13", "-",
						"12", "10", "-", "-", "-", "-16", "-", "20", "-", "+",
						"-", "-3", "10", "-11", "-13", "20", "+", "+", "-11",
						"+", "-", "-", "-", "-9", "-", "18", "+", "22", "-",
						"-20", "+", "39", "16", "-", "-", "36", "+", "25", "+",
						"39", "-", "-15", "-8", "+", "-", "-9", "-", "-10",
						"34", "-", "-7", "+", "-", "-7", "-", "-2", "-13",
						"33", "25", "+", "+", "-", "+", "32", "-", "18", "-",
						"29", "-", "30", "+", "10", "6", "-", "-", "12", "*",
						"-18", "-", "-7", "*", "15", "29", "-", "-", "9", "17",
						"4", "-", "-12", "-10", "+", "-", "+", "39", "6", "-5",
						"+", "-", "+", "+", "25", "-6", "18", "-20", "39", "-",
						"-6", "31", "+", "24", "-", "36", "-", "+", "-", "+",
						"-", "+", "-6", "26", "-", "-", "-7", "+", "-7", "-",
						"-19", "13", "6", "+", "9", "29", "+", "-", "-12",
						"20", "+", "+", "5", "-", "+", "-2", "-", "+", "-14",
						"-", "7", "+", "24", "-", "20", "-18", "0", "-", "+",
						"-", "22", "-19", "+", "+", "31", "+", "-17", "+",
						"10", "+", "-1", "+", "22", "+", "18", "14", "36", "+",
						"4", "10", "+", "-", "-2", "+", "17", "-", "-", "+",
						"22", "37", "14", "-", "-", "-", "36", "+", "34", "-",
						"-14", "+", "-4", "+", "17", "20", "-", "-3", "-", "-",
						"2", "24", "-10", "-", "3", "+", "27", "+", "-", "+",
						"-15", "5", "8", "-", "-9", "27", "+", "+", "-", "+",
						"-13", "30", "9", "+", "-", "2", "-", "-", "-4", "-13",
						"-", "-", "27", "-", "15", "35", "38", "-3", "22", "+",
						"-", "+", "-", "+", "2", "+", "-19", "38", "+", "-13",
						"+", "+", "18", "+", "33", "-", "8", "+", "31", "+",
						"-1", "-", "19", "-", "-8", "+", "21", "-", "-14", "-",
						"38", "10", "+", "16", "-", "+", "1", "-", "18", "37",
						"+", "+", "-10", "-", "21", "29", "+", "+", "5", "-",
						"-16", "-", "-1", "-", "26", "-6", "+", "+", "5", "-1",
						"7", "-", "17", "5", "+", "-2", "-", "20", "39", "0",
						"+", "21", "-", "-14", "+", "-", "13", "+", "+", "-",
						"-19", "-10", "-", "-10", "-", "-", "+", "-20", "+",
						"-", "-2", "+", "21", "+", "33", "-", "32", "+", "-7",
						"+", "21", "-", "-12", "8", "-6", "16", "-", "25", "+",
						"-", "-", "+", "35", "-", "-11", "-", "-2", "+", "39",
						"22", "-20", "0", "+", "+", "+", "-", "-2", "-14", "+",
						"19", "2", "-", "-", "+", "4", "+", "5", "-7", "-",
						"13", "-", "-", "-10", "33", "+", "37", "+", "/", "-2",
						"-18", "+", "+", "17", "-", "21", "-", "29", "39", "+",
						"+", "-18", "-17", "11", "-", "+", "+", "15", "-",
						"36", "-", "37", "22", "-5", "11", "17", "-", "+", "+",
						"-", "-", "4", "-19", "+", "-", "-12", "-", "-5", "33",
						"+", "10", "-", "*", "-9", "+", "-4", "+", "-14", "+",
						"33", "-", "-2", "-", "-9", "/", "-6", "19", "28", "-",
						"-", "-7", "+", "*", "34", "+", "13", "-", "39", "-16",
						"+", "-", "6", "3", "-18", "-", "+", "-", "30", "1",
						"+", "-", "15", "+", "36", "+", "-4", "+", "-10", "-",
						"33", "3", "31", "-2", "-", "+", "-2", "-", "15", "+",
						"36", "-", "-", "+", "15", "+", "8", "+", "18", "*",
						"24", "35", "+", "+", "5", "-", "2", "+", "38", "+",
						"4", "-18", "/", "+", "0", "-", "4", "+", "-2", "0",
						"-2", "-14", "-19", "14", "27", "-", "-", "-", "-19",
						"-", "+", "+", "+", "21", "+", "-10", "-9", "-", "-",
						"+", "-18", "-", "14", "-", "1", "-11", "+", "-9",
						"30", "-", "+", "-17", "-", "-17", "-", "-", "35", "*",
						"-1", "+", "-16", "+", "-14", "+", "-16", "4", "*",
						"+", "38", "*", "12", "13", "+", "-", "-9", "-6", "+",
						"+", "-9", "-", "13", "0", "-14", "-", "-", "-3", "20",
						"29", "+", "-", "-", "-", "25", "+", "29", "+", "0",
						"-16", "-", "-17", "+", "14", "-", "-", "10", "-6",
						"+", "-", "32", "11", "+", "-3", "31", "2", "+", "+",
						"-2", "+", "-", "+", "33", "-", "12", "37", "-12", "-",
						"21", "-", "+", "-", "-13", "-", "-14", "-", "13", "+",
						"5", "21", "-", "-", "-3", "+", "31", "-", "-12", "-8",
						"-", "-", "20", "-", "-5", "17", "24", "4", "-15", "+",
						"-", "37", "-", "+", "+", "+", "39", "0", "-", "-",
						"36", "-", "-19", "+", "-20", "-", "35", "+", "-7",
						"23", "+", "-", "-13", "+", "-6", "26", "-", "-", "15",
						"+", "-15", "-19", "-", "+", "-10", "+", "-10", "+",
						"-5", "+", "-4", "-", "1", "+", "32", "-", "26", "+",
						"2", "-", "20", "11", "-", "28", "-", "-", "3", "+",
						"32", "+", "13", "+", "39", "-", "31", "-8", "-12",
						"+", "-1", "+", "+", "+", "38", "-9", "-", "-", "32",
						"-", "16", "-", "-2", "-", "12", "-", "2", "+", "29",
						"-", "17", "31", "+", "-9", "1", "+", "3", "-", "+",
						"4", "+", "+", "-17", "17", "-", "-", "37", "23", "-6",
						"-", "-5", "-8", "+", "-", "+", "-", "39", "-", "34",
						"8", "-", "14", "*", "-", "16", "-", "-10", "25", "-",
						"-", "-18", "28", "-", "+", "-11", "+", "-12", "+",
						"8", "13", "-", "39", "22", "0", "-", "+", "-", "-",
						"19", "+", "-18", "-", "-5", "-18", "28", "-", "-",
						"+", "3", "-", "19", "-8", "-4", "+", "-", "-", "24",
						"-", "-13", "+", "11", "-", "20", "-", "-12", "-18",
						"-", "+", "-15", "+", "24", "-", "23", "+", "-8", "+",
						"37", "-", "-19", "+", "27", "23", "+", "-", "19", "+",
						"-14", "+", "27", "-", "16", "+", "3", "+", "-6", "+",
						"22", "27", "-", "+", "18", "-", "18", "+", "-20", "+",
						"-9", "-", "34", "/", "-3", "-", "34", "-", "-8", "+",
						"38", "+", "29", "+", "-18", "-", "20", "-", "23",
						"28", "-", "+", "14", "34", "-", "-", "14", "-", "32",
						"29", "+", "+", "-2", "+", "13", "-18", "-18", "4",
						"-15", "-19", "+", "31", "+", "+", "-", "-", "28", "-",
						"-", "-", "32", "+", "12", "25", "27", "+", "+", "-",
						"-14", "29", "-", "+", "21", "+", "1", "-8", "+", "+",
						"19", "-", "32", "-", "11", "18", "-", "30", "+", "22",
						"-", "+", "-17", "32", "-7", "39", "10", "-", "+", "+",
						"+", "-", "18", "-", "-5", "+", "3", "-", "18", "-",
						"-9", "-", "2", "9", "+", "+", "3", "25", "+", "-",
						"36", "4", "-", "36", "-", "30", "+", "+", "-17", "+",
						"-3", "-13", "-", "+", "19", "+", "32", "15", "10",
						"20", "-6", "19", "-", "35", "10", "-", "38", "-", "+",
						"-", "-", "-", "-", "+", "8", "8", "-", "-15", "-",
						"-", "39", "+", "38", "-16", "+", "-", "29", "1", "24",
						"-", "+", "28", "4", "+", "-", "1", "-", "1", "25",
						"-", "28", "-", "+", "+", "-6", "+", "39", "-10", "11",
						"15", "+", "-", "-16", "-", "-", "-", "28", "6", "+",
						"+", "-20", "2", "-", "-12", "-12", "+", "-17", "12",
						"+", "+", "+", "-3", "-", "-", "28", "-", "32", "21",
						"-", "-" }));
	}
}
