package etc;

import java.io.*;
import java.util.*;

public class DQ_Implement {
	
	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		DQ_Implement dq = new DQ_Implement();
		
		// dq.Q7();
		// dq.Q8();
		// dq.Q9();
		dq.Q11();
	}
	
	public void Q7() { // 럭키 스트레이트
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String s = br.readLine();
			
			String s1 = s.substring(0, s.length()/2);
			String s2 = s.substring(s.length()/2, s.length());
			
			int n1 = 0;
			int n2 = 0;
			for(int i = 0; i < s.length()/2; i++) {
				n1 += Integer.parseInt(s1.substring(i, i+1));
				n2 += Integer.parseInt(s2.substring(i, i+1));
			}
			
			if(n1 == n2) {
				bw.write("LUCKY");
			}else {
				bw.write("READY");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void Q8() { // 문자열 재정렬
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			char[] charArray = br.readLine().toCharArray();
			Arrays.sort(charArray);
			String s = new String(charArray);
			
			System.out.println(s);
			
			int idx = s.length();
			for(int i = 0; i < s.length(); i++) {
				int c = (int)s.charAt(i);
				if(c >= 65 && c <= 90) {
					idx = i;
					break;
				}
			}
			
			int num = 0;
			for(int i = 0; i < idx; i++) {
				num += Integer.parseInt(s.substring(i,i+1));
			}
			
			bw.write(s.substring(idx) + Integer.toString(num));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void Q9() { // 문자열 압축
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String s = br.readLine();
			String now = "";
			String ans = s;
			
			for(int i = 1; i <= s.length()/2; i++) {
				
				int cnt = 1;
				int idx = 0;
				for(int j = i; j+i <= s.length(); j += i) {
					idx = j+i;
					if(s.substring(j-i,j).equals(s.substring(j,j+i))) {
						cnt++;
					}else {
						if(cnt == 1) {
							now += s.substring(j-i,j);
						}else {
							now += (Integer.toString(cnt) + s.substring(j-i,j));
						}
						cnt = 1;
					}
				}
				
				if(cnt != 1) {
					now += (Integer.toString(cnt) + s.substring(idx-i,idx));	
				}else {
					now += s.substring(idx-i,idx);
				}
				
				// 꼬다리 붙여주기
				now += s.substring(idx,s.length());
				
				if(ans.length() > now.length()) ans = now;
				now = "";
			}
			
			bw.write(ans);
			bw.newLine();
			bw.write(Integer.toString(ans.length()));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void Q11() { // 뱀
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			
			int k = Integer.parseInt(br.readLine());
			for(int i = 0; i < k; i++) {
				String[] s = br.readLine().split(" ");
				int row = Integer.parseInt(s[0])-1;
				int col = Integer.parseInt(s[1])-1;
				
				board[row][col] = 1;
			}
			
			board[0][0] = 2;
			
			int time = 0;
			int direction = 0;
			Queue<int[]> snake = new LinkedList<>();
			snake.add(new int[] {0,0});
			int[] head = {0,0};
			
			int l = Integer.parseInt(br.readLine());
			for(int i = 0; i < l; i++) {
				String[] s = br.readLine().split(" ");
				int t  = Integer.parseInt(s[0]);
				String d = s[1];
				
				for(int j = time+1; j < t; j++) {
					int nx = head[0] + dx[direction];
					int ny = head[1] + dy[direction];
					
					if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
						if(board[nx][ny] == 0) { // 암 것도 없음
							head[0] = nx;
							head[1] = ny;
							board[nx][ny] = 2;
							snake.add(new int[] {nx,ny});
							
							// 꼬리 부분 제거
							int[] tmp = snake.poll();
							board[tmp[0]][tmp[1]] = 0;
							
						}else if(board[nx][ny] == 1) { // 사과 먹음
							head[0] = nx;
							head[1] = ny;
							board[nx][ny] = 2;
							snake.add(new int[] {nx,ny});
						}else { // 뱀에 부딫힘
							System.out.println(j+1);
							return;	
						}
					}else { // 벽에 부딪힘
						System.out.println(j+1);
						return;
					}
				}
				
				// 회전하는 부분
				direction = turn(d, direction);
				time = t;
				
				int nx = head[0] + dx[direction];
				int ny = head[1] + dy[direction];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(board[nx][ny] == 0) { // 암 것도 없음
						head[0] = nx;
						head[1] = ny;
						board[nx][ny] = 2;
						snake.add(new int[] {nx,ny});
						
						// 꼬리 부분 제거
						int[] tmp = snake.poll();
						board[tmp[0]][tmp[1]] = 0;
						
					}else if(board[nx][ny] == 1) { // 사과 먹음
						head[0] = nx;
						head[1] = ny;
						board[nx][ny] = 2;
					}else { // 뱀에 부딫힘
						System.out.println(t+1);
						return;
					}
				}else { // 벽에 부딪힘
					System.out.println(t+1);
					return;
				}
			}
			time++;
			
			while(time >= 0) {
				time++;
				
				int nx = head[0] + dx[direction];
				int ny = head[1] + dy[direction];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(board[nx][ny] == 0) { // 암 것도 없음
						head[0] = nx;
						head[1] = ny;
						board[nx][ny] = 2;
						snake.add(new int[] {nx,ny});
						
						// 꼬리 부분 제거
						int[] tmp = snake.poll();
						board[tmp[0]][tmp[1]] = 0;
						
					}else if(board[nx][ny] == 1) { // 사과 먹음
						head[0] = nx;
						head[1] = ny;
						board[nx][ny] = 2;
					}else { // 뱀에 부딫힘
						System.out.println(time+1);
						return;
					}
				}else { // 벽에 부딪힘
					System.out.println(time+1);
					return;
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int turn(String d, int direction) {
		
		if(d.equals("D")) {
			if(direction == 3) {
				direction = 0;
			}else {
				direction++;
			}
		}else {
			if(direction == 0) {
				direction = 3;
			}else {
				direction--;
			}
		}
		
		return direction;
	}
	
	public void Q13() { // 치킨 배달
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int ans = Integer.MAX_VALUE;
			
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			
			int[][] map = new int[n][n];
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					
					if(map[i][j] == 2) cnt++;
				}
			}
			
			for(int i = cnt; i > m; i--) {
				
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
