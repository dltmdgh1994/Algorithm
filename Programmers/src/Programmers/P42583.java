package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P42583 { // 다리를 지나는 트럭

	public static void main(String[] args) {
		P42583 p = new P42583();

		int[] t = {7,4,5,6};
		System.out.println(p.solution(2, 10, t));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        
		// 대기열에 있는 트럭들
        Queue<truck> q = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
        	q.add(new truck(truck_weights[i], 0));
        }
        
        // 현재 다리에 있는 트럭들
        ArrayList<truck> inBridge = new ArrayList<>();
        
        int time = 0;
        int bridge_weight = 0;
        while(!q.isEmpty() || !inBridge.isEmpty()) {
        	time++;
        	
        	if(!q.isEmpty()) {
        		int w = q.peek().getWeight();
            	if(bridge_weight + w <= weight) {
            		bridge_weight += w;
            		inBridge.add(q.poll());
            	}
        	}
        	
        	int cnt = 0;
        	for(truck t : inBridge) {
        		t.incPos();
        		
        		if(t.getPos() == bridge_length) {
        			cnt++;
        		}
        	}
        	
        	// 빠져 나간 트럭들은 지운다.
        	for(int i = 0; i < cnt; i++) {
        		bridge_weight -= inBridge.get(0).getWeight();
        		inBridge.remove(0);
        	}
        }
        
        return ++time;
    }
}

class truck{
	
	int weight;
	int pos;
	
	public truck(int weight, int pos) {
		this.weight = weight;
		this.pos = pos;
	}

	public int getWeight() {
		return weight;
	}

	public int getPos() {
		return pos;
	}

	public void incPos() {
		this.pos++;
	}
}
