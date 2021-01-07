package math;

import java.io.*;

class B3053 { //3053 �ýñ�����
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
	
	//�ý� �������� �� ����� ���������̴�.
	public double getMinkowski(double num) {
		return (2 * num) * (2 * num) * 0.5;
	}
}
