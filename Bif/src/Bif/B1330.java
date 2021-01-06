package Bif;

import java.util.Scanner;

class B1330 {
	public void sol() {
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		
		String[] str = s.split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		if(a == b) {
			System.out.println("==");
		}
		else if(a > b) {
			System.out.println(">");
		}
		else {
			System.out.println("<");
		}
		
		sc.close();
	}
}
