package Bif;

import java.util.Scanner;

class B9498 {
	public void sol() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a >= 90) {
			System.out.println("A");
		}
		else if(a >= 80) {
			System.out.println("B");
		}
		else if(a >= 70) {
			System.out.println("C");
		}
		else if(a >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
		
		sc.close();
	}
}
