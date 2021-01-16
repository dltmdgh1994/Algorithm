package BruteForce;

import java.io.*;

class B7568 { // µ¢Ä¡
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Person arr[] = new Person[n];
			int rank[] = new int[n];
			String s[];
			
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				arr[i] = new Person(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			}
			
			int cnt;
			for(int i = 0; i < n; i++) {
				cnt = 1;
				for(int j = 0; j < n; j++) {
					if((arr[i].getH() < arr[j].getH()) && (arr[i].getW() < arr[j].getW())) {
						cnt++;
					}
				}
				rank[i] = cnt;
			}
			
			for(int i = 0; i < n; i++) {
				bw.write(Integer.toString(rank[i]));
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

class Person{
	private int w;
	private int h;
	
	public Person(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
}


