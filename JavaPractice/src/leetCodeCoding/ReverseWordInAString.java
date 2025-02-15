package leetCodeCoding;

public class ReverseWordInAString {
	public static void main(String[] args) {
		String s="the   sky is blue   ";
		String[] words=s.split("\\s+");
		
		int left=0,right=words.length-1;
		
		while(left<right) {
			String temp= words[left];
			words[left]=words[right];
			words[right]=temp;
			left++;
			right--;
		}
		System.out.println(String.join(" ", words));
		
		
		
//		char ch[]=s.toCharArray();
//		char result;
//	
//	for(int i=ch.length-1;i>=0;i--) {
//		result= ch[i];
//		System.out.print(result);
//	}
	
		//reverseWord(s);
//	}
//	public static String reverseWord(String s) {
//	char ch[]=s.toCharArray();
//		char result;
//	
//	for(int i=ch.length;i>0;i--) {
//		result= ch[i];
//	}
//	
//		
//		return str;
//		
//	}
	}

}
