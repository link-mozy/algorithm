package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 복습, 조합과 구현을 사용하는 문제이고 개인적으로 좋은 문제라고 생각해서 복습한다.
 * @author c0re
 *
 */
public class Main_B_17135_캐슬디펜스_review {

	static int R, C, D;
	static int map[][];
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int [R][C];
		
		for(int row = 0; row < R; row++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0, new int [3]);
		System.out.println(max);
	}
	
	private static void combination(int r, int si, int position []) {
		if(r == 3) {
			attack(position);
			return;
		}
		
		for(int i = si; i < C; i++) {
			position[r] = i;
			combination(r + 1, i + 1, position);
		}
	}


	private static void attack(int[] position) {
		int deadCount = 0;
		// 적 찾기
		List<Enemy> enemies = new ArrayList<Enemy>();
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				if(map[row][col] == 1) enemies.add(new Enemy(row, col));
			}
		}
		
		while(true) {
			// 궁수 한명당 한명의 적을 선발하는 과정
			for(int i = 0; i < position.length; i++) {
				int archerLocation = position[i];
				PriorityQueue<Enemy> targetedEnemies = new PriorityQueue<>();
				
				for(int j = 0; j < enemies.size(); j++) {
					Enemy enemy = enemies.get(j);
					enemy.dist = Math.abs(enemy.row - R) + Math.abs(enemy.col - archerLocation);
					if(enemy.dist <= D) {
						targetedEnemies.offer(enemy); // 주소 입력
					}
				}
				// 만약 타겟에 들어온 적 있다면, 가장 첫번째의 적만 선택
				if(!targetedEnemies.isEmpty()) targetedEnemies.poll().isTargeted = true; // 주소로 접근
			}
			
			// 사망자 정리 - 사망하지 않은 적은 이동(만약, 성에 도착했다면, 없애줘야한다.)
			for(int i = 0; i < enemies.size(); i++) {
				Enemy enemy = enemies.get(i);
				if(enemy.isTargeted) {
					// 사망자
					enemies.remove(i--); // 인덱스 조절
					deadCount++;
				} else if(enemy.row == R - 1) {
					// 성벽에 도착
					enemies.remove(i--);
				} else {
					// 사망하지 않은 적
					enemy.row++;
				}
			}
			
			// 모든 적이 없다면 종료 
			if(enemies.size() == 0) {
				break;
			}
		}
		// 가장 많이 죽이는 값으로 선정
		max = Math.max(max, deadCount);
	}
	
	static class Enemy implements Comparable<Enemy>{
		Integer row, col, dist;
		boolean isTargeted;
		
		public Enemy(Integer row, Integer col) {
			this.row = row;
			this.col = col;
		}

		public Enemy(Integer row, Integer col, Integer dist) {
			this(row, col);
			this.dist = dist;
		}

		@Override
		public int compareTo(Enemy o) {
			if(this.dist.equals(o.dist)) {
				return this.row.compareTo(o.row);
			} else {
				return this.dist.compareTo(o.dist);
			}
		}
	}


	static String src = "5 5 5\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1\n" + 
			"1 1 1 1 1";
}
