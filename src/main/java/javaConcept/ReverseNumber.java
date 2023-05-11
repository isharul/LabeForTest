package javaConcept;

public class ReverseNumber {

	public static void main(String[] args) {
		
		int i= 12345;
		int rev=0;
		while(i!=0) {
		
			int rem =i%10;
			rev=rev*10+rem;
			i=i%10;
		}
		System.out.println(rev);
		System.out.println("Command Is ready");

	}

}
