package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/28/24
 *  @see <a href="https://www.acmicpc.net/problem/2631" />
 *  @mem 14136 KB
 *  @time 100 ms
 *  @caution DP 알고리즘
*/
public class Main_B_2631_줄세우기 {

    static int N;
    static int [] A;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        int [] dp = new int[N + 1];
        dp[1] = 1;

        int max = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(A[j] < A[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
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
