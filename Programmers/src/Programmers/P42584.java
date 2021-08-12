package Programmers;

import java.util.Stack;

public class P42584 { // 2 �ֽİ���
	
	public static void main(String[] args) {
	
		P42584 p = new P42584();

		int[] prices = {1, 2, 3, 2, 3};
		int[] ans = p.solution(prices);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> stack = new Stack<>(); 
        
        for(int i = 0; i < prices.length; i++) {
        	
        	// �� ĭ�� ������ ������ 1�ʾ� ����
        	for(Stock stock : stack) {
        		stock.incTime();
        	}
        	
        	if(!stack.isEmpty()) {
        		// �� ������ ���� ���ݺ��� ���ٸ� stack.pop 
        		if(stack.peek().getPrice() > prices[i]) {
        			while(stack.peek().getPrice() > prices[i]) {
                		Stock stock = stack.pop();
                		
                		answer[stock.getIdx()] = stock.getTime();
                		
                		if(stack.isEmpty()) {
                			break;
                		}
                	}
        		}
        	}
        	
        	stack.add(new Stock(i, prices[i]));
        }
        
        while(!stack.isEmpty()) {
        	Stock stock = stack.pop();
        	
        	answer[stock.getIdx()] = stock.getTime();
        }
        
        return answer;
    }
}

class Stock{
	int idx;
	int price;
	int time;
	
	public Stock(int idx, int price) {
		this.idx = idx;
		this.price = price;
		this.time = 0;
	}
	
	public void incTime() {
		this.time++;
	}

	public int getIdx() {
		return idx;
	}

	public int getPrice() {
		return price;
	}

	public int getTime() {
		return time;
	}
}
