package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *  @author mozy
 *  @since 11/16/24
 *  @see <a href="https://www.acmicpc.net/problem/1374" />
 *  @mem 55744 KB
 *  @time 640 ms
 *  @caution 그리디 문제
 *  - 끝나는 시간을 큐에 넣는다.
 *  - 큐의 첫번째 값은 가장 빨리 끝나는 강의 시간이다.
 *  - 끝나는 시간값이랑 시작하는 값이랑 비교했을때 시작 시간이 크다면, 해당 강의실은 사용할 수 있다.
 *  - 사용할 수 있다면, 큐에서 첫번째 값을 빼고 추가하고 그렇지 않다면 추가만 한다.
 *  - 큐에 갯수가 총 강의실의 갯수이다.
 *  문제해설 참고 : https://velog.io/@hyeokkr/백준1374-강의실-with-Java
*/
public class Main_B_1374_강의실 {

    static class Lecture implements Comparable<Lecture> {
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    static int N;
    static PriorityQueue<Integer> queue;
    static List<Lecture> list;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        queue = new PriorityQueue<>();
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new Lecture(
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt()
            ));
        }
        Collections.sort(list);
    }

    static void solution() {
        for(int i = 0; i < N; i++) {
            if (queue.isEmpty()) {
                queue.add(list.get(i).end);
            } else {
                int time = queue.peek(); // 가장 빨리 끝나는 시간.
                if(time <= list.get(i).start) {
                    queue.poll(); // 가장 앞에 있는 시간 제거
                }
                queue.add(list.get(i).end);
            }
        }
        System.out.println(queue.size());
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
