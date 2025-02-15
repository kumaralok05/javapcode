package leetCodeCoding;
/*Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

public class MaximumPtoductOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={2,3,-2,4};
		int maxProduct=Integer.MIN_VALUE;
		{
			for (int i = 0; i < arr.length; i++) {
				int product = 1;
				for (int j = i; j < arr.length; j++) {
					product *= arr[j];
					if (product > maxProduct) {
						maxProduct = product;
					}

				}
			}

			System.out.println(maxProduct);
		}
		
		for(int i=0;i<arr.length;i++) {
			int currentProduct=1;
			currentProduct*=arr[i];
			maxProduct=Integer.max(currentProduct,maxProduct);
			if(currentProduct<0) {
				currentProduct=0;
			}
		}
		System.out.println(maxProduct);
	}

}
