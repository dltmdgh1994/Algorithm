package Programmers;

public class P43163 { // 3 단어 변환

	public static void main(String[] args) {
		
		P43163 p = new P43163();

		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(p.solution("hit", "cog", words));
	}
	
	int min = Integer.MAX_VALUE;
	
	public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, 0, visited);
        
        if(min == Integer.MAX_VALUE) {
        	return 0;
        }else {
        	return min;
        }
    }
	
	private void dfs(String begin, String target, String[] words, int cnt, boolean[] visited) {
		
		if(begin.equals(target)) {
			
			if(min > cnt) {
				min = cnt;
			}
			
			return;
		}
		
		for(int i = 0; i < words.length; i++) {
			
			if(!visited[i] && checkDiff(begin, words[i])) {
				
				visited[i] = true;
				dfs(words[i], target, words, cnt+1, visited);
				visited[i] = false;
			}
		}
	}
	
	// 하나만 틀린거 확인
	private boolean checkDiff(String begin, String word) {
		
		int cnt = 0;

		for(int i = 0; i < begin.length(); i++) {
			if(begin.charAt(i) != word.charAt(i)) {
				cnt++;
			}
		}
		
		if(cnt == 1) { 
			return true;
		}else {
			return false;
		}
	}
}
