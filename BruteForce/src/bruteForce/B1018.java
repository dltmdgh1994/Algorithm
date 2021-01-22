package bruteForce;

import java.io.*;

class B1018 { // ü���� �ٽ� ĥ�ϱ�
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int h = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			
			int cb[][] = new int[h][w];
			String str;
			for(int i = 0; i < h; i++ ) { //ü���� �б�
				str = br.readLine();
				for(int j = 0; j < w; j++) {
					if(str.substring(j,j+1).equals("B")) {
						cb[i][j] = 0;
					}else {
						cb[i][j] = 1;
					}
				}
			}			
			
			int cnt; int min = 64;
			int start;
			for(int i = 0; i <= h-8; i++) { // ������ ����
				for(int j = 0; j <= w-8; j++) {
					for(int l = 0; l < 2; l++) { // ������ 0,1�� �ѹ��� �˻�
						cnt = 0;
						start = l;
						for(int k = i; k < i+8; k++) {
							start = changeNum(start);
							for (int m = j; m < j+8; m++) { //ü���� ���� �˻�
								start = changeNum(start);
								if(cb[k][m] != start) {
									cnt++;
								}
							}
						}
						
						if(cnt < min) {
							min = cnt;
						}
					}
				}
			}
		
			bw.write(Integer.toString(min));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int changeNum(int n) {
		if(n == 0) {
			return 1;
		}else {
			return 0;
		}
	}
}
