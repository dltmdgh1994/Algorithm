package Programmers;

import java.util.*;

public class P64064 { // 3 �ҷ� �����

	public static void main(String[] args) {
		
		P64064 p = new P64064();
		
		String[] user_id = {"aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"};
		String[] banned_id = {"*****", "*****", "*****", "*****","*****"};
		
		System.out.println(p.solution(user_id, banned_id));
	}
	
	// �̺�Ʈ ������ ���̵� ����� ��� �迭 user_id
	// �ҷ� ����� ���̵� ����� ��� �迭 banned_id
	HashSet<String> ans = new HashSet<>();
	
	public int solution(String[] user_id, String[] banned_id) {
        
        String[] regex = new String[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
        	
        	String pattern = "";
        	for(int j = 0; j < banned_id[i].length(); j++) {
        		char c = banned_id[i].charAt(j);
        		
        		if(c == '*') {
        			pattern += ".";
        		}else {
        			pattern += c;
        		}
        	}
        	
        	regex[i] = pattern;
        }
        
        // �� �����ϰ� �ٲٴ� ���
//        for(int i = 0 ; i < banned_id.length ; i++) {
//        	regex[i] = banned_id[i].replace("*", ".");
//        }
        
        boolean[] visited = new boolean[user_id.length];
        TreeSet<String> treeSet = new TreeSet<>(); // �׳� HashSet�� ������ �ȵǼ� �ߺ� ����
        backtracking(user_id, regex, visited, treeSet, 0);
        
        return ans.size();
    }
	
	private void backtracking(String[] user_id, String[] regex, boolean[] visited, TreeSet<String> treeSet, int n) {
		
		if(n == regex.length) {
			
			String tmp = "";
			// TreeSet�� �˾Ƽ� �����ϱ� ������ �ߺ� ����
			for(String s : treeSet) {
				tmp += s;
			}

			ans.add(tmp);
			
			return;
		}
		
		for(int i = 0; i < user_id.length; i++) {
			// �� ����߰� ���ԽĿ� �´� user_id
			if(!visited[i] && user_id[i].matches(regex[n])) {
				visited[i] = true;
				treeSet.add(user_id[i]);
				backtracking(user_id, regex, visited, treeSet, n+1);
				visited[i] = false;
				treeSet.remove(user_id[i]);
			}
		}
	}
}
