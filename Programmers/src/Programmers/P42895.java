package Programmers;

public class P42895 { // 3 N으로 표현

	public static void main(String[] args) {
		
		P42895 p = new P42895();
		
		System.out.println(p.solution(8, 53));
	}
	
	int[] num;

	public int solution(int N, int number) {
        int answer = 0;
        
        num = new int[32000];
        
        String s = Integer.toString(N);
        String[] formula = {s};
        calc(formula, s, 2);
        
        if(num[number-1] == 0) {
        	answer = -1;
        }else {
        	answer = num[number-1];
        }
        
        return answer;
    }
	
	private void calc(String[] formula, String s, int n) {
		
		if(n == 9) {
			return;
		}
		
		String[] temp = new String[formula.length*5];
		int k = 0;
		
		for(int i = 0; i < formula.length; i++) {
			temp[k++] = (formula[i]+"+"+s);
		}
		
		for(int i = 0; i < formula.length; i++) {
			temp[k++] = (formula[i]+"-"+s);
		}

		for(int i = 0; i < formula.length; i++) {
			temp[k++] = (formula[i]+"*"+s);
		}

		for(int i = 0; i < formula.length; i++) {
			temp[k++] = (formula[i]+"/"+s);
		}
		
		for(int i = 0; i < formula.length; i++) {
			temp[k++] = (formula[i]+s);
		}
		
		for(int i = 0; i < temp.length; i++) {
			formulaToInt(temp[i], n);
		}
		
		calc(temp, s, n+1);
	}
	
	private void formulaToInt(String formula, int n) {
		
		String[] number = formula.split("[-+/*]");
		String[] cal = formula.split("[0-9]+");
		
		if(number.length == 1) {
			
			int result = Integer.parseInt(number[0]);
			
			if(result > 0 && result <= 32000) {
				
				if(num[result-1] == 0) {
					num[result-1] = n;
				}else if(num[result-1] > n) {
					num[result-1] = n;
				}
			}
			
			return;
		}
		
		boolean[] visited = new boolean[cal.length];
		
		permutation(number, cal, visited, 0, n, 0);
	}
	
	private void permutation(String[] number, String[] cal, boolean[] visited, int depth, int n, int result) {
		
		if(depth == cal.length-1) {
			
			if(result > 0 && result <= 32000) {
				
				if(num[result-1] == 0) {
					num[result-1] = n;
				}else if(num[result-1] > n) {
					num[result-1] = n;
				}
			}
			
			return;
		}
		
		for(int i = 1; i < cal.length; i++) {
			if (visited[i] != true) {
				
				if(depth == 0) {
					result = Integer.parseInt(number[i-1]);
				}
				
	            visited[i] = true;
	            
	            if(cal[i].equals("+")) {
	            	result += Integer.parseInt(number[i]);
	            }else if(cal[i].equals("-")) {
	            	result -= Integer.parseInt(number[i]);
	            }else if(cal[i].equals("*")) {
	            	result *= Integer.parseInt(number[i]);
	            }else {
	            	
	            	if(Integer.parseInt(number[i]) != 0) {
	            		result /= Integer.parseInt(number[i]);
	            	}else {
	            		return;
	            	}
	            }
	            
	            permutation(number, cal, visited, depth+1, n, result);
	            
	            visited[i] = false;
	        }
		}
	}
}
