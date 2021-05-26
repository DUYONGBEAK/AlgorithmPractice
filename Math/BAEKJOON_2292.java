import java.util.Scanner;
/* 육각형으로 이루어진 벌집이 있다. 
 * 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 
 * 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
 * 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 * 입력
 * 13
 * 
 * 출력
 * 3
 */
public class BAEKJOON_2292 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 1칸 - 1
		// 2칸 - 2~7
		// 3칸 - 8~19
		// 4칸 - 20~37
		// 5칸 - 38~61
		
		// 사용자로부터 목표 칸을 입력 받음
		int N = sc.nextInt();
		// 사용자로부터 입력받은 숫자와 같은 라인에 있는 숫자
		int pileup = 1;
		// 움직인 라인을 카운트함
		int cnt = 1;
		
		while(true) {
			// 같은 라인에 도달했거나 크다면 반복문 종료 
			if(pileup >= N) {
				break;
			}
			// 6의 배수만큼 더해주고 카운트를 하나씩 더해줌. 라인별로 가장 큰 수가 맵핑됨 
			pileup = pileup + (6 * cnt);
			cnt++;
		}
		// 출력
		System.out.println(cnt);
	}
}
