package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B_17281_Baseball_실패 {
	
	static final int TOTAL_PLAYER = 9;
	static int N;
	static int iningMap [][];
	static boolean visited [];
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		iningMap = new int [N][TOTAL_PLAYER];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < TOTAL_PLAYER; j++) iningMap[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean [TOTAL_PLAYER];
		permutation(0, new int [TOTAL_PLAYER]);
		
		System.out.println(max);
	}
	
	private static void permutation(int r, int[] numberArray) {
		if(r == TOTAL_PLAYER) {
			int score = playGame(numberArray);
			max = Math.max(max, score);
			return;
		} else {
			for(int i = 0; i < TOTAL_PLAYER; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				numberArray[r] = i;
				permutation(r + 1, numberArray);
				visited[i] = false;
			}
		} // else
	} // permutation

	private static int playGame(int[] numberArray) {
		
		int totalScoreA = 0;		// A팀 총 점수
		int totalScoreB = 0;		// B팀 총 점수 
		
		for(int iningNum = 0; iningNum < N; iningNum++) {
			int outCount = 0;		// outCount
			int currentIdx = 0;		// 현재 플레이어 인덱스
			
			while(outCount < 3) {
				int playerMap = 0;	// 비트연산, 
				int score = 0;		// 1이닝 스코어
				int hitter = iningMap[iningNum][currentIdx];
//				System.out.println("currentIdx: " + currentIdx);
//				System.out.println("hitter: " + hitter);
				currentIdx = (currentIdx + 1) % 9;
				
				if(hitter == 0) {	// 0: 아웃
					outCount++;		// 타출 조건
				} else {			// 1,2,3,4
					playerMap += 1;	// 주자 나옴
					switch (hitter) { // 주자 이동
					case 1:			// 1: 안타
						playerMap = playerMap << 1;
						break;
					case 2:			// 2: 2루타
						playerMap = playerMap << 2;
						break;
					case 3:			// 3: 3루타
						playerMap = playerMap << 3;
						break;
					case 4:			// 4: 홈런
						playerMap = playerMap << 4;
						break;
					default:
						break;
					} // switch 비트연산
					
					if(playerMap >= 16) { // 득점
						// 15 : 만루인 경우
						int tempPlayerMap = playerMap & 15;
						System.out.println("playerMap: " + playerMap);
						score += addScore(playerMap ^ tempPlayerMap);
						playerMap = tempPlayerMap; // 득점하고 남은 주자들로 세팅
						
						if(iningNum % 2 == 0) totalScoreA += score;
						else totalScoreB += score;
					} // if
					
				} // else (no out)
				
			} // while
			
		} // for
		
//		System.out.println("totalScoreA : " + totalScoreA);
//		System.out.println("totalScoreB : " + totalScoreB);
		
		return Math.max(totalScoreA, totalScoreB);
	} // fn playGame

	private static int addScore(int num) {
		int temp = num;
		int score = 0;
		while(num > 0) {
			if((num & 1) == 1) score++;
			num >>= 1;
		}
		System.out.println("temp : " + temp);
		System.out.println("addScore: " + score);
		return score;
	}

	static String src = "2\n" + 
			"4 0 0 0 1 1 1 0 0\n" + 
			"0 0 0 0 0 0 0 0 0";
}
