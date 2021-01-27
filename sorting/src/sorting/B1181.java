package sorting;

import java.io.*;
import java.util.*;

class B1181 { // 단어 정렬
	// 길이가 짧은 것부터
	// 길이가 같으면 사전 순으로
	// 중복 제거
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Word[] w = new Word[n];
			
			for(int i =0; i < n; i++) {
				w[i] = new Word(br.readLine());
			}
			
			sort s = new sort();
			s.mergeSort(w, 0, n-1, 0);
			
			//중복제거
			ArrayList<String> arr = new ArrayList<>();
			for(int i =0; i < n; i++) {
				String word = w[i].getWord();
				if(!arr.contains(word)) {
					arr.add(word);
				}
			}
			
			for(int i =0; i < arr.size(); i++) {
				bw.write(arr.get(i));
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

class Word implements Comparable<Word>{
	String word;
	
	public Word(String str) {
		this.word = str;
	}
	
	public String getWord() {
		return word;
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		if(word.length() > o.word.length()) {
			return 1;
		}
		else if(word.length() == o.word.length()) {
			if(word.compareTo(o.word) > 0) {
				return 1;
			}
			else if(word.compareTo(o.word) == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
}
