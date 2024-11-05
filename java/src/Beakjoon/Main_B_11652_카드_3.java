package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/5/24
 *  @see <a href="https://www.acmicpc.net/problem/11652" />
 *  @mem 34260 KB
 *  @time 332 ms
 *  @caution 정렬 특성 문제
 *  - 자신과 비슷한 값은 양옆에 존재한다.
 *  문제 풀때 주의 사항:
 *  - 정렬할때 fromIndex, toIndex 설정하기... (0번째 값은 사용하지 않기 때문)
*/
public class Main_B_11652_카드_3 {

    static int N;
    static long [] cards;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        cards = new long[N + 1];
        for(int i = 1; i <= N; i++)
            cards[i] = scan.nextLong();
    }

    static void solution() {
        // 카드 정렬
        Arrays.sort(cards, 1, N+1);

        long mode = cards[1];
        int modeCount = 1;
        int currentCount = 1;

        for(int i = 2; i <= N; i++) {
            // 전카드와 현재카드 비교
            if(cards[i-1] == cards[i]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if(modeCount < currentCount) {
                mode = cards[i];
                modeCount = currentCount;
            }
        }

        System.out.println(mode);
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
