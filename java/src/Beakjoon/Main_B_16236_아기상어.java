package Beakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_B_16236_아기상어 {
	
	static class Shark {
		int r;
		int c;
		int size;
		int quant;
		int time;
		
		public Shark(int r, int c, int size, int quant, int time) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			if(size == quant) {
				this.size++;
				this.quant = 0;
			} else {
				this.quant = quant; 
			}
			this.time = time;
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int d;
		
		public Fish(int r, int c, int size, int d) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.d = d;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.d == o.d) {
				if (this.r == o.r) {
					return Integer.compare(this.c, o.c);
				} else {
					return Integer.compare(this.r, o.r);
				}
			} else {
				return Integer.compare(this.d, o.d);
			}
		}
	}
	
	static List<Fish> fishq = new ArrayList<Fish>();
	static List<Fish> ff = new ArrayList<Fish>();
	
	static int [] dr = {-1, 0, 0, 1};
	static int [] dc = {0, -1, 1, 0};
	
	static int N;
	static int [][] map;
	static int [][] v;
	static int cnt;
	static Shark shark;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		map = new int [N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scann.nextInt(); // 고기
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0); // 아기상어 한마리
				}
			}
		}
		cnt = 0;
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		fishq.clear();
		// 모든 물고기 정보 저장
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0 && map[i][j] < 7) { // 상어 제외 물고기
					fishq.add(new Fish(i, j, map[i][j], 0));
				}
			}
		}
		
		ff.clear(); // 상어가 먹을 수 있는 고기들 저장
		for (int i = 0; i < fishq.size(); i++) {
			Fish sfish = fishq.get(i);
			if(sfish.size < shark.size) {
				// 거리 필요
				int kk = distance(shark.r, shark.c, sfish.r, sfish.c, shark.size);
				if(kk != -1) {
					sfish.d = kk;
					ff.add(sfish);
				}
			}
		} //
		if(ff.size() == 0) {
			return;
		} else {
			Collections.sort(ff);
			Fish tfish = ff.get(0);
			int distance = tfish.d;
			int tr = tfish.r;
			int tc = tfish.c;
			int sr = shark.r;
			int sc = shark.c;
			shark = new Shark(tr, tc, shark.size, shark.quant + 1, shark.time + distance);
			map[sr][sc] = 0;
			map[tr][tc] = 9;
			cnt = shark.time;
			bfs();
		}
	}

	static int distance(int sr, int sc, int er, int ec, int size) {
		int [][] b = new int [N][N];
		Queue<Fish> que = new LinkedList<Fish>();
		que.offer(new Fish(sr, sc, size, 0));
		b[sc][sc] = 1;
		while(!que.isEmpty()) {
			Fish cf = que.poll();
			int cr = cf.r;
			int cc = cf.c;
			int csize = cf.size;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!check(nr, nc)) continue;
				if(b[nr][nc] != 0) continue;
				if(csize < map[nr][nc]) continue;
				if(er == nr && ec == nc) {
					return b[cr][cc];
				}
				b[nr][nc] = b[cr][cc] + 1;
				que.offer(new Fish(nr, cc, csize, 0));
			}
			
		}
		
		return -1;
	}

	private static boolean check(int cr, int cc) {
		return -1 < cr && cr < N && -1 < cc && cc < N;
	}
}
