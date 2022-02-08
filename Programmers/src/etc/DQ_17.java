package etc;

import java.io.*;
import java.util.*;

public class DQ_17 {

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_17 dq = new DQ_17();
		
		dq.sol();
	}
	
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	
	public void sol() { // 경쟁적 전염
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			
			int[][] map = new int[n][n];

			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[1]);
			int y = Integer.parseInt(s[2]);
			int time = Integer.parseInt(s[0]);
			
			dfs(map, n, time);
			
			bw.write(Integer.toString(map[x-1][y-1]));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void dfs(int[][] map, int n, int time) {
		// 우선순위큐를 통해 시간, 바이러스번호를 기준으로 정렬
		PriorityQueue<Virus> q = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					q.add(new Virus(i, j, map[i][j], 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Virus v = q.poll();
			int x = v.getX();
			int y = v.getY();
			int num = v.getNum();
			int t = v.getTime();
			
			// 해당 시간이 되면 리턴
			if(t == time) return;
			
			for(int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(map[nx][ny] == 0) { // 아직 전염 안됐으면
						map[nx][ny] = num;
						q.add(new Virus(nx, ny, num, t+1));
					}
				}
			}
		}
	}
}

// 시간이 빠를수록, 번호가 작을수록 먼저
class Virus implements Comparable<Virus>{
	int x;
	int y;
	int num;
	int time;
	
	public Virus(int x, int y, int num, int time) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
		this.time = time;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNum() {
		return num;
	}

	public int getTime() {
		return time;
	}

	@Override
	public int compareTo(Virus o) {
		// TODO Auto-generated method stub
		if(this.time > o.getTime()) {
			return 1;
		}else if(this.time < o.getTime()) {
			return -1;
		}else {
			if(this.num > o.getNum()) {
				return 1;
			}else if(this.num > o.getNum()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
}
