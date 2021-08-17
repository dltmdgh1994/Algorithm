package Programmers;

public class P12980 { // 2 점프와 순간 이동

	public static void main(String[] args) {
		
		P12980 p = new P12980();
		
		System.out.println(p.solution(5000));
	}
	
	public int solution(int n) {
        int ans = 0;

        while(n != 0) {
        	
        	if(n%2 == 0) {
        		n /= 2;
        	}else {
        		ans++;
        		n -= 1;
        	}
        }
        return ans;
    }
}
