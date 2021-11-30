package Programmers;

import java.util.*;

public class P42892 { // 3 길 찾기 게임

	public static void main(String[] args) {
		
		P42892 p = new P42892();
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		p.solution(nodeinfo);
	}
	
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        
        int[][] newNodeInfo = new int[nodeinfo.length][3];
        for(int i = 0; i < nodeinfo.length; i++) {
        	newNodeInfo[i][0] = nodeinfo[i][0];
        	newNodeInfo[i][1] = nodeinfo[i][1];
        	newNodeInfo[i][2] = i+1;
        }
        
        // y 좌표를 내림차순, x 좌표를 오름차순으로 정렬
        Arrays.sort(newNodeInfo, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] > o2[1]) {
					return -1;
				}else if(o1[1] < o2[1]) {
					return 1;
				}else {
					if(o1[0] < o2[0]) {
						return -1;
					}else if(o1[0] > o2[0]) {
						return 1;
					}else {
						return 0;
					}
				}
			}
        	
		});
        
        Tree tree = new Tree();
        
        for(int i = 0; i < newNodeInfo.length; i++) {
        	int[] data = newNodeInfo[i];
        	
        	tree.insertNode(data);
        }
        
        tree.preorderTree(tree.rootNode, 0);
        answer[0] = new int[tree.preorderResult.size()];
        for(int i = 0; i < tree.preorderResult.size(); i++) {
        	answer[0][i] = tree.preorderResult.get(i);
        }
        
        tree.postorderTree(tree.rootNode, 0);
        answer[1] = new int[tree.postorderResult.size()];
        for(int i = 0; i < tree.postorderResult.size(); i++) {
        	answer[1][i] = tree.postorderResult.get(i);
        }
        
        return answer;
    }
}

class Node {
    int[] data; // x,y,value
    Node leftChild;
    Node rightChild;

    public Node(int[] data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class Tree{
	Node rootNode = null;
	ArrayList<Integer> preorderResult = new ArrayList<>(); // 전위순회 결과
	ArrayList<Integer> postorderResult = new ArrayList<>(); // 후위순회 결과
	
	public void insertNode(int[] data) {
		
		if(rootNode == null) {
			rootNode = new Node(data);
		}else {
			Node head = rootNode;
			Node currentNode;
			
			while(true) {
				currentNode = head;
				
				if(head.data[0] > data[0]) {
					head = head.leftChild;
					
					if(head == null) {
						currentNode.leftChild = new Node(data);
						break;
					}
				}else {
					head = head.rightChild;
					
					if(head == null) {
						currentNode.rightChild = new Node(data);
						break;
					}
				}
			}
		}
	}
	
	// 전위 순회
    public void preorderTree(Node root, int depth) {
        if (root != null) {
        	preorderResult.add(root.data[2]);
            preorderTree(root.leftChild, depth + 1);
            preorderTree(root.rightChild, depth + 1);
        }
    }
    
    // 후위 순회
    public void postorderTree(Node root, int depth) {
        if (root != null) {
            postorderTree(root.leftChild, depth + 1);
            postorderTree(root.rightChild, depth + 1);
            postorderResult.add(root.data[2]);
        }
    }
}
