package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 1/14/25
 *  @see <a href="https://www.acmicpc.net/problem/1654" />
 *  @mem 18184 KB
 *  @time 176 ms
 *  @caution 바이너리 서치 알고리즘
*/
public class Main_B_1654_랜선자르기2 {

    static int K, N;
    static long max;
    static long kList[];

    static FastReader scan = new FastReader();

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        max = 1;
        kList = new long[K];

        for (int k = 0; k < K; k++) {
            kList[k] = scan.nextLong();
            max = Math.max(max, kList[k]);
        }
    }

    static boolean possibleK(long number) {
        int count = 0;
        for(int k = 0; k < K; k++) {
            count += (kList[k] / number);
        }
        return N <= count;
    }

    static long proc() {
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (!possibleK(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // Main
    public static void main(String[] args) {
        input();
        System.out.println(proc());
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
