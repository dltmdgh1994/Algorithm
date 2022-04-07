package Programmers;

import java.util.*;

public class P42893 { // ¸ÅÄªÁ¡¼ö
	public static void main(String[] args) {
		
		P42893 p = new P42893();
		
		String s = "abc@abc abc abc, abc, ";
		String[] str = s.split("[^a-z]+");
		for(String sss : str) {
			System.out.println(sss);
		}
	}
	
	HashSet<String> set = new HashSet<>();
	
    public int solution(String word, String[] pages) {
        
        word = word.toLowerCase();
        
        for(String page : pages) {
        	String[] p = page.split("\n");
        	int idx = p[3].indexOf("https://");
        	String url = p[3].substring(idx+8, p[3].length()-3);
        	set.add(url);
        }
        
        ArrayList<Webpage> wp = new ArrayList<>();
        for(String page : pages) {
        	String[] p = page.split("\n");
        	int idx = p[3].indexOf("https://");
        	String url = p[3].substring(idx+8, p[3].length()-3);
        	
        	ArrayList<String> links = new ArrayList<>();
        	int basicScore = 0;
        	int linkCnt = 0;
        	for(int i = 6; i < p.length-2; i++) {
        		if(p[i].contains("<a href")) {
        			int stIdx = p[i].indexOf("<a href")+17;
        			int endIdx = p[i].indexOf("></a>")-1;
        			String tmp = p[i].substring(stIdx,endIdx);
        			if(set.contains(tmp)) {
        				links.add(tmp);
        			}
        			linkCnt++;
        		}
        		
        		String[] str = p[i].toLowerCase().split("[^a-z]+");
        		for(String s : str) {
        			if(s.equals(word)) {
        				basicScore++;
        			}
        		}
        	}
        	
        	Webpage web = new Webpage(url, basicScore, linkCnt);
        	for(String link : links) {
        		web.addLink(link);
        	}
        	
        	wp.add(web);
        }
        
        
        
        int answer = 0;
        return answer;
    }
}

class Webpage{
	String url;
	int basicScore;
	int linkCnt;
	ArrayList<String> links;
	
	public Webpage(String url, int basicScore, int linkCnt) {
		this.url = url;
		this.basicScore = basicScore;
		this.linkCnt = linkCnt;	
		links = new ArrayList<>();
	}
	
	public void addLink(String url) {
		links.add(url);
	}
}
