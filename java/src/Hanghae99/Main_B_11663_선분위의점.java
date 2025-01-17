package Hanghae99;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 1/15/25
 *  @see <a href="https://www.acmicpc.net/problem/11663" />
 *  @mem 60092 KB
 *  @time 816 ms
 *  @caution 이진 탐색
*/
public class Main_B_11663_선분위의점 {

    static int N, M;
    static int nList [];
    static int mList [][];

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();

        nList = new int[N + 1];
        mList = new int[M + 1][2];

        for(int i = 1; i <= N; i++) {
            nList[i] = scan.nextInt();
        }
        for(int i = 1; i <= M; i++) {
            mList[i][0] = scan.nextInt();
            mList[i][1] = scan.nextInt();
        }
        Arrays.sort(nList, 1, N+1);
    }

    static int left_search(int m) {
        int left = 0;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nList[mid] < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static int right_search(int m) {
        int left = 0;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nList[mid] <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static void proc() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= M; i++) {
            int left = left_search(mList[i][0]);
            int right = right_search(mList[i][1]);
            sb.append((right > left)? (right - left) : 0).append("\n");
        }
        System.out.println(sb);
    }

    // Main
    public static void main(String[] args) {
        input();
        proc();
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
