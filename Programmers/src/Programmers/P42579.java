package Programmers;

import java.util.*;

public class P42579 { // 3 베스트앨범
	
	public static void main(String[] args) {
		
		P42579 p = new P42579();
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] ans = p.solution(genres, plays);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
//	속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//	장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//	장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
	
	public int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> genresAllCnt = new HashMap<>();
		HashMap<String, ArrayList<int[]>> songInfo = new HashMap<>();
		
		for(int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			
			if(genresAllCnt.containsKey(genre)) {
				int sum = genresAllCnt.get(genre) + play;
				genresAllCnt.put(genre, sum);
			}else {
				genresAllCnt.put(genre, play);
			}
			
			if(songInfo.containsKey(genre)) {
				songInfo.get(genre).add(new int[] {i, play});
			}else {
				songInfo.put(genre, new ArrayList<int[]>());
				songInfo.get(genre).add(new int[] {i, play});
			}
		}
		
		int[] answer = new int[genresAllCnt.keySet().size()*2];
		
		// 속한 노래가 많이 재생된 장르를 내림차순 정렬
		ArrayList<String> keySetList = new ArrayList<>(genresAllCnt.keySet());
		Collections.sort(keySetList, (o1, o2) 
				-> genresAllCnt.get(o2).compareTo(genresAllCnt.get(o1)));
		
		int k = 0;
		for(String key : songInfo.keySet()) {
			ArrayList<int[]> arr = songInfo.get(key);
			
			Collections.sort(arr, (o1, o2) -> compareArr(o1, o2));
			
			answer[k++] = arr.get(0)[0];
			answer[k++] = arr.get(1)[0];
		}
		
        return answer;
    }
	
	private int compareArr(int[] o1, int[] o2) {
		if(o2[1] > o1[1]) {
			return 1;
		}else if(o2[1] == o1[1]) {
			if(o2[0] < o1[0]) {
				return 1;
			}else if(o2[0] == o1[0]) {
				return 0;
			}else {
				return -1;
			}
		}else {
			return -1;
		}
	}
}
