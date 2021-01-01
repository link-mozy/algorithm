package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 2021. 1. 1.
 *  @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD
 *  @mem  19,448 kb
 *  @time 112 ms
 *  @caution
 *  입력받는 법을 가르쳐주는 친절한 문제
 *  그래프 문제같은데, dfs로 따라가면서 99가 존재하는지 확인만하면된다.
 *  다만, dfs함수에서 값이 0인경우를 찾아 리턴(재귀 종료)하도록만 설계하면 된다. 
*/
public class Solution_1219_길찾기_DFS {

	static int N;
	static int arr[][];
	static int result;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));
		
		while(true) {
			String line = in.readLine();
			if(line == null) break;
			
			arr = new int [100][2];
			StringTokenizer st = new StringTokenizer(line, " ");
			int tc = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			result = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			
			for(int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				if(arr[idx][0] == 0) arr[idx][0] = num;
				else arr[idx][1] = num;
			}

			dfs(0);
			sb.append("#" + tc + " " + result).append("\n");
			
		} // while loop
		
		System.out.println(sb);
		
	} // main
	
	private static void dfs(int idx) {
		if(idx > 99) return;
		for(int i = 0; i < 2; i++) {
			if(arr[idx][i] == 0) continue;
			if(arr[idx][i] == 99) {
				result = 1;
				return;
			}
			dfs(arr[idx][i]);
		}
	}

	static String src = "1 16\n" + 
			"0 1 0 2 1 4 1 3 4 8 4 3 2 9 2 5 5 6 5 7 7 99 7 9 9 8 9 10 6 10 3 7\n" + 
			"2 159 \n" + 
			"0 4 0 10 1 4 1 10 2 11 2 8 3 13 4 8 4 11 5 10 5 8 6 10 6 11 7 8 7 15 8 14 9 10 9 20 10 14 10 17 11 21 12 21 13 14 13 17 14 20 15 22 16 22 16 20 17 19 18 28 18 29 19 27 20 29 21 31 21 30 22 24 22 30 23 24 23 26 24 27 25 31 26 31 26 37 27 34 27 30 28 38 28 30 29 32 30 38 30 32 31 35 31 36 32 34 32 37 33 40 33 44 34 44 35 39 35 46 36 38 36 41 37 40 38 40 38 49 39 41 39 44 40 45 41 44 41 50 42 44 42 51 43 45 43 52 44 45 44 52 45 48 45 52 46 47 46 55 47 48 47 58 48 53 49 55 50 59 50 60 51 57 51 60 52 60 52 63 53 57 53 62 54 62 54 65 55 62 56 58 57 66 58 64 58 61 59 69 60 62 61 63 62 68 62 64 63 66 64 68 64 71 65 75 65 67 66 75 66 73 67 71 67 72 68 72 68 70 69 72 70 71 70 80 71 80 72 81 72 83 73 77 73 75 74 83 74 78 75 81 75 85 76 79 76 82 77 86 77 87 78 86 78 81 79 89 80 84 80 86 81 83 81 88 82 87 82 86 83 86 83 94 84 94 84 88 85 95 86 91 86 97 87 93 88 92 88 90 89 97 89 92 90 99 91 95 92 96 92 97 94 95 95 97 95 99 96 97 \n" + 
			"3 157 \n" + 
			"0 9 0 5 1 7 1 10 2 5 2 6 3 4 3 5 4 8 4 7 5 14 6 9 6 16 7 17 7 14 8 11 8 19 9 13 10 12 11 12 12 20 13 15 14 22 15 25 16 20 16 25 17 18 17 23 18 21 18 23 19 20 19 23 20 28 20 23 21 22 22 26 22 30 23 25 23 34 24 31 24 27 25 27 26 34 26 31 27 36 27 30 28 30 28 37 29 37 30 40 31 32 31 34 32 38 33 43 33 37 34 35 34 44 35 37 35 41 36 40 36 44 37 44 37 47 38 47 38 46 39 47 40 43 40 50 41 47 41 48 42 44 42 48 43 47 43 53 44 47 44 49 45 53 45 50 46 48 47 55 47 57 48 57 48 59 49 59 49 52 50 56 50 60 51 58 51 62 52 56 52 55 53 55 53 59 54 62 55 60 55 63 56 65 57 60 58 68 58 60 59 64 59 61 60 64 60 66 61 66 61 68 62 71 62 73 63 73 63 74 64 65 65 71 65 73 66 70 67 68 68 74 68 71 69 71 69 80 70 74 70 77 71 72 71 79 72 74 72 82 73 81 74 80 75 81 75 85 76 86 77 83 78 84 78 88 79 85 79 81 80 84 80 86 81 87 81 89 82 84 82 91 83 88 84 86 85 91 85 89 86 95 87 95 87 97 88 91 89 99 89 98 90 94 90 93 94 97 95 98 95 99 96 97 \n" + 
			"4 156 \n" + 
			"0 10 0 12 1 5 1 7 2 11 2 12 3 4 4 9 4 12 5 7 5 15 6 9 7 11 7 10 8 10 9 19 10 20 10 19 11 16 11 18 12 19 13 17 13 24 14 16 14 19 15 22 15 20 16 22 16 20 17 25 17 20 18 19 18 26 19 21 19 28 20 25 20 30 21 29 22 24 22 31 23 27 24 25 24 26 25 26 25 27 26 35 27 37 28 37 28 30 29 39 29 40 30 40 30 41 31 38 32 36 32 42 33 37 33 41 34 39 35 40 35 41 36 43 36 47 37 46 37 48 38 40 38 48 39 43 39 46 40 50 41 50 41 45 42 49 42 52 43 51 43 52 44 54 45 51 45 53 46 56 46 55 47 52 48 57 48 53 49 53 49 57 50 51 50 56 51 56 51 55 52 54 52 59 53 56 53 57 54 55 55 56 56 66 57 58 57 61 58 59 59 62 59 65 60 68 60 66 61 65 61 64 62 66 62 68 63 69 63 67 64 71 65 74 65 71 66 71 66 73 67 71 67 69 68 76 68 77 69 70 70 71 71 76 71 78 72 74 72 79 73 77 74 84 74 77 75 80 75 77 76 80 76 79 77 86 78 84 78 81 79 82 79 86 80 81 81 88 82 92 83 86 84 86 85 93 86 87 86 88 87 89 87 92 88 91 88 94 89 95 90 97 90 98 91 93 91 96 92 94 94 98 \n" + 
			"5 141 \n" + 
			"0 13 0 1 1 4 2 11 2 7 3 12 3 10 4 13 4 14 5 9 5 12 6 9 7 14 8 12 8 19 9 13 10 19 11 15 12 21 12 18 13 19 13 23 14 17 14 22 15 18 15 19 16 23 17 19 17 26 18 22 18 28 19 25 19 22 20 23 21 26 21 25 22 23 22 25 23 32 23 31 24 26 25 33 26 31 27 32 27 33 28 36 28 37 29 36 29 37 30 31 30 39 31 41 32 40 32 37 33 34 33 36 34 38 35 41 36 45 36 39 37 46 37 44 38 42 39 47 40 47 40 46 41 45 42 43 42 49 43 51 43 45 44 48 44 53 45 50 46 47 46 49 47 54 48 53 48 59 49 53 49 55 50 58 51 61 51 54 52 57 53 61 54 58 54 63 55 59 55 60 56 66 56 59 57 66 58 59 59 64 60 67 60 69 61 68 62 71 62 65 63 69 64 73 65 75 65 68 66 74 67 75 68 76 69 77 70 73 71 80 72 75 73 82 73 80 74 79 75 85 75 86 76 82 77 79 77 86 78 82 78 81 79 80 79 88 80 89 81 88 82 90 83 92 84 88 85 95 85 90 86 91 87 91 87 94 88 92 89 90 90 91 90 95 92 96 94 98 95 97 95 99 \n" + 
			"6 153 \n" + 
			"0 9 0 2 1 10 2 5 2 12 3 7 3 11 4 14 4 12 5 7 5 10 6 7 7 9 7 15 8 12 9 14 10 16 10 20 11 17 12 20 13 20 13 22 14 20 14 18 15 24 15 25 16 18 16 27 17 18 17 24 18 21 19 20 19 23 20 30 21 29 22 23 23 25 23 32 24 26 24 31 25 28 26 35 26 29 27 36 27 35 28 33 28 36 29 32 30 32 31 39 31 41 32 40 33 39 33 43 34 41 34 45 35 37 35 44 36 38 37 42 37 48 38 45 38 41 39 45 40 48 40 47 41 49 41 52 42 49 42 52 43 47 43 52 44 52 44 51 45 49 45 47 46 56 47 56 48 58 48 57 49 54 49 55 50 56 51 55 52 56 52 55 53 61 54 59 55 64 56 65 57 65 57 63 58 60 58 69 59 66 60 68 60 64 61 62 61 68 62 68 62 71 63 68 63 69 64 68 64 74 65 70 65 71 66 76 67 72 68 71 68 75 69 72 70 71 70 74 71 79 71 75 72 80 72 81 73 75 73 82 74 81 74 83 75 76 75 85 76 84 77 83 77 85 78 87 78 88 79 88 79 86 80 88 81 85 81 86 82 89 83 88 83 90 84 91 85 95 86 88 86 95 87 91 88 95 88 99 89 90 89 91 90 96 90 98 91 98 93 97 94 96 96 97 96 98 \n" + 
			"7 147 \n" + 
			"0 7 0 1 1 8 2 3 2 8 3 12 4 5 5 7 6 11 7 9 8 15 9 17 10 19 10 21 11 17 11 14 12 15 13 21 13 15 14 22 14 20 15 18 15 19 16 23 17 22 17 19 18 28 18 26 19 29 20 27 20 26 21 22 22 27 23 24 24 26 24 33 25 34 26 36 27 35 27 33 28 36 28 35 29 39 29 32 30 40 30 38 31 33 31 37 32 41 32 40 33 41 33 39 34 37 34 41 35 38 36 38 36 47 37 45 37 40 38 41 39 48 39 50 40 44 40 51 41 43 42 51 43 53 43 46 44 48 44 55 45 55 45 52 46 48 46 54 47 50 47 54 48 57 48 50 49 55 50 53 50 61 51 60 51 57 52 61 53 62 54 62 54 59 55 61 55 65 56 61 56 60 57 64 57 63 58 60 59 64 60 68 60 67 61 63 61 64 62 64 62 65 63 64 64 68 65 71 65 74 66 73 67 70 67 78 68 74 69 71 69 77 70 75 70 81 71 77 71 79 72 73 72 80 73 77 74 81 74 82 75 82 75 79 76 77 77 78 78 80 79 89 79 85 80 83 81 86 81 83 82 85 83 92 83 90 84 85 84 86 85 87 85 90 86 91 87 88 87 97 88 89 88 95 89 95 89 97 90 91 90 94 93 97 \n" + 
			"8 151 \n" + 
			"0 7 0 2 1 4 1 11 2 8 2 11 3 12 3 9 4 5 4 12 5 6 5 12 6 7 6 15 7 12 8 9 9 16 9 17 10 17 10 15 11 19 11 18 12 18 13 23 14 16 14 18 15 23 16 18 16 26 17 27 17 26 18 28 19 26 20 26 20 25 21 23 21 32 22 31 22 28 23 25 24 32 24 35 25 35 25 32 26 31 26 35 27 32 27 37 28 34 28 31 29 39 30 38 31 37 31 40 32 38 32 35 33 37 33 42 34 41 35 40 36 41 37 38 38 45 38 41 39 46 40 46 40 42 41 50 42 51 42 45 43 46 43 53 44 46 44 47 45 47 46 49 46 51 47 50 47 57 48 57 49 56 49 53 50 55 51 55 52 58 53 61 54 55 54 61 55 64 56 65 56 59 57 64 57 65 58 63 59 62 59 61 60 62 61 70 61 63 62 66 63 72 63 69 64 72 64 68 65 74 65 76 66 73 67 69 68 74 69 78 69 80 70 76 70 79 71 81 71 78 72 80 72 74 73 76 73 80 74 78 74 76 75 83 76 82 76 80 77 87 77 84 78 84 78 85 79 86 80 86 80 84 81 82 82 91 83 86 83 90 84 93 84 92 85 87 85 93 86 88 86 90 87 90 87 93 88 91 88 97 89 90 89 95 90 91 91 93 92 94 93 97 \n" + 
			"9 152 \n" + 
			"0 12 0 7 1 8 1 10 2 9 2 8 3 9 4 5 4 10 5 8 5 9 6 13 7 17 7 18 8 12 8 18 9 11 9 16 10 20 11 17 11 15 12 14 13 17 14 20 14 25 15 25 15 20 16 18 16 27 17 20 17 23 18 27 19 29 19 26 20 25 20 28 21 28 21 30 22 26 22 25 23 27 23 26 24 29 24 28 25 33 25 30 26 33 27 31 27 35 28 38 29 33 30 40 30 41 31 35 31 38 32 34 32 38 33 35 33 42 34 44 34 42 35 38 35 39 36 44 36 38 37 45 38 44 38 46 39 49 39 44 40 49 41 51 41 49 42 51 42 48 43 47 44 49 44 47 45 48 46 52 47 51 47 57 48 51 48 53 49 53 50 51 51 57 51 55 52 61 53 54 54 58 55 58 56 65 56 62 57 62 58 63 58 64 59 60 59 66 60 64 61 63 62 71 63 64 63 74 64 71 65 72 66 75 66 68 67 72 67 75 68 75 69 71 69 79 70 75 71 78 71 77 72 82 72 76 73 75 74 78 74 85 75 83 75 84 76 83 76 85 77 81 77 88 78 84 79 89 80 89 80 84 81 89 82 89 82 92 83 88 84 91 84 92 85 92 85 91 86 89 87 97 87 95 88 91 88 92 89 96 91 96 91 97 92 97 93 96 94 98 95 99 96 97 \n" + 
			"10 152\n" + 
			"0 3 0 1 1 3 2 10 3 10 4 13 4 11 5 14 6 8 7 13 7 15 8 16 8 11 9 13 9 17 10 14 10 20 11 17 12 14 12 15 13 18 14 16 14 25 15 22 15 17 16 17 16 27 17 26 18 19 18 28 19 28 20 27 20 30 21 25 21 32 22 29 22 24 23 30 24 34 24 32 25 31 25 36 26 28 26 35 27 32 27 37 28 33 28 31 29 37 30 36 30 38 31 40 31 33 32 36 32 38 33 41 33 40 34 35 34 42 35 36 36 44 36 47 37 41 37 46 38 40 38 47 39 41 39 47 40 42 40 46 41 49 42 49 42 48 43 51 43 45 44 48 44 47 45 55 45 56 46 52 46 57 47 53 47 55 48 53 49 55 50 56 50 52 51 59 52 57 53 59 53 63 54 58 55 61 56 65 57 66 57 60 58 66 58 68 59 69 59 61 60 61 61 66 62 65 63 72 63 69 64 71 65 74 65 75 66 69 66 75 67 77 67 71 68 75 68 70 69 76 69 71 70 76 71 76 71 77 72 82 72 80 73 80 73 83 74 76 74 77 75 81 76 86 77 78 77 84 78 85 79 84 79 88 80 86 80 91 81 90 82 89 83 84 83 89 84 94 84 91 85 93 85 92 86 95 87 90 87 95 88 96 88 93 89 95 90 96 94 97 94 96 96 97 ";
}
