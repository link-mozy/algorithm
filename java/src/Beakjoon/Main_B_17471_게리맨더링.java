package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 2. 4.
 *  @see https://www.acmicpc.net/problem/17471
 *  @mem  12632
 *  @time 100
 *  @caution
 *  너무 어려웠던 문제다.
 *  1. 조합을 통해 구역을 나눈다.
 *  2. DBF를 통해 나눈구역이 연결되어있는지 확인한다.
 *  3. 한구역에는 꼭 하나라도 있어야한다.
 *  세개의 조건을 만족하는지 체크하고 마지막에 두 구역의 각각의 합을 구한뒤 뺀값의 최솟값을 구한다.
*/
public class Main_B_17471_게리맨더링 {
	
	static int N, min;
	static int amount[];
	static boolean connected[];
	static List<Integer> list[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(in.readLine());
		amount = new int [N + 1];
		list = new ArrayList [N + 1];
		connected = new boolean [N + 1];
		
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i < N + 1; i++) amount[i] = Integer.parseInt(st.nextToken());
		
		for(int x = 1; x < N + 1; x++) {
			list[x] = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine(), " ");
			int len = Integer.parseInt(st.nextToken());
			for(int i = 0; i < len; i++) {
				list[x].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		combination(1);
		System.out.println((min == Integer.MAX_VALUE)? -1 : min);
	}
	

	/**
	 * 부분집합으로 두 개의 선거구 나누기
	 * @param idx
	 */
	private static void combination(int idx) {
		if(idx == N + 1) {
			// 탈출 조건, 해당하는 구역을 모두 선택
			if(check()) {
				// 연결되었다면
				int area1 = 0;
				int area2 = 0;
				for(int i = 1; i < N + 1; i++) {
					if(connected[i]) area1 += amount[i];
					else area2 += amount[i];
				}
				min = Math.min(min, Math.abs(area1 - area2));
			}
			return;
		}
		
		// 1선거구로 선택
		connected[idx] = true;
		combination(idx + 1);
		
		// 1선거구로 선택하지 않음
		connected[idx] = false;
		combination(idx + 1);
	}


	/**
	 * 각 선거구에 포함된 구역이 모두 연결되었는가 확인
	 * @return
	 */
	private static boolean check() {
		boolean visited[] = new boolean[N + 1];
		
		int area1 = -1;
		int area2 = -1;
		// 선거구1 구역에 포함된 한 구역을 찾기
		for(int i = 1; i < N + 1; i++) {
			if(connected[i]) {
				area1 = i;
				break;
			}
		}
		
		// 선거구2 구역에 포함된 한 구역을 찾기
		for(int i = 1; i < N + 1; i++) {
			if(!connected[i]) {
				area2 = i;
				break;
			}
		}
		
		// 선거구에 포함된 구역이 없다면 false
		// 각 구역은 두 선거구 중 하나에 포함
		if (area1 == -1 || area2 == -1) return false;
		
		Queue<Integer> queue = new LinkedList<>();
		// 먼저 1선거구에 포함된 구역들이 모두 연결되었는지 확인
		queue.add(area1);
		visited[area1] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			// 현재 구역과 연결된 구역들을 확인
			for(int i = 0; i < list[now].size(); i++) {
				int num = list[now].get(i);
				// 이미 확인한 곳이면 pass
				if(visited[num]) continue;
				// 1구역이 아니면 pass
				if(!connected[num]) continue;
				visited[num] = true;
				queue.add(num);
			}
		}
		
		// 2선거구에 포함된 구엿들이 모두 연결되었는지 확인
		queue.add(area2);
		visited[area2] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			// 현재 구역과 연결된 구역들을 확인
			for(int i = 0; i < list[now].size(); i++) {
				int num = list[now].get(i);
				// 이미 확인한 곳이면 pass
				if(visited[num]) continue;
				// 2구역이 아니면 pass
				if(connected[num]) continue;
				visited[num] = true;
				queue.add(num);
			}
		}
		
		// 한 곳이라도 연결되지 않았다면, false
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) return false;
		}
		
		return true;
	}


	static String src = "6\n" + 
			"5 2 3 4 1 2\n" + 
			"2 2 4\n" + 
			"4 1 3 6 5\n" + 
			"2 4 2\n" + 
			"2 1 3\n" + 
			"1 2\n" + 
			"1 2";
}
