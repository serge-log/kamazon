package com.kenshoo.kamazon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class KamazonApplicationTests {

	@Test
	void contextLoads() {


		Integer[] numbers = {3,9,8,4,5,7,10};
		int target = 15;
		int maxTarget = 20;
		sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target, maxTarget);



	}

	static void sum_up_recursive(ArrayList<Integer> numbers, int target, int maxTarget, ArrayList<Integer> partial) {
		int s = 0;
		for (int x: partial) s += x;
		if (s >= target && s <=maxTarget)
			System.out.println("sum("+ Arrays.toString(partial.toArray())+")= between "+target+" and = "+maxTarget);
		if (s > maxTarget)
			return;
		for(int i=0;i<numbers.size();i++) {
			ArrayList<Integer> remaining = new ArrayList<Integer>();
			int n = numbers.get(i);
			for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
			ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
			partial_rec.add(n);
			sum_up_recursive(remaining,target,maxTarget,partial_rec);
		}
	}
	static void sum_up(ArrayList<Integer> numbers, int target, int maxTarget) {
		sum_up_recursive(numbers,target,maxTarget,new ArrayList<Integer>());
	}

}
