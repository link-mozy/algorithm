package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/12/24
 *  @see <a href="https://www.acmicpc.net/problem/10816" />
 *  @mem 125936 KB
 *  @time 1492 ms
 *  @caution 이분 탐색
 *  - 중간값과 기준값의 부등호가 <= 이면, 찾고자하는 값의 왼쪽 인덱스 (최소)
 *  - 중간값과 기준값의 부등호가 < 이면, 찾고자하는 값의 오른쪽 인덱스 (최대)
 *  개인적으로 정말 어려운 문제.
 *  처음에는 찾은값의 양옆을 계산하도록 풀었는데, 시간초과
 *  다음으로 비교하는 카드 목록도 정렬 후 left 인덱스와 right 인덱스를 줄여가면 풀었는데, 중간에 틀림
*/
public class Main_B_10816_숫자카드2_2 {
    static int N, M;
    static int [] nList;
    static int [] mList;

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        nList = new int [N + 1];
        for (int i = 1; i <= N; i++) nList[i] = scan.nextInt();
        M = scan.nextInt();
        mList = new int [M + 1];
        for (int i = 1; i <= M; i++) mList[i] = scan.nextInt();
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        // 숫자 카드 정렬
        Arrays.sort(nList, 1, N+1);
        // 값 구하기
        for(int i = 1; i <= M; i++) {
            int leftIndex = lowerBound(mList[i]);
            int rightIndex = upperBound(mList[i]);
            sb.append(rightIndex - leftIndex).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int left = 1;
        int right = N;
        int result = N + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target <= nList[mid]) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static int upperBound(int target) {
        int left = 1;
        int right = N;
        int result = N + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target < nList[mid]) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
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
