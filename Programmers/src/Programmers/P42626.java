package Programmers;
import data_structure.Heap;
import java.util.*;

public class P42626 {
	public static void main(String[] args) {
		P42626 p = new P42626();
		int array[] = {1, 2};
		System.out.println(p.solution(array, 7));
	}
	
	// 우선순위 큐(라이브러리) => Heap으로 구현
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
        	priorityQueue.add(scoville[i]);
        }
        
        
        while(true){
        	// 최소값이 K 이상 ==> 종료
            if(priorityQueue.peek() >= K) {
            	break;
            }
            
            if(priorityQueue.size() == 1){
                return -1;
            }
            
            int sco = priorityQueue.poll();
            sco += 2*priorityQueue.poll();
            priorityQueue.add(sco);
            answer += 1;
        }
        
        return answer;
    }
	
	// Heap 이용(최소힙) => 완전 이진 트리로 모든 노드 값은 자식 노드보다 작다. 루트 값이 가장 작다.
	// 				  => 부모 노드와 비교하므로 연산이 적어진다!
	// 배열은 데이터 삽입 및 삭제 과정에서 당기거나 미는 연산이 필요
	// 삽입 위치를 찾기 위해 모든 데이터와 우선순위 비교
//	public int solution(int[] scoville, int K) {
//        int answer = 0;
//        
//        
//        Heap<Integer> heap = new Heap<>();
//        for(int i = 0; i < scoville.length; i++){
//        	heap.add(scoville[i]);
//        }
//        
//        
//        while(true){
//        	// 최소값이 K 이상 ==> 종료
//            if(heap.peek() >= K) {
//            	break;
//            }
//            
//            if(heap.size() == 1){
//                return -1;
//            }
//            
//            int sco = heap.remove();
//            sco += 2*heap.remove();
//            heap.add(sco);
//            answer += 1;
//        }
//        
//        return answer;
//    }
	
	// ArrayList 이용
//	boolean flag = false;
//	
//	public int solution(int[] scoville, int K) {
//        int answer = 0;
//        boolean flag = false;
//        
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i = 0; i < scoville.length; i++){
//            arr.add(scoville[i]);
//        }
//        
//        arr.sort(null);
//        
//        while(true){
//            if(arr.size() == 1 && arr.get(0) < K){
//                return -1;
//            }
//            
//            for(int i = 0; i < arr.size(); i++){
//                if(arr.get(i) < K){
//                    break;
//                }
//                flag = true;
//            }
//            
//            if(flag){
//                break;
//            }
//            
//            int sco = arr.get(0) + arr.get(1)*2;
//            arr.remove(0);
//            arr.remove(0);
//            arr.add(0,sco);
//            arr.sort(null);
//            
//            answer += 1;
//        }
//        
//        return answer;
//    }
}
