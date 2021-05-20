import java.util.Scanner;

/* 2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 
 * 배열의 (i, j) 위치는 i행 j열을 나타낸다.
 * 예제
 * 2 3
 * 1 2 4
 * 8 16 32
 * 3
 * 1 1 2 3
 * 1 2 1 2
 * 1 3 2 3
 * 
 * 출력
 * 63
 * 2
 * 36
 */

public class BAEKJOON_2167 {
	// 사용할 변수들을 초기화
			static int R;
			static int C;
			static int num;
	public static void main(String[] args) {
		// System.setIn(new FileInputStream("src\\inputAS.txt"));

		Scanner s = new Scanner(System.in);
		// 계산할 행과 열을 받아옴
		R = s.nextInt();
		C = s.nextInt();
		
		// 배열을 생성함
		int [][] arr = new int [R][C];
		
		// 생성한 배열에 값을 넣어줌
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		// 연산을 진행할 횟수를 지정함
		num = s.nextInt();
		
		// 연산 지정 횟수만큼 반복함
		for(int caseTest = 0; caseTest < num; caseTest++) {
			
		// 각각 시작위치의 행렬부터 끝위치의 행렬을 맵핑
		int R1 = s.nextInt();
		int C1 = s.nextInt();
		int R2 = s.nextInt();
		int C2 = s.nextInt();
		
		int RCsum = 0;
		
		// 범위에 맞는 합연산을 진행		
		for (int i = R1 - 1; i < R2; i++) {
			for (int j = C1 - 1; j < C2; j++) {
				RCsum = RCsum + arr[i][j];
			}
		}
		
		System.out.println(RCsum);
		
		}
	}
}
