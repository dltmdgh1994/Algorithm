package Bfor;

import java.util.Scanner;

class B2739 {
	public void sol() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 1; i  < 10; i++) {
			System.out.println(num + " * " + i + " = "+(num*i));
		}
		
		sc.close();
	}
}
