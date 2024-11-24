package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/24/24
 *  @see <a href="https://www.acmicpc.net/problem/11055" />
 *  @mem 14496 KB
 *  @time 120 ms
 *  @caution DP 문제
 *  - 구현에서 실수
 *  - for (int i=2; i<=N; i++) ... 부분에서 dp[i] = A[i] 를 넣어줘야하는데,
 *    넣지 않아서 틀림.
*/
public class Main_B_11055_가장큰증가하는부분수열 {

    static int N;
    static int [] A;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N+1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        int [] dp = new int[N+1];
        dp[1] = A[1];
        int max = dp[1];

        for (int i=2; i <= N; i++) {
            dp[i] = A[i];
            for (int j=1; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + A[i]) {
                    dp[i] = dp[j] + A[i];
                }
            }
            if (max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }

    // Main
    public static void main(String[] args) {
        input();
        solution();
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
