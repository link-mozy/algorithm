package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 10. 23.
 * @see  https://www.acmicpc.net/problem/10825
 * @mem  62748 KB
 * @time 1780 ms
 * @caution
 * 정렬. compareTo 사용했을 경우.
 * 음수이면, 내가 먼저
 * 양수이면, 상대방이 먼저
 */
public class Main_B_10825_국영수 {

	static class Elem implements Comparable<Elem> {
		String name;
		int kr;
		int en;
		int ma;
		
		public Elem(String name, int kr, int en, int ma) {
			this.name = name;
			this.kr = kr;
			this.en = en;
			this.ma = ma;
		}

		@Override
		public int compareTo(Elem other) {
			// 국어 점수 내림차순
			if(kr != other.kr) return other.kr - kr;
			// 영어 점수 오름차순
			if(en != other.en) return en - other.en;
			// 수학 점수 내림차순
			if(ma != other.ma) return other.ma - ma;
			// 이름 으로 오름차순
			return name.compareTo(other.name);
		}
		
	}

	static PriorityQueue<Elem> pq;
	
	public static void main(String[] args) {
		input();
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().name);
		}
	}

	private static void input() {
		pq = new PriorityQueue<Elem>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int kr = Integer.parseInt(st.nextToken());
				int en = Integer.parseInt(st.nextToken());
				int ma = Integer.parseInt(st.nextToken());
				Elem elem = new Elem(name, kr, en, ma);
				pq.add(elem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String src = "12\n"
			+ "Junkyu 50 60 100\n"
			+ "Sangkeun 80 60 50\n"
			+ "Sunyoung 80 70 100\n"
			+ "Soong 50 60 90\n"
			+ "Haebin 50 60 100\n"
			+ "Kangsoo 60 80 100\n"
			+ "Donghyuk 80 60 100\n"
			+ "Sei 70 70 70\n"
			+ "Wonseob 70 70 90\n"
			+ "Sanghyun 70 70 80\n"
			+ "nsj 80 80 80\n"
			+ "Taewhan 50 60 90";
}
