package Programmers;

import java.util.*;

public class P42627 { // 3 ��ũ ��Ʈ�ѷ�
	
	public static void main(String[] args) {
		
		P42627 p = new P42627();
		
		int[][] jobs = {{0,5},{1,2},{5,5}};
		
		System.out.println(p.solution(jobs));
		
	}
	
	// Shortest Job First(SJF) �����층
	// ���� ������ �ͺ��� ó�� => ��� ��� �ð��� ���� ����.
	// ���� CPU������ � ó���� ���� ��� �̸� ����ϱ� �����.
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
	private int startTime; // ��û ���� �ð�
	private int processTime; // ó�� �ð�
	
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
	
	// ��û���� ������� �ɸ� �ð�
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
