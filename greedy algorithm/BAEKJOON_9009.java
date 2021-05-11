import java.util.Arrays;
import java.util.Scanner;

/* 피보나치 수 ƒK는 ƒK = ƒK-1 + ƒK-2로 정의되며 초기값은 ƒ0 = 0과 ƒ1 = 1 이다.
 * 하나의 양의 정수가 주어질 때,
 * 피보나치 수들의 합이 주어진 정수와 같게 되는 최소 개수의 서로 다른 피보나치 수들을 구하라. 
 * 예제
 * 4
 * 100
 * 200
 * 12345
 * 1003
 * 
 * 출력
 * 3 8 89
 * 1 55 144
 * 1 34 377 987 10946
 * 3 13 987
 */
public class BAEKJOON_9009 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[45];

		arr[0] = 1;
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		for (int test_case = 0; test_case < T; test_case++) {
			int num = sc.nextInt();
			int[] cnt = new int[45];
			int count = 0;
			for (int i = arr.length - 1; i >= 1; i--) {
				if (num >= arr[i]) {
					cnt[count] = arr[i];
					num = num - arr[i];
					count++;
				}
				if (num <= 0) {
					break;
				}
			}

			for (int i = 0; i < cnt.length; i++) {
				Arrays.sort(cnt);
				if (cnt[i] != 0) {
					System.out.println(cnt[i]);
				}
			}

		}
	}
}
