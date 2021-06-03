/* 함수만들기
 * 배열의 합을 구하는 함수 만들기
 */
public class BAEKJOON_15596 {
	
	public long sum(int[] a) {
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum+= a[i];
		}
		
		return sum;
	}
}
