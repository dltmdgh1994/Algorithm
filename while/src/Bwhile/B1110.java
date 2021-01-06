package Bwhile;
import java.io.*;

class B1110 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int ans = Integer.parseInt(br.readLine());
			int front, back, last;
			int num = ans;
			int cnt = 0;
			do {
				back = num%10;
				front = num/10;
				last = (front + back)%10;
				num = (back*10) + last;
				cnt++;
			}while(num != ans);
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
