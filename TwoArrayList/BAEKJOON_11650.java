import java.util.Arrays;
import java.util.Scanner;
/* 2차원 평면 위의 점 N개가 주어진다.
 * 좌표를 x좌표가 증가하는 순으로, 
 * x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 * 입력
 * 5
 * 3 4
 * 1 1
 * 1 -1
 * 2 2
 * 3 3
 * 
 * 출력
 * 1 -1
 * 1 1
 * 2 2
 * 3 3
 * 3 4
 */
public class BAEKJOON_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 반복문을 돌릴 횟수를 받아온다.
		int N = sc.nextInt();
		
		// 이차원 배열을 생성한다.
		// 숫자는 2개만 들어오므로 열은 2로 준다.
		int [][] arr = new int[N][2];
		
		// 값을 넣어준다.
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// 람다식을 통한 배열 정렬
		Arrays.sort(arr,(e1, e2) -> {
			// x좌표의 값이 같다면 y좌표로 정렬한다.
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
				// x좌표의 값이 다르다면 x좌표로 정렬한다.
			} else {
				return e1[0] - e2[0];
			}
		});
		
		// System.out.println() 보다 속도가 빠른 출력방법
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}
