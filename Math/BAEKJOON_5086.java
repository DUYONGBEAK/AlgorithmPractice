import java.util.Scanner;

/* 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
 * 1.첫 번째 숫자가 두 번째 숫자의 약수이다.
 * 2.첫 번째 숫자가 두 번째 숫자의 배수이다.
 * 3.첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
 * 예제
 * 8 16
 * 32 4
 * 17 5
 * 0 0
 * 
 * 출력
 * factor
 * multiple
 * neither
 */
public class BAEKJOON_5086 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (num1 == 0 && num2 == 0) {
				break;
			}
			if (num2 % num1 == 0) {
				System.out.println("factor");
			} else if (num1 % num2 == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
		}
	}
}
