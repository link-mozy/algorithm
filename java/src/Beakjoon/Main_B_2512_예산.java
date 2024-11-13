package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/13/24
 *  @see <a href="https://www.acmicpc.net/problem/2512" />
 *  @mem 15316 KB
 *  @time 152 ms
 *  @caution 이분 탐색
 *  - 강사님 문제 풀이 보고 해결... (다시 혼자 풀어볼것)
 *  - left, right 넣어주는 부등호 설정을 아직도 실수함...
*/
public class Main_B_2512_예산 {

    static int N, M, left, right;
    static int nList [];

    static FastReader scan = new FastReader();

    static void input() {
        left = 0;
        right = 0;
        N = scan.nextInt();
        nList = new int [N];
        for(int i = 0; i < N; i++) {
            nList[i] = scan.nextInt();
            right = Math.max(right, nList[i]);
        }
        M = scan.nextInt();
    }

    static int lowerBounder() {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int budget = getBudget(mid);
            if(budget <= M) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static int getBudget(int m) {
        int total = 0;
        for(int i = 0; i < N; i++) {
            total += Math.min(m, nList[i]);
        }
        return total;
    }

    // Main
    public static void main(String[] args) {
        input();
        System.out.println(lowerBounder());
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
