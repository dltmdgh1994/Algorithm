package etc;

import java.io.*;
import java.util.*;

public class DQ_19 {

	BufferedReader br;
	BufferedWriter bw;
	ArrayList<char[]> allOp;
	
	public static void main(String[] args) {
		
		DQ_19 dq = new DQ_19();
		
		dq.sol();
	}
	
	public void sol() { // 연산자 끼워 넣기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			// 원본 연산자 만들기
			String op = "";
			s = br.readLine().split(" ");
			for(int i = 0; i < 4; i++) {
				int opN = Integer.parseInt(s[i]);
				for(int j = 0; j < opN; j++) {
					if(i == 0) {
						op += "+";
					}else if(i == 1) {
						op += "-";
					}else if(i == 2) {
						op += "x";
					}else {
						op += "/";
					}
				}
			}
			
			// 가능한 연산자 순열 찾기
			allOp = new ArrayList<>();
			boolean[] visited = new boolean[n-1];
			perm(op, visited, 0, "");
			
			// 계산하기
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < allOp.size(); i++) {
				char[] operator = allOp.get(i);
				
				// int result = cal1(arr, operator);
				int result = cal2(arr, operator);
				
				if(result > max) max = result;
				if(result < min) min = result;
			}
			
			bw.write(Integer.toString(max));
			bw.newLine();
			bw.write(Integer.toString(min));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 연산자 순열 생성
	private void perm(String op, boolean[] visited, int depth, String tmp) {
		
		if(depth == op.length()) {
			allOp.add(tmp.toCharArray());
			System.out.println(tmp);
			return;
		}
		
		for(int i = 0; i < op.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(op, visited, depth+1, tmp+op.substring(i,i+1));
				visited[i] = false;
			}
		}
	}
	
	// 연산자의 우선순위를 고려한 경우
	private int cal1(int[] arr, char[] operator) {
		
		ArrayList<Integer> tmpArr = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			tmpArr.add(arr[i]);
		}
		
		ArrayList<Character> tmpOp = new ArrayList<>();
		for(int i = 0; i < operator.length; i++) {
			tmpOp.add(operator[i]);
		}
		
		int cnt = 0;
		for(int i = 0; i < operator.length; i++) {
			char c = tmpOp.get(cnt);
			if(c == 'x') {
				tmpArr.set(cnt, tmpArr.get(cnt)*tmpArr.get(cnt+1));
				tmpArr.remove(cnt+1);
				tmpOp.remove(cnt);
			}else if(c == '/') {
				tmpArr.set(cnt, tmpArr.get(cnt)/tmpArr.get(cnt+1));
				tmpArr.remove(cnt+1);
				tmpOp.remove(cnt);
			}else {
				cnt++;
			}
		}
		
		while(!tmpOp.isEmpty()) {
			char c = tmpOp.get(0);
			if(c == '+') {
				tmpArr.set(0, tmpArr.get(0)+tmpArr.get(1));
				tmpArr.remove(1);
				tmpOp.remove(0);
			}else if(c == '-') {
				tmpArr.set(0, tmpArr.get(0)-tmpArr.get(1));
				tmpArr.remove(1);
				tmpOp.remove(0);
			}
		}
		
		return tmpArr.get(0);
	}
	
	// 연산자의 우선순위를 고려하지 않은 경우
	private int cal2(int[] arr, char[] operator) {
		
		int result = arr[0];
		for(int i = 0; i < operator.length; i++) {
			char op = operator[i];
			int num = arr[i+1];
			
			if(op == '+') {
				result += num;
			}else if(op == '-') {
				result -= num;
			}else if(op == 'x') {
				result *= num;
			}else {
				result /= num;
			}
		}
		
		return result;
	}
}
