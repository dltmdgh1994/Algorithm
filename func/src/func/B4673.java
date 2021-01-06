package func;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

class B4673 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			HashSet<Integer> hashset = new HashSet<>(); //�����ѹ� �ƴ� ��
			ArrayList<Integer> arr = new ArrayList<>(); // �����ѹ��� ��
			int n;
			
			for(int i = 1; i <= 10000; i++) {
				if(!hashset.contains(i)) {
					arr.add(i);
				}
				
				n = self(i);
				if(n <= 10000) {
					hashset.add(n);
				}
			}
			
			for(int i = 0; i < arr.size(); i++) {
				bw.write(Integer.toString(arr.get(i)));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public int self(int num) {
		int len = (int)(Math.log10(num)+1); //num�� �ڸ���
		int z; int ans = num;
		for(int i = len-1; i >= 0; i--) {
			z = (int)Math.pow(10, i); //�ڹٴ� ^ ��� Math.pow(��,����)
			ans += (num / z);
			num = (num % z);
		}
		return ans;
	}
}
