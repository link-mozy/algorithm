package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author mozy
 *  @since 2021. 1. 17.
 *  @see https://www.acmicpc.net/problem/1697
 *  @mem  16440
 *  @time 116
 *  @caution 
 *  BFS문제...1차원 배열에서 거리를 증가하면서 최단거리를 구하는데, 방문 여부를 cnt값을 저장하면서 나아가는 문제...
 *  처음에 DFS로 풀었다가 메모리 초과가 나왔고 최단거리를 구하는 문제는 BFS로 푸는것이라고 한다.
 *  일차원 배열을 만들어 cnt값을 넣으면서 큐를 사용하는 것이 문제 핵심
*/
public class Main_B_1697_숨바꼭질_BFS {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));

		String[] arr = in.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		int map[] = new int [100001];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		
		while(!queue.isEmpty()) {
			N = queue.poll();
			
			if(N == K) break;
			if(0 <= N - 1 && map[N - 1] == 0) {
				queue.add(N - 1);
				map[N - 1] = map[N] + 1;
			}
			if(N + 1 <= 100000 && map[N + 1] == 0) {
				queue.add(N + 1);
				map[N + 1] = map[N] + 1;
			}
			if(N * 2 <= 100000 && map[N * 2] == 0) {
				queue.add(N * 2);
				map[N * 2] = map[N] + 1;
			}
		}
		System.out.println(map[K]);
		
	}
	

	static String src = "5 17";
}
