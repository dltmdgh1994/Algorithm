package Programmers;

public class P60057 { // 문자열 압축
	public static void main(String[] args) {
		P60057 p = new P60057();
		System.out.println(p.solution("abcabcabcabcdededededede"));
	}
	
	public int solution(String s) {
        int len = s.length();
        int answer = len;

        for(int i = 1; i <= len/2; i++){
            int num = len/i;
            int surplus = len%i;
            String sp = "";

            String[] str = new String[num];
            int start = 0; int end = start + i;

            for(int j = 0; j < num; j++){
                str[j] = s.substring(start,end);
                start += i; end += i;
            }

            if(surplus != 0){
                sp = s.substring(start);
            }

            String result = "";
            int front = 1;
            for(int k = 1; k < num; k++){
                if(str[k-1].equals(str[k])) {
                    front++;
                    if(k == num - 1){
                        String number = Integer.toString(front);
                        result += (number + str[k-1]);
                    }
                }else if(front == 1){
                    result += str[k-1];
                    if(k == num - 1){
                        result += str[k];
                    }
                }else{
                    String number = Integer.toString(front);
                    result += (number + str[k-1]);
                    front = 1;
                    if(k == num - 1){
                        result += str[k];
                    }
                }
            }

            if(surplus != 0){
                result += sp;
            }

            int len2 = result.length();
            if(len2 < answer ){
                answer = len2;
            }
        }
        return answer;
    }
}
