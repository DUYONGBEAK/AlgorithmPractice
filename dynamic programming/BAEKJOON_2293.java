import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* n가지 종류의 동전이 있다. 
 * 각각의 동전이 나타내는 가치는 다르다.
 * 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
 * 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
 * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 * 첫째 줄에 n, k가 주어진다. 
 * 입력
 * 3 10
 * 1
 * 2
 * 5
 * 
 * 출력
 * 10
 */
public class BAEKJOON_2293 {
	public static void main(String[] args) throws IOException {
		// 동전 종류의 개수를 받아올 변수를 생성
		int N;
		// 목표금액을 담을 변수를 생성
		int K;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// Tokenizer를 통해 보다 빠르게 입력값을 받아온다.
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 0번째 배열에는 값을 담지 않는다.
		// 코인의 종류배열과 dp배열을 생성
		int[] coin = new int[N + 1];
		int[] dp = new int[K + 1];

		// dp배열의 첫 값을 맵핑함
		dp[0] = 1;

		// 코인배열에 값을 넣어줌
		for (int i = 1; i < coin.length; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(Arrays.toString(coin));

		// coin의 배열만큼 이중 반복문을 돌려서 dp배열에 경우의 수를 누적시켜준다.  
		for (int i = 1; i < coin.length; i++) {
			for (int j = coin[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		System.out.println(Arrays.toString(dp));

		// 정답 출력
		System.out.println(dp[K]);
	}
}
