package oy.interact.tira.grade_1.task_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import oy.interact.tira.student.Algorithms;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

@DisplayName("Testing Algorithms.insertionSort with custom class")
public class InsertionSortCustomClassTests {

    private static final int COLOR_COUNT = 21;

    @Test
    @DisplayName("Testing sorting colors by color temperature, from warm to cool colors")
    void testColorSortingOrder() {
        SimpleColor [] colors = new SimpleColor[COLOR_COUNT];
        final SimpleColor.Colors [] COLOR_VALUES = SimpleColor.Colors.values();

        for (int counter = 0; counter < COLOR_COUNT; counter++) {
            colors[counter] = new SimpleColor(COLOR_VALUES[ThreadLocalRandom.current().nextInt(COLOR_VALUES.length)]);
        }
        System.out.format("%d colors in random order:%n", COLOR_COUNT);
        for (SimpleColor color : colors) {
            System.out.println(color);
        }

        assertDoesNotThrow(() -> Algorithms.insertionSort(colors), "Algorithms.insertionSort must not throw");

        SimpleColor [] verifiedArray = Arrays.copyOf(colors, colors.length);
        Arrays.sort(verifiedArray);

        System.out.format("%n%d colors sorted in temperature order using Algorithms.insertionSort:%n", COLOR_COUNT);
        for (SimpleColor color : colors) {
            System.out.println(color);
        }
        boolean arraysAreEqual = Arrays.equals(verifiedArray, colors);

        if (!arraysAreEqual) {
            System.out.println("\nAlgorithms.insertionSort is WRONG. CORRECT order is:");
            for (SimpleColor color : verifiedArray) {
                System.out.println(color);
            }    
        }
        assertTrue(arraysAreEqual, "Your insertionSort order must match correct sort order for colors.");
    }
}
