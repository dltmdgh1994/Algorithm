package Bif;

import java.util.Scanner;

class B14681 {
	public void sol() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a>0 && b>0) {
			System.out.println(1);
		}
		else if (a<0 && b>0) {
			System.out.println(2);
		}
		else if(a<0 && b<0) {
			System.out.println(3);
		}
		else {
			System.out.println(4);
		}
		
		sc.close();
	}
}
