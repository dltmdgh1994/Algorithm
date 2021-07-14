package Programmers;

import java.util.*;

public class P64065 { // Ʃ��

	public static void main(String[] args) {
		P64065 p = new P64065();
		
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		int[] ans = p.solution(s);
		for(int i = 0 ; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public int[] solution(String s) {
        
        String[] element = s.substring(0, s.length()-1).split("}");
        
        int len = element.length;
        int[] idx = new int[len];
        int[] answer = new int[len];
        
        for(int i = 0; i < element.length; i++) {
        	element[i] = element[i].substring(2);
        }
        
        // HashSet�� ������ ���� ������ LinkedHashSet �̿�
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i = 0; i < len; i++) {
        	int idxLen = element[i].split(",").length;
        	// ���̰� ª�� ������ element�� index�� ����
        	idx[idxLen-1] = i;
        }
        
        for(int i = 0; i < len; i++) {
        	int index = idx[i];
        	String[] str = element[index].split(",");
        	
        	for(int j = 0; j < str.length; j++) {
        		set.add(str[j]);
        	}
        }
        
        int i = 0;
        for(String elem : set) {
        	answer[i] = Integer.parseInt(elem);
        	i++;
        }
        
        return answer;
    }
	
//    public int[] solution(String s) {
//        Set<String> set = new HashSet<>();
//        
//        // trim ���ڿ� �� ���� ���� ����
//        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
//        
//        // ���̰� ª�� ������ ����
//        // ���������� ������ �� �� �ִٴ� ���� �����.
//        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
//        
//        int[] answer = new int[arr.length];
//        int idx = 0;
//        for(String s1 : arr) {
//            for(String s2 : s1.split(",")) {
//            	// HashSet�� ������ ������ add�� ���� ���� ���θ� Ȯ��
//                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
//            }
//        }
//        return answer;
//    }
}
