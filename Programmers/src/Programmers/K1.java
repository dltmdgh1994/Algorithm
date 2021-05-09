package Programmers;

public class K1 {
	public static void main(String[] args) {
		K1 p = new K1();
		System.out.println(p.solution("one4seveneight"));
	}
	
	public int solution(String s) {
        String answer = "";
        
        int len = s.length();
        String save = "";
        for(int i = 0; i < len; i++){
            String str = s.substring(i,i+1);
            
            if(str.equals("0")){
                answer += "0";
            }else if(str.equals("1")){
                answer += "1";
            }else if(str.equals("2")){
                answer += "2";
            }else if(str.equals("3")){
                answer += "3";
            }else if(str.equals("4")){
                answer += "4";
            }else if(str.equals("5")){
                answer += "5";
            }else if(str.equals("6")){
                answer += "6";
            }else if(str.equals("7")){
                answer += "7";
            }else if(str.equals("8")){
                answer += "8";
            }else if(str.equals("9")){
                answer += "9";
            }else{
                save += str;
                
                if(save.equals("zero")){
                    answer += "0";
                    save = "";
                }else if(save.equals("one")){
                    answer += "1";
                    save = "";
                }else if(save.equals("two")){
                    answer += "2";
                    save = "";
                }else if(save.equals("three")){
                    answer += "3";
                    save = "";
                }else if(save.equals("four")){
                    answer += "4";
                    save = "";
                }else if(save.equals("five")){
                    answer += "5";
                    save = "";
                }else if(save.equals("six")){
                    answer += "6";
                    save = "";
                }else if(save.equals("seven")){
                    answer += "7";
                    save = "";
                }else if(save.equals("eight")){
                    answer += "8";
                    save = "";
                }else if(save.equals("nine")){
                    answer += "9";
                    save = "";
                }
            }
        }
        
        int a = Integer.parseInt(answer);
        
        return a;
    }
}
