package Algorithm.Java;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) throws Exception{
        System.out.println("result : " + isValid("()"));
    }
    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            Character c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.size() == 0){
                    return false;
                }else{
                    Character prev = stack.pop();
                    if(prev == '(' && c == ')'){
                        continue;
                    }else if(prev == '[' && c == ']'){
                        continue;
                    }else if(prev == '{' && c == '}'){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
