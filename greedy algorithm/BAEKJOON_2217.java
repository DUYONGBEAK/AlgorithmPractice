import java.util.Arrays;
import java.util.Scanner;

/* 첫째 줄에 정수 N이 주어진다
 * 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다.
 * 이 값은 10,000을 넘지 않는 자연수이다.
 * 예제
 * 2
 * 10
 * 15
 * 
 * 출력
 * 20
 */
public class BAEKJOON_2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Max = 0;
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		Max = arr[0] * N;
		int count = N - 1;

		for (int i = 1; i < N - 1; i++) {
			if (arr[i] * count > Max) {
				Max = arr[i] * count;
			}
			count--;
		}

		System.out.println(Max);
	}
}
