package Programmers;

import java.text.SimpleDateFormat;
import java.util.*;

public class P17676 { // 3 �߼� Ʈ����

	public static void main(String[] args) {
		P17676 p = new P17676();

		String[] str = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		p.solution(str);
	}
	
	public int solution(String[] lines) {
        int answer = 0;
        
        ArrayList<Log> Logs = new ArrayList<>();
        HashSet<Date> set = new HashSet<>();

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();

        for(int i = 0; i < lines.length; i++) {
        	String time = lines[i].substring(0,23);
        	// ó�� �ð�
        	int process = (int)(Double.parseDouble(lines[i].substring(24,lines[i].length()-1))*1000);
        	
        	try {
        		// ó�� �Ϸ� �ð�
        		Date endDate = transFormat.parse(time);
        		set.add(endDate);
//        		System.out.println(transFormat.format(endDate));
        		
        		cal.setTime(endDate);
        		cal.add(Calendar.MILLISECOND, -process+1);
        		
        		// ó�� ���� �ð�
        		Date startDate = cal.getTime();
        		set.add(startDate);
//        		System.out.println(transFormat.format(startDate));
        		
        		Logs.add(new Log(startDate, endDate));
        	}catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // �� �α׵��� ó�� ����, ���� �ð��� ��������
        // 1�� �ȿ� ��� ó���� �ִ��� Ȯ��
        for(Date start : set) {
        	
        	int cnt = 0;
        	
        	cal.setTime(start);
        	cal.add(Calendar.SECOND, 1);
        	
        	Date end = cal.getTime();
        	
        	for(int i = 0; i < Logs.size(); i++) {
        		Log log = Logs.get(i);
        		
        		Date sd = log.getstartDate();
        		Date ed = log.getendDate();
        		
        		if(end.after(sd)) {
        			if(start.before(ed) || start.equals(ed)) {
        				cnt++;
        			}
        		}
        	}
        	
        	if(cnt > answer) {
        		answer = cnt;
        	}
        }
        
        return answer;
    }
}

class Log {
	
	Date startDate;
	Date endDate;
	
	public Log(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getstartDate() {
		return startDate;
	}

	public Date getendDate() {
		return endDate;
	}
}
