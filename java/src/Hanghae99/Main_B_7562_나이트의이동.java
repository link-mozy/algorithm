package Hanghae99;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  @author mozy
 *  @since 11/5/24
 *  @see <a href="https://www.acmicpc.net/problem/7562" />
 *  @mem 64864 KB
 *  @time 268 ms
 *  @caution bfs 문제
*/
public class Main_B_7562_나이트의이동 {

    static int T, I;
    static StringBuilder sb;

    static boolean [][] map;
    static int [][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    static class Point {
        int x, y, count;

        public Point() {
        }

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static boolean isIn(int x, int y) {
        return -1 < x && x < I && -1 < y && y < I;
    }

    static int bfs(Point start, Point end) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(start);
        // 시작점과 끝점이 동일한 경우 바로 종료
        if(start.x == end.x && start.y == end.y) {
            return 0;
        }
        while(!queue.isEmpty()) {
            Point front = queue.poll();
            map[front.x][front.y] = true;
            // 다음 놓을 위치 구하기
            for(int d = 0; d < dir.length; d++) {
                int x = front.x + dir[d][0];
                int y = front.y + dir[d][1];
                int count = front.count+1;
                if(isIn(x,y) && !map[x][y]) {
                    // 도착 했을 경우 (탈출 조건)
                    if(x == end.x && y == end.y) return count;
                    // 다음 위치 큐에 넣기
                    Point next = new Point(x, y, count);
                    queue.add(next);
                    map[x][y] = true;
                }
            }
        }
        return -1;
    }

    // Main
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        sb = new StringBuilder();
        T = scan.nextInt();

        for(int t = 0; t < T; t++) {
            Point start = new Point();
            Point end = new Point();
            // 값 입력
            I = scan.nextInt();
            map = new boolean[I][I];
            start.x = scan.nextInt(); // 시작 x
            start.y = scan.nextInt(); // 시작 y
            start.count = 0;
            end.x = scan.nextInt(); // 끝 x
            end.y = scan.nextInt(); // 끝 y
            end.count = 0;
            // 시작
            int count = bfs(start, end);
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
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
