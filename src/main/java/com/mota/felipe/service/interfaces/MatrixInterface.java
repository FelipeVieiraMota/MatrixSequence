package com.mota.felipe.service.interfaces;

import java.util.Map;

public interface MatrixInterface {
  /**
   *
   * @param matrix
   * @param maxRows
   * @param maxColumns
   * @return
   */
  String findLongest(int[][] matrix, int maxRows, int maxColumns);

  /**
   *
   * @param matrix
   * @param row
   * @param column
   * @param hash
   * @param maxRows
   * @param maxColumns
   * @return
   */
  String process(int[][] matrix, int row, int column, Map<String, String> hash, int maxRows, int maxColumns);

  /**
   *
   * @param hash
   * @param uniqueKey
   * @param value
   * @return
   */
  default Map<String, String> createPath(Map<String, String> hash, String uniqueKey, String value){
    hash.put(uniqueKey, value);
    return hash;
  }

  /**
   *
   * @param cell
   * @param index
   * @param maxRows
   * @param maxColumns
   * @return
   */
  default boolean isValid(int cell, int index, int maxRows, int maxColumns) {
    return (cell >= 0 && cell < maxRows) && (index >= 0 && index < maxColumns);
  }
}
