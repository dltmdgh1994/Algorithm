package Programmers;

import java.util.*;

public class P17686 { // 2 파일명 정렬
	
	public static void main(String[] args) {
		
		P17686 p = new P17686();
		
		String[] s = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		String[] ans = p.solution(s);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	// 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬
	// HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬
	// 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지
	public String[] solution(String[] files) {
	    String[] answer = new String[files.length];
	    
	    ArrayList<File> fileList = new ArrayList<>();
	    for(int i = 0; i < files.length; i++) {
	    	fileList.add(new File(files[i]));
	    }
	    
	    Collections.sort(fileList, new FileNameComparator());
	    
	    for(int i = 0; i < files.length; i++) {
	    	answer[i] = fileList.get(i).getName();
	    }
	    
	    return answer;
	}
}

class File{
	
	private String name;
	private String head;
	private int num;
	
	public File(String name) {
		this.name = name;
		
		int idx = 0;
		for(int i = 0; i < name.length(); i++) {
			String s = name.substring(i,i+1);
			
			if(s.matches("[0-9]")) {
				idx = i;
				break;
			}
		}
		
		this.head = name.substring(0,idx).toLowerCase();
		
		int idx2 = name.length();
		for(int i = idx+1; i < name.length(); i++) {
			String s = name.substring(i,i+1);
			
			if(s.matches("[^0-9]")) {
				idx2 = i;
				break;
			}
		}
		
		this.num = Integer.parseInt(name.substring(idx,idx2));
	}

	public String getName() {
		return this.name;
	}

	public String getHead() {
		return this.head;
	}

	public int getNum() {
		return this.num;
	}
}

class FileNameComparator implements Comparator<File> {
	@Override
	public int compare(File o1, File o2) {
		// TODO Auto-generated method stub
		if(o1.getHead().compareTo(o2.getHead()) < 0) {
			return -1;
		}else if(o1.getHead().compareTo(o2.getHead()) == 0) {
			if(o1.getNum() < o2.getNum()) {
				return -1;
			}else if(o1.getNum() == o2.getNum()) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}
