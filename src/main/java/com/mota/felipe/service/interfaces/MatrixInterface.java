package com.mota.felipe.service.interfaces;

import java.util.Map;

public interface MatrixInterface {

  /**
   *
   * @param matrix - matrix to process
   * @param maxRows - max rows of a matrix
   * @param maxColumns max columns of a matrix
   * @return - Desired sequence
   */
  String findLongest(int[][] matrix, int maxRows, int maxColumns);

  /**
   *
   * @param matrix - matrix to process
   * @param row - current row
   * @param column - current column
   * @param hash - hash where we save or sequence
   * @param maxRows - max rows of the matrix
   * @param maxColumns - max columns of the matrix
   * @return - Desired sequence
   */
  String process(int[][] matrix, int row, int column, Map<String, String> hash, int maxRows, int maxColumns);

  /**
   *
   * @param hash - hash variable where we will save our key and value.
   * @param uniqueKey - key
   * @param value - value
   * @return
   */
  default Map<String, String> createPath(Map<String, String> hash, String uniqueKey, String value){
    hash.put(uniqueKey, value);
    return hash;
  }

  /**
   *
   * @param row - current row
   * @param column - current column
   * @param maxRows - max rows
   * @param maxColumns - max columns
   * @return - true or false
   */
  default boolean isValid(int row, int column, int maxRows, int maxColumns) {
    return (row >= 0 && row < maxRows) && (column >= 0 && column < maxColumns);
  }
}
