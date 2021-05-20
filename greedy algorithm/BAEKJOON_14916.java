import java.util.Scanner;

/* 손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 
 * 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 
 * 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 
 * 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
 * 첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
 * 예제
 * 13
 * 14
 * 
 * 출력
 * 5
 * 4
 */
public class BAEKJOON_14916 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int count = 0;
		int[] arr = new int[2];
		arr[0] = 2;
		arr[1] = 5;

		for (;;) {
			if (M < 0) {
				count = 0;
				break;
			}
			if (M == 0)
				break;

			if (M % 5 == 0) {
				count = count + (M / 5);
				break;
			}
			M = M - 2;
			count++;
		}

		if (count == 0) {
			count = -1;
		}

		System.out.println(count);

	}
}
