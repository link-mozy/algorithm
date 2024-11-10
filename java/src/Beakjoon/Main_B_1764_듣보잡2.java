package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 11/10/24
 *  @see <a href="https://www.acmicpc.net/problem/1764" />
 *  @mem 24104 KB
 *  @time 248 ms
 *  @caution 이분 탐색
*/
public class Main_B_1764_듣보잡2 {

    static int N, M; // N : 듣도 못한 수, M : 보도 못한 수
    static String [] nList;
    static String [] mList;

    static List<String> result;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        nList = new String[N + 1];
        mList = new String[M + 1];
        result = new ArrayList<>();
        for(int i = 1; i <= N; i++) nList[i] = scan.nextLine();
        for(int i = 1; i <= M; i++) mList[i] = scan.nextLine();
    }

    static void solution() {
        Arrays.sort(nList, 1, N + 1); // 사전 순으로 출력하기 위해 정렬
        Arrays.sort(mList, 1, M + 1);

        for(int i = 1; i <= N; i++) {
            binarySearch(nList[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(String name : result) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }

    static void binarySearch(String name) {
        int left = 1;
        int right = M;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = mList[mid].compareTo(name);
            if(compare < 0) {
                left = mid + 1;
            } else if (compare == 0) {
                result.add(name);
                return;
            } else {
                right = mid - 1;
            }
        }
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
