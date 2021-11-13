package com.mota.felipe.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Matrix {
  private int maxRows;
  private int maxColumns;
  private int [][] matrix;
}
