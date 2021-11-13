package com.mota.felipe;

import java.util.HashMap;
import java.util.Map;

public class App {

  private String find;
  private String path;
  private String finalPath;

  // cell = linha
  // index = coluna

  public String findLongest(int[][] matrix, int maxRows, int maxColumns) {

    Map<String, String> hash = new HashMap<>();
    long minValue = Long.MIN_VALUE;
    long size = 0;

      for (int row = 0; row < maxRows; row++) {
        for (int column = 0; column < maxColumns; column++) {

          find = find(matrix, row, column, hash, maxRows, maxColumns);

          if (find != null)  size = find.chars().filter(ch -> ch == ',').count();

          if (size > minValue) {
            finalPath = find;
            minValue = size;
          }
      }
    }
    return finalPath;
  }

  private String find(
    int[][] matrix,
    int row,
    int column,
    Map<String, String> hash,
    int maxRows,
    int maxColumns) {

    if (!isValid(row, column, maxRows, maxColumns))
      return null;

    String uniqueKey = row + "|" + column;

    if (hash.containsKey(uniqueKey)) return hash.get(uniqueKey);

    this.path = null;

    if (row > 0 && matrix[row - 1][column] - matrix[row][column] == 1)
        this.path = find(matrix, row - 1, column, hash, maxRows, maxColumns);

    if (column + 1 < maxColumns && matrix[row][column + 1] - matrix[row][column] == 1)
      this.path = find(matrix, row, column + 1, hash, maxRows, maxColumns);

    if (row + 1 < maxRows && matrix[row + 1][column] - matrix[row][column] == 1)
      this.path = find(matrix, row + 1, column, hash, maxRows, maxColumns);

    if (column > 0 && matrix[row][column - 1] - matrix[row][column] == 1)
      this.path = find(matrix, row, column - 1, hash, maxRows, maxColumns);

    if (this.path != null) {
      hash = this.createPath(hash, uniqueKey, matrix[row][column] + ", " + this.path);
    } else {
      hash = this.createPath(hash, uniqueKey, String.valueOf(matrix[row][column]));
    }
    return hash.get(uniqueKey);
  }

  private Map<String, String> createPath(Map<String, String> hash, String uniqueKey, String value) {
    hash.put(uniqueKey, value);
    return hash;
  }

  private boolean isValid(int cell, int index, int maxRows, int maxColumns) {
    return (cell >= 0 && cell < maxRows) && (index >= 0 && index < maxColumns);
  }
}
