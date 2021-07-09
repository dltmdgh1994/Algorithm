package Programmers;

public class P62048 { // ������ �簢��
	
	public static void main(String[] args) {
		P62048 p = new P62048();
		
		long ans = p.solution(6, 12);
		
		System.out.println(ans);
	}
	
	public long solution(long w, long h) {
        
        long mul = 1;
        
        if(h >= w){
//            for(long i = w; i >= 1; i--){
//                if(w%i == 0 && h%i == 0){
//                    mul = i;
//                    break;
//                }
//            }
        	
        	mul = GCD(h, w);
        }else{
//            for(long i = h; i >= 1; i--){
//                if(w%i == 0 && h%i == 0){
//                    mul = i;
//                    break;
//                }
//            }
        	mul = GCD(w, h);
        }
        
        w /= mul;
        h /= mul;
 
        long cnt = 0;
        
        for(long i = 0; i < w; i++){
            // ó���� (h/w) * i �� �����ߴ��� Ʋ�ȴ�. => �Ҽ������� ���� ��� ����Ȯ
            cnt += (Math.ceil((double)h*(i+1)/w) - Math.floor((double)h*(i)/w));
        }
        
        long answer = w*h*mul*mul - cnt*mul;
        
        return answer;
    }
	
	// �ִ����� => ��Ŭ���� ȣ����(�� ���� ���� ������ ���� ������ ���ϴ� ���� ��� ���)
	private long GCD(long a, long b){ 
		if (a%b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}
