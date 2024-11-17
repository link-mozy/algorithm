package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/17/24
 *  @see <a href="https://www.acmicpc.net/problem/2470" />
 *  @mem 29220 KB
 *  @time 364 ms
 *  @caution 두 포인터
 *  - 용액을 정렬하여 최소값과 최대값을 배열의 끝에서 가져올수잇도록 한다.
 *  - 가장 왼쪽(최소), 가장 오른쪽(최대) 으로 두개의 포인터를 설정한다.
 *  - 두 포인트의 값을 더해서 양수이면 어떠한 값을 더해도 양수이기때문에 오른쪽의 인덱스를 줄인다.
 *  - 음수이면 반대이기 때문에 왼쪽 인덱스를 증가시킨다.
 *  - 두 합의 절대값이 가장 작은값이 0과 가장 가까운 값이다.
*/
public class Main_B_2470_두용액_두포인터 {

    static int N;
    static int [] A;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
        Arrays.sort(A, 1, N+1);
    }

    static void solution() {
        int left = 1;
        int right = N;
        int sum = Integer.MAX_VALUE;
        int result [] = new int[2];
        result[0] = left;
        result[1] = right;
        while (left < right) {
            int _sum = A[left] + A[right];
            if(Math.abs(_sum) < sum) {
                sum = Math.abs(_sum);
                result[0] = A[left];
                result[1] = A[right];
            }
            if(_sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(result[0]+" "+result[1]);
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
