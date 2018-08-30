import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class charall {
    public static int getValue(String operation) {
        int result;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                result = 0;
        }
        return result;
    }

    public static void find(String str) {
        System.out.println("input: " + str);
        Stack<String> yunsuan = new Stack<>();
        Stack<String> number = new Stack<>();
        StringTokenizer token = new StringTokenizer(str, "[+ - * / ( )]", true);
        while (token.hasMoreElements()) {
            String s = token.nextToken();
            if (s.matches("\\d+")) {
                number.push(s);
            } else if (yunsuan.isEmpty() || s.equals("(")) {
                yunsuan.push(s);
            } else {
                if (s.equals(")")) {
                    while (!yunsuan.peek().equals("(")) {
                        int result;
                        int a = Integer.valueOf(number.pop());
                        int b = Integer.valueOf(number.pop());
                        result = calResult(yunsuan.pop(), b, a);
                        number.push(result + "");
                    }
                    yunsuan.pop();
                } else {
                    if (getValue(s + "") > getValue(yunsuan.peek() + "")) {
                        yunsuan.push(s);
                    } else {
                        int result;
                        int a = Integer.valueOf(number.pop());
                        int b = Integer.valueOf(number.pop());
                        result = calResult(yunsuan.pop(), b, a);
                        number.push(result + "");
                        yunsuan.push(s);
                    }
                }
            }
        }
        while (!yunsuan.isEmpty()) {
            int result;
            int a = Integer.valueOf(number.pop());
            int b = Integer.valueOf(number.pop());
            result = calResult(yunsuan.pop(), b, a);
            number.push(result + "");
        }
        System.out.println("result: " + number.pop());
    }

    public static int calResult(String c, int x, int y) {
        switch (c) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                return -1;
        }
    }


    public static List<String> toInfixExpression(String s) {
        List<String> ls = new ArrayList<String>();//存储中序表达式
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < s.length());

        return ls;
    }

    public static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<String>();//运算符栈
        List<String> lss = new ArrayList<String>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                s1.push(ss);
            } else if (ss.equals(")")) {
                while (!s1.peek().equals("(")) {
                    lss.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && getValue(s1.peek()) >= getValue(ss)) {
                    lss.add(s1.pop());
                }
                s1.push(ss);
            }
        }
        while (s1.size() != 0) {
            lss.add(s1.pop());
        }
        return lss;
    }

    public static int calculate(List<String> ls) {
        Stack<String> s = new Stack<String>();//数字栈
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result = 0;
                //判断list中的符号
                if (str.equals("+")) {
                    result = a + b;
                } else if (str.equals("-")) {
                    result = a - b;
                } else if (str.equals("*")) {
                    result = a * b;
                } else if (str.equals("/")) {
                    result = a / b;
                }
                s.push("" + result);
            }
        }
        return Integer.parseInt(s.pop());
    }

    public static void main(String[] args) {
        String s = "(((3+4)*5)/7-6+1*5+1000)*2";
        find(s);
    }
}


