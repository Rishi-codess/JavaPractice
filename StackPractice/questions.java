package StackPractice;
import java.util.*;
public class questions {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        int idx = 0;
        while(idx!= str.length() ) {
            st.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!st.isEmpty()){
            char curr = st.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    public static void stockSpan(int [] arr){

    }
    public static void main(String []args){
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        String str =  "hello";
        String result = reverseString(str);
        System.out.println(result);
        //for reverse stack
        Stack <Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        reverseStack(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
