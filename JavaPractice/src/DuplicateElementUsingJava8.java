 // How to find duplicate elements in a given integers list in java using Stream functions?

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementUsingJava8 {
	public static void main(String[]args) {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
	//	myList.stream().distinct().forEach(i -> System.out.println(i));
		Set<Integer>hashSet=new HashSet();
		myList.stream().filter(n -> !hashSet.add(n)).forEach(System.out::println);
	//	System.out.println(myList);
		
	}

}
