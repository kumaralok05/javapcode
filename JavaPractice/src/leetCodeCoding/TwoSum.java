package leetCodeCoding;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,4,3,5};
		int target=5;
		int n=arr.length;
		{
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++)
					if (arr[i] + arr[j] == target) {
						//System.out.println(arr[i] + "," + arr[j]);
					}
			}
		}
		{
			int start = 0, end = n - 1;
			while (start < end) {
			    int pairSum = arr[start] + arr[end];
			    if (pairSum > target) {
			        end--;    
			    } else if (pairSum < target) {
			        start++;  
			    } else {
			        System.out.println(arr[start] + ", " + arr[end]);
			        start++;  // Move start pointer after finding a pair
			        end--;    // Move end pointer after finding a pair
			    }
			}
			
		}
		
		
		

	}

}
