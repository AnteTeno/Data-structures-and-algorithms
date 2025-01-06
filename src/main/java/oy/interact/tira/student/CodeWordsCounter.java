package oy.interact.tira.student;

import java.io.File;
import java.io.IOException;
import static java.lang.Character.isLetter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import oy.interact.tira.factories.HashTableFactory;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.util.Comparator;

// Teachers: TODO: Decide what here is left for the students to implement.
// E.g. forming the words based on rules.

public class CodeWordsCounter {

	private TIRAKeyedContainer<String, Integer> codeWords;

	public long cumulativeTimeInMilliseconds;

	private static final int MAX_WORD_SIZE = 4096;
	private static final String FILE_TYPES_TO_INCLUDE = "glob:*.{c,h,cc,cpp,hpp,cs,java,swift,py,html,css,js,ts,xml,json}";
	
	public CodeWordsCounter() {
		codeWords = HashTableFactory.createHashTable();
	}

	public void countWordsinSourceCodeFiles(File inDirectory) throws IOException {

		if (null == codeWords) {
			System.out.println("No implementation for hashtable, doing nothing.");
			return;
		}
		cumulativeTimeInMilliseconds = 0;
		System.out.println("Started counting, please wait...");

		Files.walkFileTree(inDirectory.toPath(), new SimpleFileVisitor<Path>() {
			PathMatcher matcher = FileSystems.getDefault().getPathMatcher(FILE_TYPES_TO_INCLUDE);

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				if (file != null && matcher.matches(file.getFileName())) {
					try {
						countWordsFrom(file.toFile());
					} catch (OutOfMemoryError | IOException e) {
						e.printStackTrace();
						return FileVisitResult.TERMINATE;
					}
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException e) {
				return FileVisitResult.CONTINUE;
			}

		});
	}

	private void countWordsFrom(File file) throws OutOfMemoryError, IOException {
		String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		// Characters of a single word as Unicode codepoints.
		int [] wordChars = new int[MAX_WORD_SIZE];
		// Index used to fill wordChars array from the string in the file.
		int codeWordIndex = 0;
		System.out.println("File: " + file.getAbsolutePath());
		long start = System.currentTimeMillis();
		for (int index = 0; index < content.length(); index++) {
			char point = Character.toLowerCase(content.charAt(index));
		
			// Point is a letter, so continue the word
			if (isLetter(point)) {
				wordChars[codeWordIndex++] = point;
				continue;
			}
		
			// Word is rational
			if (codeWordIndex > 2) {
				String str = wordToString(wordChars);
		
				// Word is not added to hashtable yet
				if (codeWords.get(str) == null) {
					codeWords.add(str, 1);
				}
				// Word is already added to hashtable, so increase the count of the word
				else {
					int count = codeWords.get(str);
					codeWords.add(str, count + 1);
				}
			}
		
			// Reset count and array of word
			codeWordIndex = 0;
			wordChars = new int[MAX_WORD_SIZE];
		}
		
		cumulativeTimeInMilliseconds += System.currentTimeMillis() - start;
	}

	@SuppressWarnings("unchecked")
	public Pair<String, Integer>[] topCodeWords(int topCount) throws Exception {
		
		if (null == codeWords) {
			Pair<String, Integer>[] result = new Pair[1];	
			result[0] = new Pair<>("Hashtable not implemented yet", 0);
			return result;
		}
		// Create word array in descending order
		Pair<String, Integer>[] words = codeWords.toArray();
		quickSort(words, 0, words.length - 1);
		Algorithms.reverse(words);

		// Set topCount to be smaller or equal to codeWord size
		if (codeWords.size() < topCount) {
			topCount = codeWords.size();
		}

		Pair<String, Integer>[] topWords = new Pair[topCount];

		// Get top words of the words array
		for (int i = 0; i < topCount; i++) {
			topWords[i] = words[i];
		}

		return topWords;

		}



		public static <E> int Partition(Pair<String, Integer>[] array, int low, int high) {

			Integer pivot = array[high].getValue();
			int i = low-1;
			
			for(int j = low; j <= high -1; j++) {
			   if(array[j].getValue() <= pivot) {
				  i++;
				  Pair<String, Integer> temp = array[i];
				  array[i] = array[j];
				  array[j] = temp;
			   }
			}
	  
			Pair<String, Integer> temp = array[i + 1];
			array[i + 1] = array[high];
			array[high] = temp;
			
			return i + 1;
		 }
	  
		 public static <E> void quickSort(Pair<String, Integer>[] array, int low, int high) {
			if(low < high) {
			   int pivot = Partition(array, low, high);
			   quickSort(array, low, pivot - 1);
			   quickSort(array, pivot+1, high);
			}
		 }

		 private String wordToString(int[] word) {
			StringBuilder str = new StringBuilder();
	
			for (int character: word) {
	
				// Break the loop if character is not letter
				if (!isLetter((char) character)) {
					break;
				}
	
				// Add the letter to string
				str.append((char)character);
			}
	
			return str.toString();
		}
	


}
