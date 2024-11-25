package oy.interact.tira.grade_2.task_3;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.student.Algorithms;
import oy.interact.tira.student.Algorithms.BSearchImplementation;
import oy.interact.tira.util.SimpleContainer;
import oy.interact.tira.util.TIRAContainer;

class BinarySearchIterDescendingOrderTests {

	static String searchResult;
	static int foundIndex;
	static final String[] hardCodedElements = { "Programming, one those little joys in life",
			"SimpleContainer",
			"All the code words",
			"I prefer binary search trees to SimpleContainers",
			"I prefer debugging to mindless hacking",
			"Inter cactus",
			"TIRA course, the trip everybody wants to join",
			"Juunivaersitus of Olutensis",
			"Reverse that array!",
			"Environment variables, those pesky beasts",
			"Reading a programming book on the beach",
			"Unit testing, better than beer!",
			"Sorting is fun!",
			"Hello World!",
			"Those lovely arrays!",
			"My god, it's full of stars!" };

	@Test
	@DisplayName("Iterative binary search test")
	// @Timeout(value = 30, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	@Order(1)
	void testBinarySearchWithStrings() {
		SimpleContainer<String> container = new SimpleContainer<>(String.class);
		assertDoesNotThrow(() -> fillContainer(container, 1000), () -> "Adding to SimpleContainer should not throw");
		assertDoesNotThrow(() -> container.add("Something something"),
				() -> "Adding to SimpleContainer should not throw");

		Comparator<String> comparator = new Comparator<>() {
			@Override
			public int compare(String first, String second) {
				return second.compareTo(first);
			}
		};
		assertDoesNotThrow(() -> container.sort(comparator),
				"Sorting the SimpleContainer with comparator must not throw");

		// Doing the search on the array directly since SimpleContainer does not allow
		// choosing which binary search to use in indexOf.
		String [] array = container.toArray();

		assertDoesNotThrow(() -> foundIndex = Algorithms.binarySearch("Something something", 
															array, 
															0, 
															array.length, 
															comparator, 
															BSearchImplementation.ITERATIVE), "Must not throw when doing binary search");
		assertNotEquals(-1, foundIndex, "Must find the test string put in the container");
		assertTrue((foundIndex >= 0 && foundIndex < container.size()),
				"The returned index must be >= 0 && < container.size()");
		assertEquals("Something something", array[foundIndex], "Element in index found using binary search must match the one searched for.");

		assertDoesNotThrow(() -> foundIndex = Algorithms.binarySearch("A string surely not in the container", 
				array, 
				0, 
				array.length, 
				comparator, 
				BSearchImplementation.ITERATIVE), "Must not throw when doing binary search");

		assertEquals(-1, foundIndex, "The string to find is not in container, so binary search must return -1");
	}

	@Test
	@Order(2)
	@DisplayName("Time performance of iterative binary search test")
	// @Timeout(value = 120, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void testTimePerformanceOfBinarySearch() {
		System.out.println("Time performance tests of filling, sorting (desc) and binary searching (iterative)");
		System.out.println("Fill time is in milliseconds, and search time in microseconds");
		System.out.println("n\tFill\tSort\tSearch\tTotal");
		for (int size = 1_000; size <= 16_000; size += 1_000) {
			final int currentSize = size;
			SimpleContainer<String> container = new SimpleContainer<>(String.class);
			long start = System.currentTimeMillis();
			assertDoesNotThrow(() -> fillContainer(container, currentSize),
					() -> "Adding to SimpleContainer should not throw");
			long fillDuration = System.currentTimeMillis() - start;

			Comparator<String> comparator = new Comparator<>() {
				@Override
				public int compare(String first, String second) {
					return second.compareTo(first);
				}
			};
			start = System.currentTimeMillis();
			assertDoesNotThrow(() -> container.sort(comparator),
				"Sorting the SimpleContainer with comparator must not throw");
			long sortDuration = System.currentTimeMillis() - start;

			// Doing the search on the array directly since SimpleContainer does not allow
			// choosing which binary search to use in indexOf.
			String [] array = container.toArray();

			start = System.nanoTime();
			for (int index = 0; index < hardCodedElements.length; index++) {
				final int currentIndex = index;


				assertDoesNotThrow(() -> foundIndex = Algorithms.binarySearch(hardCodedElements[currentIndex], 
																		array, 
																		0, 
																		array.length, 
																		comparator, 
																		BSearchImplementation.ITERATIVE), "Must not throw when doing binary search");

				assertNotEquals(-1, foundIndex, "Must find the test string put in the container");
				assertTrue((foundIndex >= 0 && foundIndex < array.length),
						"The returned index must be >= 0 && < container.size()");
				assertEquals(hardCodedElements[currentIndex], array[foundIndex], "Element in index found using binary search must match the one searched for.");																
			}
			long searchDuration = (System.nanoTime() - start) / 1000;
			System.out.format("%d\t%d\t%d\t%d\t%d%n", currentSize, fillDuration, sortDuration, searchDuration, fillDuration+sortDuration+(searchDuration/1000));
		}
		System.out.println("\nDone!");
	}

	private void fillContainer(TIRAContainer<String> container, int size) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		final Random random = new Random();
		int hardCodedElementIndex = 0;

		for (int i = 0; i < size; i++) {
			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(number -> (number <= 57 || number >= 65) && (number <= 90 || number >= 97))
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();
			container.add(generatedString);
			if (i > ((size / 3) * 2) && hardCodedElementIndex < hardCodedElements.length) {
				if (random.nextInt(42) % 5 == 0) {
					container.add(hardCodedElements[hardCodedElementIndex++]);
				}
			}
		}
		while (hardCodedElementIndex < hardCodedElements.length) {
			container.add(hardCodedElements[hardCodedElementIndex++]);
		}
	}

}
