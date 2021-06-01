import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
 * 첫 줄에는 전체 사람의 수 N이 주어진다.
 * 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 
 * 하나의 공백을 두고 각각 나타난다.
 * 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 
 * x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
 * 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 
 * 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로,
 * "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.
 * 입력
 * 5
 * 55 185
 * 58 183
 * 88 186
 * 60 175
 * 46 155
 * 
 * 출력
 * 2 2 1 2 5
 */
public class BAEKJOON_7568 {
	public static void main(String[] args) throws IOException {
		// 버퍼리더를 만든다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열이 들어오는 갯수를 받아온다.
		int N =  Integer.parseInt(br.readLine());
		// 체중과 몸무게를 넣을 이중 배열을 만든다.
		int[][] arr = new int[N][2];
		// 입력을 받아올 배열을 만든다.
		String [] sp;
		
		for (int i = 0; i < N; i++) {
			sp = br.readLine().split(" ");
			// 형변환
			arr[i][0] = Integer.parseInt(sp[0]);
			arr[i][1] = Integer.parseInt(sp[1]);
		}

		for (int i = 0; i < arr.length; i++) {
			int rank = 1;

			for (int j = 0; j < arr.length; j++) {

				// 같은 경우에는 비교할 필요가 없다.
				if (i == j) {
					continue;
				}
				// 기준값보다 덩치가 큰 값이 있으면 순위를 하나 올려준다.
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}

	}
}
