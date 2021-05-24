import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/* 계단 오르는 데는 다음과 같은 규칙이 있다.
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 * 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 
 * 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 
 * 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 * 입력의 첫째 줄에 계단의 개수가 주어진다.
 * 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다.
 * 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 * 입력
 * 6
 * 10
 * 20
 * 15
 * 25
 * 10
 * 20
 * 
 * 출력
 * 75
 */
public class BAEKJOON_2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 주어진 크기보다 한칸 더 크게 배열을 만들어줌
		int[] arr = new int[N + 1];
		// 숫자의 합을 차례로 더해줄 배열을 만들어줌
		int[] dp = new int[N + 1];

		// 반복문을 돌려서 1칸부터 배열에 값을 넣어줌
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}


		// dp배열의 2번째칸 까지 초기값을 지정해줌
		dp[1] = arr[1];
		if (N >= 2) { // N이 1일 경우도 존재하기 때문에 조건을 주어서 예외처리를 함
			dp[2] = Math.max(dp[1] + arr[2], arr[2]);
		}
 
		// 핵심로직
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
		}

		System.out.println(dp[N]);

	}
}
