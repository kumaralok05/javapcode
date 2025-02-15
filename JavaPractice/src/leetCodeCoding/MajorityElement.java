package leetCodeCoding;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,2,3};
		int n=arr.length;
		
		for(int val:arr) {
			int count=0;
			for(int ele:arr) {
				if (ele==val) {
					count++;
				}
			}
			if(count>n/2) {
				System.out.println(val);
			}
		}

	}
	

}
