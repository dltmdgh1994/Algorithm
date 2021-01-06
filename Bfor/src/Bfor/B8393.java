package Bfor;

import java.util.Scanner;

class B8393 {
	public void sol() {
		Scanner sc = new
		Scanner(System.in); int num = sc.nextInt();

		int sum = 0; for(int i = 1; i <= num; i++) { sum += i; }
		System.out.println(sum);
		 
		sc.close();
	}
}
