package StackPractice;

import java.util.Stack;

public class StockSpan {
    public static void stockSpan(int []stocks, int [] span){
        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        //s.push(span[0]);
        s.push(0);
        for(int i = 1; i<stocks.length;i++ ){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);  //Stack does not know index or element. It simply stores the value you push.

        }

    }
    public static void main(String [] args){
        int []stocks = {100,80,60,70,60,85,100};
        int []span = new int[stocks.length];
        stockSpan(stocks, span);
        for(int num : span){
            System.out.println(num);
        }
    }
}
