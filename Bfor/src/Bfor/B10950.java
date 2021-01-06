package Bfor;

import java.util.Scanner;

class B10950 {
	public void sol() {
		Scanner sc = new Scanner(System.in); int num = sc.nextInt(); sc.nextLine();

		for(int i = 0; i < num; i++) { 
			
				String s = sc.nextLine();
				String[] str = s.split(" "); 
				int a = Integer.parseInt(str[0]); 
				int b = Integer.parseInt(str[1]);
	
				System.out.println(a+b); 
		}
		sc.close();
	}
}
