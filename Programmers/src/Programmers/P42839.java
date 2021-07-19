package Programmers;

import java.util.*;

public class P42839 { // 소수 찾기
	
	HashSet<Integer> set;

	public static void main(String[] args) {
		P42839 p = new P42839();
		
		System.out.println(p.solution("17"));
	}
	
	public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        
        String[] s = numbers.split("");
        boolean[] visited = new boolean[s.length];
        
        for(int i = 0; i < numbers.length(); i++) {
        	set.add(Integer.parseInt(s[i]));
        }
        
        // 길이별 순열 찾아서 집합에 추가
        for(int i = 2; i <= numbers.length(); i++) {
        	perm(s, visited, 0, i, "");
        }
        
        HashMap<Integer, Boolean> prime = findPrime(numbers.length());
        
        for(Integer num : set) {
        	if(prime.get(num)) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	// 순열 구하기
	private void perm(String[] s, boolean[] visited, int start, int end, String target) {
		
		if(start == end) {
			set.add(Integer.parseInt(target));
			return;
		}
		
		for(int i = 0; i < s.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(s, visited, start+1, end, target+s[i]);
				visited[i] = false;
			}
		}
	}
	
	// 소수 찾기
	private HashMap<Integer, Boolean> findPrime(int len){
		
		HashMap<Integer, Boolean> prime = new HashMap<>();
		prime.put(0, false);
		prime.put(1, false);
		
		boolean flag; int sqrt;
		int limit = (int)Math.pow(10, len);
		for(int i = 2; i < limit; i++) {
			flag = false;
			// 시간 단축을 위해 그 수의 제곱근까지만 나눠 본다.
			sqrt = (int)(Math.pow(i,0.5));
			for(int j = 2; j <= sqrt; j++) {
				if(i % j == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				prime.put(i, true);
			}else {
				prime.put(i, false);
			}
		}
		
		return prime;
	}
	
	// 모범 답안
//	public int solution(String numbers) {
//        HashSet<Integer> set = new HashSet<>();
//        permutation("", numbers, set);
//        int count = 0;
//        while(set.iterator().hasNext()){
//            int a = set.iterator().next();
//            set.remove(a);
//            if(a==2) count++;
//            if(a%2!=0 && isPrime(a)){
//                count++;
//            }
//        }        
//        return count;
//    }
//
//    public boolean isPrime(int n){
//        if(n==0 || n==1) return false;
//        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//
//        public void permutation(String prefix, String str, HashSet<Integer> set) {
//        int n = str.length();
//        //if (n == 0) System.out.println(prefix);
//        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
//        for (int i = 0; i < n; i++)
//          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
//
//    }
}
