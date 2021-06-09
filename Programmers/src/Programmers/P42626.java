package Programmers;
import data_structure.Heap;
import java.util.*;

public class P42626 {
	public static void main(String[] args) {
		P42626 p = new P42626();
		int array[] = {1, 2};
		System.out.println(p.solution(array, 7));
	}
	
	// �켱���� ť(���̺귯��) => Heap���� ����
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
        	priorityQueue.add(scoville[i]);
        }
        
        
        while(true){
        	// �ּҰ��� K �̻� ==> ����
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
	
	// Heap �̿�(�ּ���) => ���� ���� Ʈ���� ��� ��� ���� �ڽ� ��庸�� �۴�. ��Ʈ ���� ���� �۴�.
	// 				  => �θ� ���� ���ϹǷ� ������ ��������!
	// �迭�� ������ ���� �� ���� �������� ���ų� �̴� ������ �ʿ�
	// ���� ��ġ�� ã�� ���� ��� �����Ϳ� �켱���� ��
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
//        	// �ּҰ��� K �̻� ==> ����
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
	
	// ArrayList �̿�
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
