package dev.ianbunag.java_kata.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Challenge solution.
 */
public class N3PickPeaks {
  private N3PickPeaks() { }

  /**
   * Positions key.
   */
  private static final String POSITIONS = "pos";

  /**
   * Peaks key.
   */
  private static final String PEAKS = "peaks";

  /**
   * Challenge solution.
   * <ul>
   *  <li>Average time complexity: O(n)
   *  <li>Worst time complexity:   O(n)
   *  <li>Space complexity:        O(n log n)
   * </ul>
   *
   * @param arr array to determine peaks from.
   * @return map of positions and peaks.
   */
  public static Map<String, List<Integer>> getPeaks(int[] arr) {
    var result = new HashMap<String, List<Integer>>();
    var plateauPosition = -1;

    result.put(N3PickPeaks.POSITIONS, new ArrayList<Integer>());
    result.put(N3PickPeaks.PEAKS, new ArrayList<Integer>());

    for (int position = 1; position < arr.length - 1; position += 1) {
      var before = arr[position - 1];
      var current = arr[position];
      var after = arr[position + 1];

      if (before < current) {
        plateauPosition = position;
      }
      if (
          plateauPosition == -1
          || current != arr[plateauPosition]
          || before > current || current <= after
      ) {
        continue;
      }


      result.get(N3PickPeaks.POSITIONS).add(plateauPosition);
      result.get(N3PickPeaks.PEAKS).add(arr[plateauPosition]);
    }

    return result;
  }
}
