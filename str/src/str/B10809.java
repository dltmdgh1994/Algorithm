package str;

import java.io.*;

class B10809 { //10809 ¾ËÆÄºª Ã£±â
	public void sol() { 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int alphabet[] = new int[26];
			
			for(int i = 0; i < alphabet.length; i++) {
				alphabet[i] = -1;
			}
			
			int num;
			for(int i = 0; i < s.length(); i++) {
				num = ((int)s.charAt(i)) - 97;
				if(alphabet[num] == -1) {
					alphabet[num] = i;
				}
			}
			
			for(int i = 0; i < alphabet.length; i++) {
				bw.write(Integer.toString(alphabet[i]) + " ");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
