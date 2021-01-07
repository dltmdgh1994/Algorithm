package math;

import java.io.*;

class B3053 { //3053 택시기하학
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			double num = Double.parseDouble(br.readLine());
			
			bw.write(Double.toString(getEuclidean(num)));
			bw.newLine();
			bw.write(Double.toString(getMinkowski(num)));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public double getEuclidean(double num) {
		return Math.PI * num * num;
	}
	
	//택시 기하학의 원 모양은 정마름모이다.
	public double getMinkowski(double num) {
		return (2 * num) * (2 * num) * 0.5;
	}
}
