package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 20.
 *  @see https://www.acmicpc.net/problem/17135
 *  @mem  27460
 *  @time 396
 *  @caution 
 *  조합을 이용해 궁수를 배치
 *  시뮬레이션으로 적군 이동
 *  동일 거리일 경우 맨 왼쪽의 적을 죽이고 즉시 죽는것이 아니고 모든 공격을 끝내고 일괄적으로 죽인다.
*/
public class Main_B_17135_캐슬디펜스 {
	
	static int R, C, D, max;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = -1;
		map = new int [R][C];
		for(int row = 0; row < R; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, new int[3], 0, 0);
		System.out.println(max);
	}

	private static void combination(int r, int[] temp, int ti, int si) {
		if(r == 3) {
			attack(temp);
			return;
		}
		for(int i = si; i < C; i++) {
			temp[ti] = i;
			combination(r + 1, temp, ti + 1, i + 1);
		}
	}

	private static void attack(int[] positions) {
		// 적군을 모아보자.
		List<Enemy> enemies = new ArrayList<>();
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				if(map[row][col] == 1) enemies.add(new Enemy(row, col));
			}
		}
		
		// 죽은 병사의 수
		int deadCount = 0;
		while(true) {
			// loop 한번이 한 턴
			// 궁수가 쏜다. - 죽일 대상 선정
			for(int i = 0; i < positions.length; i++) {
				int archer = positions[i];
				PriorityQueue<Enemy> targetedEnemies = new PriorityQueue<>();
				
				for(int e = 0; e < enemies.size(); e++) {
					Enemy enemy = enemies.get(e);
					// 거리 구하기
					enemy.d = Math.abs(archer - enemy.c) + Math.abs(R - enemy.r);
					// 아직 죽지는 않았고 거리내에 있는지 확인 후 사망 가능한 리스트에 넣기
					if(enemy.d <= D) {
						targetedEnemies.offer(enemy);
					}
				}
				// pq가 비어있지 않다면 맨 처음 녀석을 사망 표시
				if(!targetedEnemies.isEmpty()) targetedEnemies.poll().isTargeted = true;
			}
			
			// 사망자 정리 - 남은 병사들이 이동
			for(int e = 0; e < enemies.size(); e++) {
				Enemy enemy = enemies.get(e);
				if(enemy.isTargeted) {
					enemies.remove(e--); // 삭제하면서 인덱스 조절 조심
					deadCount++;
				} else if(enemy.r == R - 1) { // 적 성에 도착. 카운트는 증가하지 않으나 적은 없어진다. 
					enemies.remove(e--);
				} else {
					enemy.r++;
				}
			}
			
			// 모든 병사가 사망했다면 - 게임 종료
			if(enemies.size() == 0) {
				break; // while 탈출
			}
		} // while
		max = Math.max(max, deadCount);
	}

	static class Enemy implements Comparable<Enemy>{
		Integer r, c, d;
		boolean isTargeted; // 표적이 되었는지
		
		public Enemy(Integer r, Integer c) {
			super();
			this.r = r;
			this.c = c;
		}

		// 기본적으로 거리 기준, 거리가 같다면 왼쪽 기준
		@Override
		public int compareTo(Enemy o) {
			if(this.d.equals(o.d)) {
				return this.c.compareTo(o.c);
			} else {
				return this.d.compareTo(o.d);
			}
		}
	}
	
	static String src = "5 5 2\n" + 
			"0 0 0 0 0\n" + 
			"0 0 0 0 0\n" + 
			"0 0 0 0 0\n" + 
			"1 1 1 1 1\n" + 
			"0 0 0 0 0";
}
