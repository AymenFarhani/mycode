package com.example;

import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		IntStream.range(1, 1000).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Plain Stream : " + (end - start));
		
		System.out.println("==================");
		
		start = System.currentTimeMillis();
		IntStream.range(1, 1000).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel Stream : " + (end - start));
		
	}

}
