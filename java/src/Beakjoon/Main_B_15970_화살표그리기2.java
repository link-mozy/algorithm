package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 10/28/24
 *  @see <a href="https://www.acmicpc.net/problem/15970" />
 *  @mem 16556 KB
 *  @time 160 ms
 *  @caution 정렬 특징
 */
public class Main_B_15970_화살표그리기2 {

    static FastReader scan = new FastReader();
    static int N;
    static HashMap<Integer, ArrayList<Integer>> pointMap;

    static void input() {
        N = scan.nextInt();
        pointMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < N; i++) {
            int p = scan.nextInt(); // point
            int c = scan.nextInt(); // color
            if(!pointMap.containsKey(c)) pointMap.put(c, new ArrayList<>());
            pointMap.get(c).add(p);
        }
    }

    static void solution() {
        int result = 0;
        for(Integer color : pointMap.keySet()) {
            ArrayList<Integer> pointList = pointMap.get(color);
            Collections.sort(pointList);
            for(int i = 0; i < pointList.size(); i++) {
                // 시작 점은 오른쪽 값을 더한다.
                if(i == 0) {
                    result += (pointList.get(1) - pointList.get(0));
                // 끝 점은 왼쪽 값을 더한다.
                } else if (i == pointList.size() - 1) {
                    result += (pointList.get(i) - pointList.get(i - 1));
                } else {
                    result += Math.min(
                            (pointList.get(i) - pointList.get(i - 1)),
                            (pointList.get(i + 1) - pointList.get(i))
                            );
                }
            }
        }

        System.out.println(result);
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
