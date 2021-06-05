package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author mozy
 * @since 2021. 6. 5.
 * @see  
 * @mem  
 * @time 
 * @caution
 * 실패.
 * 72퍼센트에서 실패.
 * 질문, 데이터를 추가해 주세요.
 * 아래값을 입력했을 경우 출력값이 틀림
 * 
 * ===== 입력 =====

2
10 5 1
+[[]]
a
1 9 1
++[[++]+]
a

 * ===== 출력 =====

Loops 2 3
Loops 3 6

 */
public class Main_B_3954_Brainf별별k인터프리터_실패 {
	
	static final int MAX_CODE_COUNT = 50000000;
	
	// memorySize : Sm, codeSie : Sc, inputSie : Si
	static int memorySize, codeSize, inputSize;
	static int [] memory;
	static String codeStr;
	static String inputStr;
	
	static Stack<Integer> stack;
	static Bracket [] brackets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int TC = 0; TC < tc; TC++) {
			/** input **/
			st = new StringTokenizer(br.readLine(), " ");
			memorySize = Integer.parseInt(st.nextToken());
			codeSize = Integer.parseInt(st.nextToken());
			inputSize = Integer.parseInt(st.nextToken());
			codeStr = br.readLine();
			inputStr = br.readLine();
			
			/** init **/
			memory = new int [memorySize + 1];
			brackets = new Bracket [codeSize + 1];
			stack = new Stack<>();
			Arrays.fill(memory, 0);
			
			/** bracket map **/
			for(int i = 0; i < codeSize; i++) {
				if(codeStr.charAt(i) == '[') {
					stack.push(i);
					brackets[i] = new Bracket(i, 0);
				}
				else if(codeStr.charAt(i) == ']') {
					int left = stack.pop();
					brackets[i] = new Bracket(left, i);
					brackets[left].right = i;
				}
			}
			
			/** brainfuck process **/
			int codeIdx = 0;
			int codeCount = 0;
			int memoryIdx = 0;
			int inputIdx = 0;
			int maxIdx = 0; // inifLoop index
			
			while(true) {
				if(maxIdx < codeIdx) maxIdx = codeIdx;
				if(codeIdx == codeSize) {
					sb.append("Terminates").append("\n");
					break;
				}
				if(codeCount >= MAX_CODE_COUNT) {
					sb.append("Loops " + brackets[maxIdx].left + " " + brackets[maxIdx].right).append("\n");
					break;
				}
				
				char command = codeStr.charAt(codeIdx);
				switch (command) {
				case '-':
					memory[memoryIdx]--;
					if(memory[memoryIdx] == -1) memory[memoryIdx] = 255;
					break;
				case '+':
					memory[memoryIdx]++;
					if(memory[memoryIdx] == 256) memory[memoryIdx] = 0;
					break;
				case '<':
					memoryIdx--;
					if(memoryIdx == -1) memoryIdx = memorySize - 1;
					break;
				case '>':
					memoryIdx++;
					if(memoryIdx == memorySize) memoryIdx = 0;
					break;
				case '[':
					if(memory[memoryIdx] == 0) codeIdx = brackets[codeIdx].right;
					break;
				case ']':
					if(memory[memoryIdx] != 0) codeIdx = brackets[codeIdx].left;
					break;
				case '.':
					
					break;
				case ',':
					if(inputIdx == inputSize) memory[memoryIdx] = 255;
					else {
						memory[memoryIdx] = (int) inputStr.charAt(inputIdx);
						inputIdx++;
					}
					break;
				}
				
				codeIdx++;
				codeCount++;
				
			} // while
			
		} // for
		
		System.out.println(sb);
		
	} // main
	
	static class Bracket {
		int left, right;

		public Bracket(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	

	static String str = "4\n"
			+ "10 4 3\n"
			+ "+-.,\n"
			+ "qwe\n"
			+ "1000 5 1\n"
			+ "+[+-]\n"
			+ "a\n"
			+ "100 74 4\n"
			+ "+++++[->++<]>[-<+++++++>]<[->+>+>+>+<<<<]>+++>--->++++++++++>---<<<.>.>.>.\n"
			+ "xxyz\n"
			+ "9999 52 14\n"
			+ "+++++[>+++++++++<-],+[-[>--.++>+<<-]>+.->[<.>-]<<,+]\n"
			+ "this_is_a_test";
}
