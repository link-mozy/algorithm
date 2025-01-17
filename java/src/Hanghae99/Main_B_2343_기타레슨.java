package Hanghae99;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 1/16/25
 *  @see <a href="https://www.acmicpc.net/problem/2343" />
 *  @mem 24840 KB
 *  @time 296 ms
 *  @caution 이진 탐색
 *  주요 포인트. 이진 탐색의 왼쪽 인덱스 (left) 초기값을 입력 받는 값의 최대값으로 해야한다.
*/
public class Main_B_2343_기타레슨 {

    static int N, M, min, max;
    static int nList [];

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        nList = new int[N];
        for (int i = 0; i < N; i++) {
            nList[i] = scan.nextInt();
            min = Math.max(min, nList[i]);
            max += nList[i];
        }
    }

    static int getBlurayCount(int len) {
        int count = 1;
        int total = 0;

        for(int i = 0; i < N; i++) {
            if(total + nList[i] > len) {
                count++;
                total = 0;
            }
            total += nList[i];
        }
        return count;
    }

    static void binary_search() {
        int left = min;
        int right = max;
        int result = max;

        while ( left <= right ) {
            int mid = (left + right) / 2;
            if(getBlurayCount(mid) <= M) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }


    // Main
    public static void main(String[] args) {
        input();
        binary_search();
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
