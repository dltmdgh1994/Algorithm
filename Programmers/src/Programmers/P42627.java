package Programmers;

import java.util.*;

public class P42627 { // 3 디스크 컨트롤러
	
	public static void main(String[] args) {
		
		P42627 p = new P42627();
		
		int[][] jobs = {{0,5},{1,2},{5,5}};
		
		System.out.println(p.solution(jobs));
		
	}
	
	// Shortest Job First(SJF) 스케쥴링
	// 빨리 끝나는 것부터 처리 => 평균 대기 시간이 가장 적다.
	// 실제 CPU에서는 어떤 처리가 올지 모라서 미리 계산하기 힘들다.
	public int solution(int[][] jobs) {
        int answer = 0;
        
        int time = 0;
        ArrayList<Job> jobList = new ArrayList<>();
        ArrayList<Job> jobWaitList = new ArrayList<>();
        
        for(int i = 0; i < jobs.length; i++) {
        	jobList.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(jobList, new JobSTComparator());
        
        while(!jobList.isEmpty() || !jobWaitList.isEmpty()) {
        	
        	while(!jobList.isEmpty()) {
        		Job temp = jobList.get(0);
        		
        		if(temp.getStartTime() <= time) {
        			jobWaitList.add(temp);
        			jobList.remove(0);
        		}else {
        			break;
        		}
        	}
        	
        	if(jobWaitList.isEmpty()) {
        		time++;
        	}else {
            	Collections.sort(jobWaitList, new JobPTComparator());
            	
            	Job job = jobWaitList.remove(0);
            	
            	int startTime = job.getStartTime();
            	int processTime = job.getProcessTime();
            	int totalTime = job.getTotalTime(time);
            	
            	if(startTime >= time) {
            		time += (startTime - time + processTime);  
            	}else {
            		time += processTime;
            	}
            	
            	answer += totalTime;
//            	System.out.println(time + " " +totalTime);
        	}
        	
        	
        }
        
        return answer/jobs.length;
    }
}

class Job{
	private int startTime; // 요청 받은 시간
	private int processTime; // 처리 시간
	
	public Job(int startTime, int processTime) {
		this.startTime = startTime;
		this.processTime = processTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getProcessTime() {
		return processTime;
	}
	
	// 요청에서 종료까지 걸린 시간
	public int getTotalTime(int time) {
		int totalTime = processTime;
		
		if(startTime > time) {
			totalTime += (startTime - time);
		}else {
			totalTime += (time - startTime);
		}
		
		return totalTime;
	}
}

class JobPTComparator implements Comparator<Job>{
	
	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		if(o1.getProcessTime() < o2.getProcessTime()) {
			return -1;
		}else if(o1.getProcessTime() == o2.getProcessTime()) {
			return 0;
		}else {
			return 1;
		}
	}
}

class JobSTComparator implements Comparator<Job>{
	
	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		if(o1.getStartTime() < o2.getStartTime()) {
			return -1;
		}else if(o1.getStartTime() == o2.getStartTime()) {
			return 0;
		}else {
			return 1;
		}
	}
}
