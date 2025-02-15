import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java8Coding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		{
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
      list.stream().filter(i->i%2==0).forEach(System.out::println);
		}
      //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		{
			List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
			list.stream().map(n -> n + "").filter(n -> n.startsWith("1")).forEach(System.out::println);
		}
		{
			//How to find duplicate elements in a given integers list in java using Stream functions?
			List<Integer> list = Arrays.asList(10,15,8,49,15,98,32);
			Set<Integer>hashSet=new HashSet();
			list.stream().filter(n -> !hashSet.add(n)).forEach(System.out::println);
		}
	//	Given the list of integers, find the first element of the list using Stream functions?
		{
			List<Integer> list = Arrays.asList(10,15,8,49,15,98,32);
			System.out.println("first element");
			list.stream().findFirst().ifPresent(System.out::println);
		}
	//	Given a list of integers, find the total number of elements present in the list using Stream functions?
		{
			List<Integer> list = Arrays.asList(10,15,8,49,15,98,32);
			System.out.println("total element");
			long count=list.stream().count();
			System.out.println(count);
			
		}
		// Given a list of integers, find the maximum value element present in it using Stream functions?
		{
			List<Integer> list = Arrays.asList(10,15,8,49,15,98,32);
			System.out.println("Max element");	
			int max=list.stream().max(Comparator.naturalOrder()).get();
			System.out.println(max);
		}
	//	Given a String, find the first non-repeated character in it using Stream functions?
		String input = "Java articles are Awesome";
		
		}

	}


