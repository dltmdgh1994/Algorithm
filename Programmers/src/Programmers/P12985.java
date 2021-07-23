package Programmers;

public class P12985 { // 예상 대진표
	
	public static void main(String[] args) {
		P12985 p = new P12985();
		
		System.out.println(p.solution(8, 4, 7));
	}

	public int solution(int n, int a, int b){
        int answer = 0;

        while(!check(a, b)) {
        	
        	a = (int)Math.ceil((double)a/2);
        	b = (int)Math.ceil((double)b/2);
        	
        	answer++;
        }

        return ++answer;
    }
	
	private boolean check(int a, int b) {
		if(a > b) {
			if(a%2 == 0 && a-b == 1) {
				return true;
			}else {
				return false;
			}
		}else {
			if(b%2 == 0 && b-a == 1) {
				return true;
			}else {
				return false;
			}
		}
	}
}
