package Question.interview.pdd;


import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by gump on 2017/11/9.
 */
public class Q2 {
    public static boolean q2(String exp) {
        char input[] = exp.toCharArray();
        LinkedList<Character> branket = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            if (judge(input[i])) branket.add(input[i]);
        }

        if (branket.size() % 2 != 0) return false;

        for (int i = 0, j = 1; j < branket.size(); i++, j++) {
            if ((input[i] == '[' && input[j] == ']') ||
                    (input[i] == '{' && input[j] == '}') ||
                    (input[i] == '(' && input[j] == '(') ||
                    (input[i] == ')' && input[j] == ')')) return false;
            else if ((input[j] == '[' && input[i] == '(') ||
                    (input[j] == '{' && input[i] == '[') ||
                    (input[j] == '{' && input[i] == '(')) return false;
        }

        Stack<Character> s = new Stack<>();
        for (Character c :branket) {
            switch (c){
                case '{':
                    s.push(c);
                    break;
                case '[':
                    s.push(c);
                    break;
                case '(':
                    s.push(c);
                    break;
                case ')':
                    if (s.peek() == '(') s.pop();
                    else return false;
                    break;
                case ']':
                    if (s.peek() == '[') s.pop();
                    else return false;
                    break;
                case '}':
                    if (s.peek() == '{') s.pop();
                    else return false;
                    break;
                default:
                    break;
            }
        }
        return s.isEmpty();
    }

    public static boolean judge(char c) {
        return c == '[' || c == ']' ||
                c == '{' || c == '}' ||
                c == '(' || c == ')';
    }
}
