package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/17/24
 *  @see <a href="" />
 *  @mem KB
 *  @time ms
 *  @caution 두 포인터 + 카운팅 기법
 *  - 강사님 문제 풀이 후 스켈레톤 코드 보고 작성
*/
public class Main_B_13144_ListOfUniqueNumbers_teacher {

    static int N;
    static int A [];
    static int count [];

    static long ans;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N + 1];
        count = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        for (int left = 1, right = 0; left <= N; left++) { // left 마다 right 을 최대한 옮겨 줄 계획
            // right 를 옮길 수 있을 만큼 옮긴다.
            while (right + 1 <= N && count[A[right + 1]] == 0) {
                right++;
                count[A[right]]++;
            }
            // 정답을 갱신한다.
            ans += right - left + 1;
            // left 을 옮겨주면서 A[left] 의 개수를 감소시킨다.
            count[A[left]]--;
        }

        System.out.println(ans);
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
