package leetCodeCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayChunk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int chunkSize=5;
		int totalChunks = (int) Math.ceil((double) list.size() / chunkSize); // Calculate total chunks
		//so for us 50/2 so total 25 should be printed;

        for (int i = 0; i < totalChunks; i++) {
            System.out.println("page " + (i + 1) + ":");

            // Get the start and end indexes for the current chunk
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, list.size()); // Avoid index out of bounds

            // Store chunk data in a variable
            List<Integer> chunk = new ArrayList<>();
            for (int j = start; j < end; j++) {
                chunk.add(list.get(j));
            }

            // Print chunk data
            System.out.println(chunk);
        }

	}

}
