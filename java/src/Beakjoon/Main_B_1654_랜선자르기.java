package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/13/24
 *  @see <a href="https://www.acmicpc.net/problem/1654" />
 *  @mem 18600 KB
 *  @time 184 ms
 *  @caution 이분 탐색
 *  - 랜선의 길이가 2의 31승 -1 이다. 따라서 long 을 사용해야한다.
*/
public class Main_B_1654_랜선자르기 {

    static long max;
    static int K, N;
    static long [] kList;

    static FastReader scan = new FastReader();

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        kList = new long [K];
        max = -1;
        for(int i = 0; i < K; i++) {
            kList[i] = scan.nextInt();
            max = Math.max(max, kList[i]);
        }
        max += 1;
    }

    static void lowerBounder() {
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (!isLanPossible(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    static boolean isLanPossible(long len) {
        int total = 0;
        for(long k : kList) {
            total += (k / len);
        }
        return total >= N;
    }

    // Main
    public static void main(String[] args) {
        input();
        lowerBounder();
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
