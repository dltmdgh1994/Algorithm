package math;

import java.io.*;

class B2775 { //2775 ∫Œ≥‡»∏¿Â¿Ã µ…≈◊æﬂ
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int arr[][] = new int[15][14]; int sum = 0;
			for(int i = 0; i < arr[0].length; i++) { //0√˛
				arr[0][i] = i+1;
			}
			for(int i = 1; i < arr.length; i++) {
				sum = 0;
				for(int j = 0; j < arr[i].length; j++) {
					sum += arr[i-1][j];
					arr[i][j] = sum;
				}
			}
			
			int num = Integer.parseInt(br.readLine()); int a; int b;
			for(int i = 0; i < num; i++) {
				a = Integer.parseInt(br.readLine());
				b = Integer.parseInt(br.readLine());
				bw.write(Integer.toString(arr[a][b-1]));
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
