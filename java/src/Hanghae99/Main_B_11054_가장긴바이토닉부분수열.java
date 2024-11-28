package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/28/24
 *  @see <a href="https://www.acmicpc.net/problem/11054" />
 *  @mem 14736 KB
 *  @time 144 ms
 *  @caution DP 알고리즘
 *  - 문제에서 순열 예시를 입력받는 값으로 착각하여 문제를 이해하는데 오래걸림 (순열의 예시로 \{\} 괄호 값으로 설명했으나 알아채지 못함.)
 *  - getMaxCount() 함수에서 해당 각 방향의 index DP 값을 더 할때도 해당 인덱스의 값을 더해야지 오른쪽, 왼쪽의 최대값을 구하면 안됨...
 *  - 해당 값은 중복이기 때문에 마지막에 -1 헤야함.
 *  - 결론. 문제를 이해하기까지 너무 오래걸림...
*/
public class Main_B_11054_가장긴바이토닉부분수열 {

    static int N;
    static int [] A;
    static int [][] dp;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
        dp = new int[N+1][2];
    }

    static void increment() {
        dp[1][0] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < i; j++) {
                if(A[j] < A[i] && dp[i][0] < dp[j][0] + 1) dp[i][0] = dp[j][0] + 1;
            }
        }
    }

    static void decrement() {
        dp[N][1] = 1;

        for(int i = N-1; i >= 1; i--) {
            dp[i][1] = 1;
            for(int j = N; j > i; j--) {
                if(A[j] < A[i] && dp[i][1] < dp[j][1] + 1) dp[i][1] = dp[j][1] + 1;
            }
        }
    }

    static int getMaxCount() {
        int max = 0;
        for(int i = 1; i <= N; i++) max = Math.max(max, dp[i][0] + dp[i][1]);
        return max - 1;
    }

    // Main
    public static void main(String[] args) {
        input();
        increment();
        decrement();
        System.out.println(getMaxCount());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
