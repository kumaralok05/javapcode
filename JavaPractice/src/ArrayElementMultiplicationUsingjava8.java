import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArrayElementMultiplicationUsingjava8 {
	public static void main(String[]args) {
	int[] inputArray= {1,2,3,4,5};
	int result = Arrays.stream(inputArray)
            .reduce(1, (a, b) -> a * b); 
	System.out.println(result);
	
	}

}
