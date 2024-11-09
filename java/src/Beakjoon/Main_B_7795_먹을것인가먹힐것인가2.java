package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/9/24
 *  @see <a href="" />
 *  @mem 34240 KB
 *  @time 412 ms
 *  @caution 이분 탐색
 *  - 이분탐색 자주 하는 실수
 *    1. 입력된 배열에 바로 이분탐색하는 경우. (정렬 누락)
 *    2. L, R, M, Result 변수 정의를 헷갈려서 부등호등을 잘못 쓰는 경우.
 *    3. L, R 범위를 잘못 설정하거나 Result의 초기값을 잘못설정하는 경우.
 *  개인 주의사항.
 *  - 정렬할때 fromIndex, toIndex 값 제대로 설정하기...
 *  - 비교 값을 제대로 설정하기...
*/
public class Main_B_7795_먹을것인가먹힐것인가2 {

    static int T, N, M;
    static int [] aList;
    static int [] bList;
    static FastReader scan = new FastReader();

    static void intput() {
        N = scan.nextInt();
        M = scan.nextInt();
        aList = new int [N + 1];
        bList = new int [M + 1];

        for(int i = 1; i <= N; i++) aList[i] = scan.nextInt();
        for(int i = 1; i <= M; i++) bList[i] = scan.nextInt();;
    }

    static int binarySearch() {
        int result = 0;
        Arrays.sort(bList, 1, M+1); // B 리스트 정렬

        for(int i = 1; i <= N; i++) {
            int size = aList[i];
            int left = 1;
            int right = M;
            int count = left - 1;

            while(left <= right) {
                int min = (left + right) / 2;
                if(bList[min] < size) {
                    count = min;
                    left = min + 1;
                } else { // bList[min] >= size
                    right = min - 1;
                }
            }
            result += count;
        }
        return result;
    }

    // Main
    public static void main(String[] args) {
        T = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            intput();
            sb.append(binarySearch()).append("\n");
        }
        System.out.println(sb);
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
