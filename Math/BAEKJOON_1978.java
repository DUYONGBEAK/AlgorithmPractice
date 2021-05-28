import java.util.Scanner;
/* 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 입력
 * 4
 * 1 3 5 7
 *
 * 출력
 * 3
 */
public class BAEKJOON_1978 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			boolean isPrime = true;
			
			int num = sc.nextInt();
			if(num == 1) {
				continue;
			}
			for (int j = 2; j <= Math.sqrt(num) ; j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}
