package leetCodeCoding;

 public  class TestForAll {
	 public static int[] addTwoNumbers(int[] l1, int[] l2) {
	       // int[] reverse1=l1.reverse();
	       // int[] reverse2=l2.reverse();
	        int sum[]=new int[3];
	        for(int i=l1.length-1;i>=0;i--){
	           
	           sum[i]= l1[i]+l2[i];
	            
	        }
	        return sum;
	        
	    }
	    
	    public static void main(String[] args) {
	       int[] l1={2,4,3};
	       int[] l2={5,6,4};
	    //   TestForAll main=new TestForAll();
	     int []result=TestForAll.addTwoNumbers(l1,l2);
	     for(int i:result)
	       System.out.println(i);
	        
	        System.out.println("Try programiz.pro");
	    }

	

}
