package Programmers;

import java.util.*;

public class P42861 { // 3 �� �����ϱ�

	public static void main(String[] args) {
		
		P42861 p = new P42861();
		
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(p.solution(4, costs));
	}
	
	// ũ�罺Į(Kruskal) �˰���
	// ���� ���� ������� ��� ��带 �����ϱ� ���� �˰���
	// �ּ� ��� ���� Ʈ���� ����
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // �Ǽ� ����� �������� ������������ ����
        // ���ٽ����� �����ϰ� ǥ��
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
//      Arrays.sort(costs, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				if(o1[2] > o2[2]) {
//					return 1;
//				}else if(o1[2] < o2[2]) {
//					return -1;
//				}else {
//					return 0;
//				}
//			}
//		});

        int[] cycle = new int[n];
        for(int i = 0; i < n; i++) {
        	cycle[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
        	int i1 = costs[i][0];
        	int i2 = costs[i][1];
        	int cost = costs[i][2];
        	
        	// Union-Find(������ ã��)
            // �� ��尡 ���� �׷������� �Ǻ�
        	if(cycle[i1] != cycle[i2]) {
        		if(i1 < i2) {
        			// ���� �׷����� ��ĥ ���� ���� �������� ����
        			int tmp = cycle[i2];
        			cycle[i2] = cycle[i1];
        			for(int j = 0; j < n; j++) {
        				if(cycle[j] == tmp) {
        					cycle[j] = cycle[i2];
        				}
        			}
        		}else if(i1 > i2) {
        			int tmp = cycle[i1];
        			cycle[i1] = cycle[i2];
        			for(int j = 0; j < n; j++) {
        				if(cycle[j] == tmp) {
        					cycle[j] = cycle[i1];
        				}
        			}
        		}
        		
        		answer += cost;
        	}
        	
        	
        }
        
        return answer;
    }
    
    private int find(int[] island, int x)
    {
        if(island[x]== x)
            return x;
        return find(island, island[x]);
    }
    
    private void unite(int[] island, int x, int y)
    {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b;
    }
}
