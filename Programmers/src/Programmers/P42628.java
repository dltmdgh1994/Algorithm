package Programmers;

import java.util.*;

public class P42628 { // 3 ���߿켱����ť

	public static void main(String[] args) {
		
		P42628 p = new P42628();
		
		
		
	}
	
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
        	String op = operations[i].substring(0,1);
        	int num = Integer.parseInt(operations[i].substring(2));
        	
        	if(op.equals("I")) {
        		q.add(num);
        	}else {
        		// ���� �� ť�� ���� ��� �� ����
        		
        		if(num == 1) { // �ִ� ����
        			
        		}else { // �ּڰ� ����
        			
        		}
        	}
        }
        
        
        return answer;
    }
}

// 0 1 2 3 4

class DoubleEndedPriorityQueue{
	
	private ArrayList<Integer> heap;
	
	public DoubleEndedPriorityQueue() {
		heap = new ArrayList<>();
		
		// "�θ� ��� �ε��� = �ڽ� ��� �ε��� / 2"�� �����ϱ� ���� ����
		heap.add(Integer.MIN_VALUE);
	}
	
	public void add(int val) {
		heap.add(val);
		int idx = heap.size()-1;
		
		// �θ� ��庸�� Ŀ�� ������ Ȥ�� ��Ʈ�� ������ ������ �ݺ�
		while(idx > 1 && heap.get(idx/2) > heap.get(idx)) {
			int tmp = heap.get(idx/2);
			heap.set(idx/2, heap.get(idx));
			heap.set(idx, tmp);
			
			idx /= 2; // �θ� ��� �ε����� �̵�
		}
	}
	
	public int removeMin() {
		
		int val = heap.get(1);
		
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int idx = 1;
		while(idx*2 < heap.size()-1) {
			int min = heap.get(idx*2);
		}
		return val;
	}
}
