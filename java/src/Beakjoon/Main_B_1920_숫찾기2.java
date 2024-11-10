package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/10/24
 *  @see <a href="https://www.acmicpc.net/problem/1920" />
 *  @mem 42420 KB
 *  @time 576 ms
 *  @caution 이분 탐색
*/
public class Main_B_1920_숫찾기2 {

    static int N, M;
    static int [] a;
    static int [] b;

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        a = new int [N + 1];
        for (int i = 1; i <= N; i++) a[i] = scan.nextInt();
        M = scan.nextInt();
        b = new int [M + 1];
        for (int i = 1; i <= M; i++) b[i] = scan.nextInt();
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(a, 1, N+1);

        for(int i = 1; i <= M; i++) {
            int result = binarySearch(b[i]);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target) {
        int left = 1;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(a[mid] < target) {
                left = mid + 1;
            } else if(a[mid] == target) {
                return 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
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
