import java.util.Arrays;
import java.util.Scanner;

/*
 * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다
 * 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오. 
 * 첫째 줄에 N의 진짜 약수의 개수가 주어진다
 *	예제
 *	2
 *	4 2
	
 *	출력
 *	8
*/

public class BAEKJOON_1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int max = arr[T - 1];
		int min = arr[0];

		System.out.println(max * min);
	}
}
