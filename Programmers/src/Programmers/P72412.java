package Programmers;

import java.util.*;

public class P72412 { // 순위 검색

	public static void main(String[] args) {
		P72412 p = new P72412();
		
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		int[] ans = p.solution(info, query);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}
	
	// 완전 탐색의 경우 효율성 테스트에서 시간 초과
	// 가능한 경우(4*3*3*3)를 map에 미리 넣고 점수만 ArrayList에 넣는다.
	// 그 후 쿼리에 만족하는 맵을 불러와 binary search
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        String lang[] = {"cpp","java","python","-"};
        String job[] = {"backend", "frontend","-"};
        String career[] = {"junior","senior","-"};
        String food[] = {"chicken","pizza","-"};

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < lang.length; i++) {
        	for(int j = 0; j < job.length; j++) {
        		for(int k = 0; k < career.length; k++) {
        			for(int l = 0; l < food.length; l++) {
        				String key = lang[i].substring(0,1) + job[j].substring(0,1) +
        						career[k].substring(0,1) + food[l].substring(0,1);
        				map.put(key, new ArrayList<Integer>());
        			}
        		}
        	}
        }
        
        // 가능한 모든 경우에 미리 점수 값을 넣고 탐색한다. => 시간 초과 방지
        for(int i = 0; i < info.length; i++) {
        	String[] s = info[i].split(" ");
        	String s1 = s[0].substring(0,1);
        	String s2 = s[1].substring(0,1);
        	String s3 = s[2].substring(0,1);
        	String s4 = s[3].substring(0,1);
        	int val = Integer.parseInt(s[4]);
        	
        	String key = s1 + s2 + s3 + s4;
        	map.get(key).add(val);
        	
        	key = "-" + s2 + s3 + s4;
        	map.get(key).add(val);
        	
        	key = s1 + "-" + s3 + s4;
        	map.get(key).add(val);
        	
        	key = s1 + s2 + "-" + s4;
        	map.get(key).add(val);
        	
        	key = s1 + s2 + s3 + "-";
        	map.get(key).add(val);
        	
        	key = "-" + "-" + s3 + s4;
        	map.get(key).add(val);
        	
        	key = "-" + s2 + "-" + s4;
        	map.get(key).add(val);
        	
        	key = "-" + s2 + s3 + "-";
        	map.get(key).add(val);
        	
        	key = s1 + "-" + "-" + s4;
        	map.get(key).add(val);
        	
        	key = s1 + "-" + s3 + "-";
        	map.get(key).add(val);
        	
        	key = s1 + s2 + "-" + "-";
        	map.get(key).add(val);
        	
        	key = "-" + "-" + "-" + s4;
        	map.get(key).add(val);
        	
        	key = "-" + "-" + s3 + "-";
        	map.get(key).add(val);
        	
        	key = "-" + s2 + "-" + "-";
        	map.get(key).add(val);
        	
        	key = s1 + "-" + "-" + "-";
        	map.get(key).add(val);
        	
        	key = "-" + "-" + "-" + "-";
        	map.get(key).add(val);
        }
        
        // 해쉬맵의 모든 ArrayList를 오름차순 정렬
        // binary search 하기 전에 정렬이 필요
        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
        	Collections.sort(entry.getValue());
        }
        
        for(int i = 0; i < query.length; i++) {
        	String[] q = query[i].split(" ");
        	
        	String key = q[0].substring(0,1) + q[2].substring(0,1) +
        			q[4].substring(0,1) + q[6].substring(0,1);
        	
        	int limit = Integer.parseInt(q[7]);
        	
        	ArrayList<Integer> target = map.get(key);

        	// binary search => 찾으면 index 리턴
        	//               => 못 찾으면, -들어갈 위치(인덱스x) 리턴
        	// binary search 안하고 완전 탐색하면 시간초과
        	int idx = Collections.binarySearch(target, limit);
        	int ans = 0;

        	if(idx >= 0) { // 찾은 경우
        		// 동일한 값이 있을 경우 최소 인덱스를 리턴하지 않아서 찾아야 한다.
        		for(int a=idx-1; a>=0; a--) {
        			if(target.get(idx) - target.get(a) > 0) break;
        			else idx = a;
        			}
        		
        		ans = idx;
        	}else { // 못 찾은 경우
        		ans = -(idx+1);
        	}
        	
        	answer[i] = target.size() - ans;
        }
        
//        Dev[] dev = new Dev[info.length];
//        for(int i = 0; i < info.length; i++) {
//        	String[] s = info[i].split(" ");
//        	
//        	dev[i] = new Dev(s[0],s[1],s[2],s[3],Integer.parseInt(s[4]));
//        }
//        
//        for(int i = 0; i < query.length; i++) {
//        	String[] q = query[i].split(" ");
//        	
//        	String lang = q[0];
//            String job = q[2];
//            String food = q[4];
//            String career = q[6];
//            int score = Integer.parseInt(q[7]);
//            
//            int cnt = 0;
//            for(int j = 0; j < dev.length; j++) {
//            	if(dev[j].check(lang, job, food, career, score)) {
//            		cnt++;
//            	}
//            }
//            
//            answer[i] = cnt;
//        }

        return answer;
    }
}

//class Dev{
//	
//    String lang;
//    String job;
//    String food;
//    String career;
//    int score;
//    
//	public String getCareer() {
//		return career;
//	}
//
//	public void setCareer(String career) {
//		this.career = career;
//	}
//
//	public Dev(String lang, String job, String food, String career, int score) {
//		super();
//		this.lang = lang;
//		this.job = job;
//		this.food = food;
//		this.career = career;
//		this.score = score;
//	}
//
//	public boolean check(String lang, String job, String food, String career, int score) {
//		if((lang.equals("-") || this.lang.equals(lang)) && 
//				(job.equals("-") || this.job.equals(job)) &&
//				(food.equals("-") || this.food.equals(food)) && 
//				(career.equals("-") || this.career.equals(career)) &&
//				this.score >= score){
//			return true;
//		}else {
//			return false;
//		}
//	}
//}
