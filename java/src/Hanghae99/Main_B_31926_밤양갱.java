package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/13/24
 *  @see <a href="" />
 *  @mem 14228 KB
 *  @time 112 ms
 *  @caution 그리디 문제
 *
 *  혼자서 해결하지 못하여 문제 풀이 참고함...
 *
 *  풀이 핵심 :
 *  총 정리는 2의 배수라면 n - Math.pow(2, m)이 음수가
 *  되지 않는 선에서 가장 큰 값에 마지막 2초를 추가 해준다.
 *  하지만, 2의 배수가 아니라면 마지막 daldida까지도
 *  복사가 가능하기 때문에 n - Math.pow(2, m)이 음수가
 *  되지 않는 선에서 가장 큰 값에 마지막 1초를 추가 해준다.
 *
 *  Coding_Slowly 의 블로그 참고 : https://steadycoding-turtleman.tistory.com/entry/BEAKJOON-JAVA-31926번-밤양갱#풀이-1
*/
public class Main_B_31926_밤양갱 {

    static int N;

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
    }

    static void solution() {
        int time = 8; // daldidalgo = 8 초

        for (int i = 0; ;i++) {
            if (N - Math.pow(2, i) == 0) {
                time = time + i + 2; // time + 복사한 i번 + daldidan 만드는데 2초
                break;
            }
            else if (N - Math.pow(2, i) < 0) {
                time = time + i + 1; // time + 복사한 i번 + daldidan 만드는데 1초
                break;
            }
        }

        System.out.println(time);
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
