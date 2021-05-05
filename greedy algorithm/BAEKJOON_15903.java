import java.util.Arrays;
import java.util.Scanner;

/* x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
 * 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
 * 이 카드 합체를 총 m번 하면 놀이가 끝난다. 
 * m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다.
 * 이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
 * 첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과 
 * 카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)이 주어진다.
 * 두 번째 줄에 맨 처음 카드의 상태를 나타내는 n개의 자연수 a1, a2, …, an이 공백으로 구분되어 주어진다. (1 ≤ ai ≤ 1,000,000)
 * 첫 번째 줄에 만들 수 있는 가장 작은 점수를 출력한다.
 * 예제
 * 3 1
 * 3 2 6
 * 
 * 출력
 * 16
 * 
 * 예제
 * 4 2
 * 4 2 3 1
 * 
 * 출력
 * 19
 */
public class BAEKJOON_15903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long R = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			int K = sc.nextInt();
			arr[i] = K;
		}

		for (int i = 0; i < M; i++) {
			Arrays.sort(arr);
			long T = arr[0] + arr[1];
			arr[0] = T;
			arr[1] = T;
		}

		for (int i = 0; i < arr.length; i++) {
			R = R + arr[i];
		}
		System.out.println(R);
	}
}
