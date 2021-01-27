package sorting;

import java.io.*;

class B11651 { // 좌표 정렬하기 2
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Point2[] p = new Point2[n];
			
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				p[i] = new Point2(x, y);
			}
			
			sort s = new sort();
			s.mergeSort(p, 0, n-1, 0);
			
			for(int i = 0; i < n; i++) {
				bw.write(p[i].printPoint());
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

// Point 객체끼리 비교를 위해 Comparable을 상속
class Point2 implements Comparable<Point2>{
	private int x;
	private int y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String printPoint() {
		return Integer.toString(x) + " " + Integer.toString(y);
	}

	@Override
	public int compareTo(Point2 o) {
		// TODO Auto-generated method stub
		if(y > o.y) {
			return 1;
		}
		else if(y == o.y) {
			if(x > o.x) {
				return 1;
			}
			else if(x == o.x) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
}

