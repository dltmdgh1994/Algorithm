package etc;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DQ_23 { // 국영수

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_23 dq = new DQ_23();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			List<Student> arr = new ArrayList<>();
			
			int n = Integer.parseInt(br.readLine());
			String[] s;
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				arr.add(new Student(s[0], Integer.parseInt(s[1]),
						Integer.parseInt(s[2]), Integer.parseInt(s[3])));
			}
			
			// Comparator를 이용한 정렬
			// arr.sort(null);
			
			// Lambda를 이용한 정렬 => Java8 도입
			arr = arr.stream().sorted(Comparator.comparing(Student::getKorean).reversed()
					.thenComparing(Comparator.comparing(Student::getEnglish))
					.thenComparing(Comparator.comparing(Student::getMath).reversed())
					.thenComparing(Comparator.comparing(Student::getName)))
					.collect(Collectors.toList());
			
			for(int i = 0; i < n; i++) {
				bw.write(arr.get(i).name);
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

class Student implements Comparable<Student>{
	String name;
	int korean;
	int math;
	int english;
	
	public Student(String name, int korean, int english, int math) {

		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}

	public String getName() {
		return name;
	}

	public int getKorean() {
		return korean;
	}

	public int getMath() {
		return math;
	}

	public int getEnglish() {
		return english;
	}

	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		if(this.korean > s.korean) {
			return -1;
		}else if(this.korean < s.korean) {
			return 1;
		}else {
			if(this.english > s.english) {
				return 1;
			}else if(this.english < s.english) {
				return -1;
			}else {
				if(this.math > s.math) {
					return -1;
				}else if(this.math < s.math) {
					return 1;
				}else {
					if(this.name.compareTo(s.name) > 0) {
						return 1;
					}else if(this.name.compareTo(s.name) < 0) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		}
	}
}
