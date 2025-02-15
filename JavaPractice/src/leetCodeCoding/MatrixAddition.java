package leetCodeCoding;

public class MatrixAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
		int a[][]={{1,3,4},{2,4,3},{3,4,5}};    
		int b[][]={{1,3,4},{2,4,3},{1,2,4}};
		int sum[][]=new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				sum[i][j]=a[i][j]+b[i][j];
			//	System.out.println(sum[i][j] +" ");
				
			}
		//	System.out.println();
		}
		}
		{
			int a [][]= {{1,1},{2,2}};
			int b[][]= {{1,1},{2,2}};
			int product[][]=new int [2][2];
			for(int i=0;i<2;i++) {
				
				for(int j=0;j<2;j++) {
					product[i][j]=0;
					for(int k=0;k<2;k++) {
					product[i][j]+=a[i][k]*b[k][i];
					}
					System.out.println(product[i][j] +" ");
				}
				System.out.println();
			}
		}

	}

}
