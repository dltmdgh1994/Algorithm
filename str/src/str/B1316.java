package str;

import java.io.*;
import java.util.HashSet;

class B1316 { //1316 그룹 단어 체커
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			HashSet<String> hashset = new HashSet<>(); //중복 숫자 확인
			
			int num = Integer.parseInt(br.readLine());
			String s = ""; String str = ""; int cnt = 0;
			String before = ""; boolean redu = false;
			for(int i = 0; i < num; i++) {
				s = br.readLine();
				for(int j = 0; j < s.length(); j++) {
					str = s.substring(j,j+1);
					if(str.equals(before)) {
						
					}else {
						if(hashset.contains(str)) {
							hashset.removeAll(hashset);
							before = ""; redu = true;
							break;
						}else {
							hashset.add(str);
						}
					}
					before = str;
				}
				if(!redu) {
					cnt++;
				}
				hashset.removeAll(hashset);
				before = ""; redu = false;
			}
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
