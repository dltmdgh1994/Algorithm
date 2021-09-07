package Programmers;

import java.util.*;

public class P42628 { // 3 이중우선순위큐

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
        		// 만약 빈 큐에 삭제 명령 시 무시
        		
        		if(num == 1) { // 최댓값 제거
        			
        		}else { // 최솟값 제거
        			
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
		
		// "부모 노드 인덱스 = 자식 노드 인덱스 / 2"을 유지하기 위해 삽입
		heap.add(Integer.MIN_VALUE);
	}
	
	public void add(int val) {
		heap.add(val);
		int idx = heap.size()-1;
		
		// 부모 노드보다 커질 때까지 혹은 루트에 도달할 때까지 반복
		while(idx > 1 && heap.get(idx/2) > heap.get(idx)) {
			int tmp = heap.get(idx/2);
			heap.set(idx/2, heap.get(idx));
			heap.set(idx, tmp);
			
			idx /= 2; // 부모 노드 인덱스로 이동
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
