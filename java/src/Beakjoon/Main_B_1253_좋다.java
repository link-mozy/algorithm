package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/17/24
 *  @see <a href="https://www.acmicpc.net/problem/1253" />
 *  @mem 14612 KB
 *  @time 156 ms
 *  @caution 두 포인터
 *  - 배열을 정렬하여 왼쪽은 최소, 오른쪽은 최대로 만든다.
 *  - 각 값을 두 포인터 전략을 사용하여 두 값을 더해서 해당 값을 만들 수 있는지 확인.
*/
public class Main_B_1253_좋다 {

    static int N;
    static int [] A;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int [N + 1];
        for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }

    static void solution() {
        int count = 0;
        Arrays.sort(A, 1, N+1);

        for(int i = 1; i <= N; i++) {
            int left = 1;
            int right = N;

            if(searchTwoPointer(i, left, right)) count++;
        }

        System.out.println(count);
    }

    static boolean searchTwoPointer(int targetIdx, int left, int right) {
        int target = A[targetIdx];
        while (left < right) {
            if (left == targetIdx) {
                left++;
                continue;
            }
            if (right == targetIdx) {
                right--;
                continue;
            }
            int sum = A[right] + A[left];
            if(target == sum) {
                return true;
            }
            if(sum - target > 0) {
                right--;
            } else {
                left++;
            }
        }
        return false;
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
