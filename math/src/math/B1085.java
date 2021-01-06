package math;

import java.io.*;
import java.util.ArrayList;

class B1085 { //1085 직사각형에서 탈출
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			ArrayList<Integer> w = new ArrayList<Integer>();
			ArrayList<Integer> h = new ArrayList<Integer>();
			String s[]; int x; int y;
			for(int i = 0; i < 3; i++ ) {
				s = br.readLine().split(" ");
				x = Integer.parseInt(s[0]);
				y = Integer.parseInt(s[1]);
				w.add(x);
				h.add(y);
			}
			int a = 0; int b = 0;
			int cnt;
			for(int i = 0; i < w.size(); i++) {
				cnt = 0;
				for(int j = 0; j < w.size(); j++) {
					// w.get(i) == w.get(j)는 안된다. int형이 아니라 그런듯(Integer라)
					if(w.get(i).equals(w.get(j))) {
						cnt++;
					}
				}
				if(cnt%2 == 1) {
					a = w.get(i);
				}
			}
			
			for(int i = 0; i < h.size(); i++) {
				cnt = 0;
				for(int j = 0; j < h.size(); j++) {
					if(h.get(i).equals(h.get(j))) {
						cnt++;
					}
				}
				if(cnt%2 == 1) {
					b = h.get(i);
				}
			}
			
			bw.write(Integer.toString(a)+" "+Integer.toString(b));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
