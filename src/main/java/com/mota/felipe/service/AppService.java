package com.mota.felipe.service;

import com.mota.felipe.service.interfaces.MatrixInterface;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class AppService implements MatrixInterface {

  private String find;
  private String path;
  private String finalPath;

  public String findLongest(int[][] matrix, int maxRows, int maxColumns) {

    Map<String, String> hash = new HashMap<>();
    long minValue = Long.MIN_VALUE;
    long size = 0;

    for (int row = 0; row < maxRows; row++) {
      for (int column = 0; column < maxColumns; column++) {

        find = process(matrix, row, column, hash, maxRows, maxColumns);

        if (find != null)  size = find.chars().filter(ch -> ch == ',').count();

        if (size > minValue) {
          finalPath = find;
          minValue = size;
        }
      }
    }
    return finalPath;
  }

  public String process( int[][] matrix, int row, int column, Map<String, String> hash, int maxRows, int maxColumns) {

    if (!isValid(row, column, maxRows, maxColumns))
      return null;

    String uniqueKey = row + "|" + column;

    if (hash.containsKey(uniqueKey)) return hash.get(uniqueKey);

    this.path = null;

    if (row > 0 && matrix[row - 1][column] - matrix[row][column] == 1)
      this.path = process(matrix, row - 1, column, hash, maxRows, maxColumns);

    if (column + 1 < maxColumns && matrix[row][column + 1] - matrix[row][column] == 1)
      this.path = process(matrix, row, column + 1, hash, maxRows, maxColumns);

    if (row + 1 < maxRows && matrix[row + 1][column] - matrix[row][column] == 1)
      this.path = process(matrix, row + 1, column, hash, maxRows, maxColumns);

    if (column > 0 && matrix[row][column - 1] - matrix[row][column] == 1)
      this.path = process(matrix, row, column - 1, hash, maxRows, maxColumns);

    if (this.path != null) {
      hash = this.createPath(hash, uniqueKey, matrix[row][column] + ", " + this.path);
    } else {
      hash = this.createPath(hash, uniqueKey, String.valueOf(matrix[row][column]));
    }
    return hash.get(uniqueKey);
  }
}
