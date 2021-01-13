package math;

import java.io.*;

class B11653 {  // ���μ�����
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			//� N�� �� ���̻� ����(�μ�)���� ��Ÿ�� �� ���� �� �μ� �� �� �� �̻���
			//�ݵ�� ��N���� �۰ų� ���ٴ� ��
			for(int i = 2; i <= Math.pow(num, 0.5); i++) {
				while((num % i) == 0) {
					bw.write(Integer.toString(i));
					bw.newLine();
					num /= i;
				}
			}
			
			//for�ݺ����� �����ϰ� N�� 1�� �ƴ϶�� N�� �Ҽ����� �μ��� ���� �ڸ�
			if(num != 1) {
				bw.write(Integer.toString(num));
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

/*class B11653 {  // ���μ�����
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			for(int i = 2; i <= num; i++) {
				while((num % i) == 0) {
					bw.write(Integer.toString(i));
					bw.newLine();
					num /= i;
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}*/