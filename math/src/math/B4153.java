package math;

import java.io.*;

class B4153 { //4153 Á÷°¢»ï°¢Çü
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[]; double a; double b; double c;
			
			while(true) {
				 s = br.readLine().split(" ");
				 a = Math.pow(Double.parseDouble(s[0]), 2);
				 b = Math.pow(Double.parseDouble(s[1]), 2);
				 c = Math.pow(Double.parseDouble(s[2]), 2);
				 
				 int index = findMax(a, b, c);
				 
				 if(a == 0 && b == 0 && c == 0) {
					 break;
				 }
				 
				 if(index == 0) {
					 if(b + c == a) {
						 bw.write("right");
					 }else {
						 bw.write("wrong");
					 }
				 }else if(index == 1) {
					 if(a + c == b) {
						 bw.write("right");
					 }else {
						 bw.write("wrong");
					 }
				 }else {
					 if(a + b == c) {
						 bw.write("right");
					 }else {
						 bw.write("wrong");
					 }
				 }
				 bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public int findMax(double a, double b, double c) {
		double[] arr = new double[3];
		
		arr[0] = a; arr[1] = b; arr[2] = c;
		
		double max =  -1; int index = -1;
		
		for(int i = 0; i < 3; i++) {
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		
		return index;
	}
}
