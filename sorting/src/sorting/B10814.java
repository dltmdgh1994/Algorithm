package sorting;

import java.io.*;

class B10814 { // 나이순 정렬
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Member[] m = new Member[n];
			
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int age = Integer.parseInt(s[0]);
				String name = s[1];
				m[i] = new Member(age, i, name);
			}
			
			sort s = new sort();
			s.mergeSort(m, 0, n-1, 0);
			
			for(int i = 0; i < n; i++) {
				bw.write(m[i].printMember());
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

class Member implements Comparable<Member>{
	int age;
	int idx;
	String name;
	
	public Member(int age, int idx, String name) {
		this.age = age;
		this.idx = idx;
		this.name = name;
	}
	
	public String printMember() {
		return Integer.toString(age) + " " + name;
	}

	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		if(age > o.age) {
			return 1;
		}
		else if(age == o.age) {
			if(idx > o.idx) {
				return 1;
			}
			else if(idx == o.idx) {
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