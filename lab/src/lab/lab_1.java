package lab;

public class lab_1 {
	public static void main(String[]args){
		int a[]={2,4,6,8,10};
		int []c={1,3,5,7,9,11};
		System.arraycopy(a,2,c,1,3);
		System.out.print("สýื้c: ");
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+"");
		System.out.println();
		}
	
}
