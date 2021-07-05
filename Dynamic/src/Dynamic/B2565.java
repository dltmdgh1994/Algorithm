package Dynamic;

import java.io.*;

class B2565 { // ภüฑ๊มู
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {  
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int ans = 0;
			
			int num = Integer.parseInt(br.readLine());
			int[][] dp = new int[num][3];
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				dp[i][0] = Integer.parseInt(s[0]);
				dp[i][1] = Integer.parseInt(s[1]);
				dp[i][2] = 0;
			}
			
			
			
						
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

//          int n, cnt = 0, dp_max = 0; cin >> n;
//			int num[101], dp[101];
//			fill_n(num, 101, 0);
//			fill_n(dp, 101, 1);
//			for (int i = 1; i <= n; i++) {
//				int tmp;
//				cin >> tmp;
//				cin >> num[tmp];
//			}
//			
//			for (int i = 1; i <= 100; i++) {
//				int tmp = 1;
//				for (int j = 1; j < i; j++) {
//					if (num[i] != 0) {
//						if (num[i] > num[j] && num[j] != 0) 
//							tmp = max(tmp, dp[j] + 1);
//					}
//				}
//				dp[i] = tmp;
//				if (dp[i] > dp_max)
//					dp_max = dp[i];
//			}
//			cout << n - dp_max;
