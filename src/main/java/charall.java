import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        char c[] = str.toCharArray();
        Stack yunsuan = new Stack<Character>();
        Stack number = new Stack<Character>();
        for (int i = 0; i <c.length; i++) {
            if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/'||c[i] == '('||c[i] == ')') {
                yunsuan.push(c[i]);
            } else {
                number.push(c[i]);
            }
        }
        while (!yunsuan.isEmpty())
            System.out.print(yunsuan.pop()+" ");
        System.out.println();
        while (!number.isEmpty())
        System.out.print(number.pop()+" ");
        int result = 0;
        while (!yunsuan.isEmpty()) {
            if (yunsuan.peek().equals('(')||yunsuan.peek().equals(')')){
                yunsuan.pop();
            }
            if (yunsuan.peek().equals('+')) {
                yunsuan.pop();
                result = Integer.parseInt(number.pop().toString()) + Integer.parseInt(number.pop().toString());
                number.push(result);
            } else if (yunsuan.peek().equals('-')) {
                yunsuan.pop();
                result = Integer.parseInt(number.pop().toString()) - Integer.parseInt(number.pop().toString());
                number.push(result);
            } else if (yunsuan.peek().equals('*')) {
                yunsuan.pop();
                result = Integer.parseInt(number.pop().toString()) * Integer.parseInt(number.pop().toString());
                number.push(result);
            } else if (yunsuan.peek().equals('/')) {
                yunsuan.pop();
                result = Integer.parseInt(number.pop().toString()) / Integer.parseInt(number.pop().toString());
                number.push(result);
            } else
                return;
        }
        System.out.println("result: " + number.peek());

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
        Stack<String> s1=new Stack<String>();
        Stack<String> s2=new Stack<String>();
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
        Stack<String> s=new Stack<String>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result=0;
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
        System.out.println(parseSuffixExpression(toInfixExpression("1+(30*5)+(40*2)")));
        List list=toInfixExpression("1+(30*5)+(40*2)/20");
        List rpn=parseSuffixExpression(list);

        System.out.println("计算结果:"+ calculate(rpn));
        char a='0';
        char z='9';
        System.out.println((int)a);
        System.out.println((int)z);
    }

}
