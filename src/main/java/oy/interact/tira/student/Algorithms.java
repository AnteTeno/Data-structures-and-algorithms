package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
     

      int i = 0;
      while(i < array.length && array.length > 0) {
         T current_element = array[i];
         int j = i - 1;

         while(j >= 0 && array[j].compareTo(current_element) > 0) {
            array[j + 1] = array[j];
            j = j - 1;
         }
         array[j + 1] = current_element;
         i = i + 1;
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      
      for(int i = fromIndex + 1; i < toIndex; i++) {
         T current_element = array[i];
         int j = i - 1;

         while(j >= fromIndex && array[j].compareTo(current_element) > 0) {
            array[j + 1] = array[j];
            j = j - 1;
         }
         array[j + 1] = current_element;
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {      
      // TODO: Implement this.

      for(int i = 0; i < array.length; i++) {
         T current_element = array[i];
         int j = i - 1;
         while (j >= 0 && comparator.compare(array[j], current_element) > 0) {
            array[j + 1] = array[j];
            j = j - 1;
         }
         array[j + 1] = current_element;
      }
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for(int i = fromIndex + 1; i < toIndex; i++) {
         T current_element = array[i];
         int j = i - 1;

         while(j >= fromIndex && comparator.compare(array[j], current_element) > 0) {
            array[j + 1] = array[j];
            j = j - 1;
         }
         array[j + 1] = current_element;
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      // TODO: Implement this.

      int left = 0;
      int right = array.length -1;

      while(left < right) {
         T temporary = array[left];
         array[left] = array[right];
         array[right] = temporary;

         right--;
         left++;
      }
   } 

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Implement this.
      int right = toIndex -1;
      for(int left = fromIndex; left < right; left++) {
         T temporary = array[left];
         array[left] = array[right];
         array[right] = temporary;
         right--;
      }
   }


   ///////////////////////////////////////////
   // Recursive binary search bw indices
   ///////////////////////////////////////////

   public enum BSearchImplementation {
      RECURSIVE,
      ITERATIVE
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      
      if (fromIndex < 0 || toIndex > fromArray.length || fromIndex >= toIndex) {
          throw new IllegalArgumentException("Invalid indices");
      }
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex);
  }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, BSearchImplementation impl) {
      if (impl == BSearchImplementation.RECURSIVE) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
      } else if(impl == BSearchImplementation.ITERATIVE) {
         return binarySearchIterative(aValue, fromArray, fromIndex, toIndex - 1);
      }
      // TODO: IF implementing iterative binary search, call that here.
      return -1;
   }

   public static <T extends Comparable<T>> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      if (fromIndex > toIndex) {
          return -1; 
      }
  
      int middle = fromIndex + (toIndex - fromIndex) / 2;
      int comparisonResult = fromArray[middle].compareTo(aValue);
      
      
      if (comparisonResult == 0) {
          return middle; 
      } else if (comparisonResult < 0) {
          return binarySearchRecursive(aValue, fromArray, middle + 1, toIndex);
      } else {
          return binarySearchRecursive(aValue, fromArray, fromIndex, middle);
      }
  }
  

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      while (fromIndex < toIndex) {
          int middle = fromIndex + (toIndex - fromIndex) / 2;
          int comparisonResult = comparator.compare(fromArray[middle], aValue);
  
          if (comparisonResult == 0) {
              return middle;
          } else if (comparisonResult < 0) {
              return binarySearchRecursive(aValue, fromArray, middle + 1, toIndex, comparator); 
          } else {
            binarySearchRecursive(aValue, fromArray, fromIndex, middle, comparator); 
          }
      }
      return -1; 
  }

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, BSearchImplementation impl, Comparator<T> comparator) {
      if (impl == BSearchImplementation.RECURSIVE) {
          return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
      } else if (impl == BSearchImplementation.ITERATIVE) {
          return binarySearchIterative(aValue, fromArray, fromIndex, toIndex - 1, comparator);
      }
      return -1;
   }
   public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      
      if (fromIndex >= toIndex) {
          return -1; 
      }
   
      int middle = fromIndex + (toIndex - fromIndex) / 2;

      int comparisonResult = comparator.compare(fromArray[middle], aValue);
      if (comparisonResult == 0) {
          return middle; 
      } else if (comparisonResult < 0) {
          return binarySearchRecursive(aValue, fromArray, middle + 1, toIndex, comparator);
      } else {
          return binarySearchRecursive(aValue, fromArray, fromIndex, middle, comparator);
      }
  }

   public static <T> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Iterative implementation if grade interests you:

      while(fromIndex <= toIndex) {

         int middle = fromIndex +(toIndex - fromIndex ) / 2;

         int comparisonResult = comparator.compare(fromArray[middle], aValue);

         if(comparisonResult == 0) {
            return middle;
         } else if (comparisonResult > 0) {
            toIndex = middle;
         } else {
            fromIndex = middle + 1;
         }
      }
      return -1;
   }
   public static <T extends Comparable<T>> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      while(fromIndex <= toIndex) {

         int middle = fromIndex +(toIndex - fromIndex ) / 2;

         int comparisonResult = fromArray[middle].compareTo(aValue);

         if(comparisonResult == 0) {
            return middle;
         } else if (comparisonResult > 0) {
            toIndex = middle;
         } else {
            fromIndex = middle + 1;
         }
      }
      return -1;
  }

   public enum FastSortAlgorithm {
      QUICKSORT,
      HEAPSORT,
      MERGESORT
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length, Comparator.naturalOrder(), FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      fastSort(array, fromIndex, toIndex, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            quickSort(array, fromIndex, toIndex - 1, comparator);
            break;
         case HEAPSORT:
            // TODO: IF implementing heapsort, call your algorithm here.
            break;
         case MERGESORT:
            // TODO: IF implementing mergesort, call your algorithm here.
            break;
         default:
            break;
      }
   }


   

   public static <E> int Partition(E[] array, int low, int high, Comparator<E> comparator) {

      E pivot = array[high];
      int i = low-1;
      
      for(int j = low; j <= high -1; j++) {
         if(comparator.compare(array[j], pivot) <= 0) {
            i++;
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
         }
      }

      E temp = array[i + 1];
      array[i + 1] = array[high];
      array[high] = temp;
      
      return i + 1;
   }

   public static <E> void quickSort(E[] array, int low, int high, Comparator<E> comparator) {
      if(low < high) {
         int pivot = Partition(array, low, high, comparator);
         quickSort(array, low, pivot - 1, comparator);
         quickSort(array, pivot+1, high, comparator);
      }
   }
} // End of class Algorithms
