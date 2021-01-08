package math;

import java.io.*;

class B1002 { //1002 �ͷ�
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String s[];
			int x1, y1, r1, x2, y2, r2;
			double c;
			for(int i = 0; i < num; i++) {
				s = br.readLine().split(" ");
				x1 = Integer.parseInt(s[0]);
				y1 = Integer.parseInt(s[1]);
				r1 = Integer.parseInt(s[2]);
				x2 = Integer.parseInt(s[3]);
				y2 = Integer.parseInt(s[4]);
				r2 = Integer.parseInt(s[5]);
				
				//�� �� ������ �Ÿ� (x1, y1), (x2, y2)
				c = Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2), 0.5);
				
				if(c == 0) { //�߽��� ���� ���
					if(r1 == r2) {
						bw.write("-1");
						bw.newLine();
					}else {
						bw.write("0");
						bw.newLine();
					}
				}else { //�߽��� �ٸ� ���
					if(r1 + r2 == c) { //����
						bw.write("1");
						bw.newLine();
					}else if(Math.abs(r1 - r2) == c) { //����
						bw.write("1");
						bw.newLine();
					}else if(Math.abs(r1 - r2) > c) { //ū �� ���ο� ���� ��
						bw.write("0");
						bw.newLine();
					}else if(r1 + r2 < c) { //�ٱ��� ������ �ִ�.
						bw.write("0");
						bw.newLine();
					}else {
						bw.write("2");
						bw.newLine();
					}
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
