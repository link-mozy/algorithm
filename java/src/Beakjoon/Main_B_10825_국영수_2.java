package Beakjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_10825_국영수_2 {

    static class Student implements Comparable<Student> {

        String name;
        int kr, en, ma;

        @Override
        public int compareTo(Student other) {
            // 국어 점수가 감소하는 순서로
            if(kr != other.kr) return other.kr - kr;
            // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if(en != other.en) return en - other.en;
            // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            if(ma != other.ma) return other.ma - ma;
            return name.compareTo(other.name);
        }
    }

    static PriorityQueue<Student> students;

    static void input() {
        FastReader scan = new FastReader();
        students = new PriorityQueue<>();
        int N = scan.nextInt();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            Student student = new Student();

            st = new StringTokenizer(scan.nextLine());
            student.name = st.nextToken();
            student.kr = Integer.parseInt(st.nextToken());
            student.en = Integer.parseInt(st.nextToken());
            student.ma = Integer.parseInt(st.nextToken());
            students.add(student);
        }
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        while (!students.isEmpty()) {
            sb.append(students.poll().name).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    // Main
    public static void main(String[] args) {
        input();
        output();
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
