package leetCodeCoding;
/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]*/

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		int[] ans = productExceptSelf(nums);
		for (int n : ans) {
			System.out.println(n);
		}

	}

/*	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		System.out.println(n);

		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			int product = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					product = product * nums[j];
				}

			}
			ans[i] = product;
		}

		return ans;

	}*/
	
	public static int[] productExceptSelf(int[] nums) {
	       int prefix = 1;
	       int n=nums.length;
	       int[]answer=new int[n];
	    for (int i = 0; i < n; i++) {
	        answer[i] = prefix;
	        prefix *= nums[i];
	    }

	    // Step 2: Calculate suffix products and update the result
	    int suffix = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        answer[i] *= suffix;
	        suffix *= nums[i];
	    }

	    return answer; 
	    }
	
	

}
