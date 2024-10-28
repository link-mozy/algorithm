package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 10/28/24
 *  @see <a href="https://www.acmicpc.net/problem/1072" />
 *  @mem 14308 KB
 *  @time 112 ms
 *  @caution 이진탐색
*/
public class Main_B_1072_게임 {

    static int X, Y, Z;
    static int result;

    static void input() {
        FastReader scan = new FastReader();
        X = scan.nextInt();
        Y = scan.nextInt();
        Z = getPercent(X, Y);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

    static void solution() {
        int left = 0;
        int right = X;
        result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(getPercent(X + mid, Y + mid) != Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    // Main
    public static void main(String[] args) {
        input();
        solution();
        System.out.println(result);
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
