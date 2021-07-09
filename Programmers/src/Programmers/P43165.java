package Programmers;

public class P43165 { // Å¸°Ù ³Ñ¹ö
	
	int cnt = 0;
	
	public static void main(String[] args) {
		P43165 p = new P43165();
		
	}
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
    
    private void dfs(int[] numbers, int target, int val, int pos){
        
        if(numbers.length == pos){
            if(target == val){
                cnt++;
            }
            return;
        }
        
        int minus = val - numbers[pos];
        dfs(numbers, target, minus, pos+1);
        
        int plus = val + numbers[pos];
        dfs(numbers, target, plus, pos+1);
    }
}
