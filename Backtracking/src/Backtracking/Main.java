package Backtracking;

class Main {
	public static void main(String[] args) {
		B14888 b = new B14888();
		b.sol();
	}
}


//백트래킹
//제약 조건 만족 문제에서 해를 찾기 위해 후보군에 제약 조건을 점진적으로 체크하다가
//해당 후보군이 제약 조건을 만족하지 못하면 backtrack하고 다른 후보군으로 넘어가며 해를 찾는 방법

//모든 경우의 수를 상태공간트리로 표현
//각 후보군을 DFS 방식으로 확인 후
//Promising: 해당 루트가 조건에 맞는지 검사
//Pruning: 조건에 맞지 않으면 바로 다른 루트로 돌아섬