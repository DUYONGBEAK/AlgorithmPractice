import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에는 두 개의 자연수가 주어진다. 
 * 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 * 입력
 * 24 18
 * 
 * 출력
 * 6
 * 72
 */

public class BAEKJOON_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();

		String[] arr = N.split(" ");
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = Integer.parseInt(arr[i]);
		}

		Arrays.sort(newArr);

		int[] factor = new int[newArr[1] + 1];

		for (int i = 1; i <= newArr[0]; i++) {
			if (newArr[0] % i == 0) {
				factor[i]++;
			}
		}
		for (int i = 1; i <= newArr[1]; i++) {
			if (newArr[1] % i == 0) {
				factor[i]++;
			}
		}

		int result = 0;
		for (int i = 0; i < factor.length; i++) {
			if (factor[i] == 2) {
				result = i;
			}
		}
		System.out.println(result);

		int A = newArr[0] / result;
		int B = newArr[1] / result;

		int multiple = result * A * B;
		System.out.println(multiple);
	}
}
