import java.util.Scanner;

/* 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 * 예제
 * 5
 * 1 1
 * 2 3
 * 3 4
 * 9 8
 * 5 2
 * 
 * 출력
 * 2
 * 5
 * 7
 * 17
 * 7
 */
public class BAEKJOON_10950 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.println(N + M);
		}
	}
}
