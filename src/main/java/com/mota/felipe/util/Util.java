package com.mota.felipe.util;

import com.mota.felipe.domain.vo.Matrix;

import java.util.Arrays;

public class Util {

  public static void showMatrix(int[][] matrix, int maxRow, int maxColumn){
    System.out.println("");
    System.out.println("");
    System.out.println(" "+maxRow +" "+maxColumn);

    var lineBreaker = 0;

    for (int row = 0; row<= maxRow-1; row++)
    {
      for (int column = 0; column<= maxColumn-1; column++)
      {
        if (lineBreaker > maxColumn-1) lineBreaker = 0;

        if ( lineBreaker < maxColumn-1 )
        {
          System.out.print(" " + matrix [row][column]);
        }
        else
        {
          System.out.println(" " + matrix [row][column]);
        }
        lineBreaker++;
      }
    }
  }

  public static Matrix stringListToMatrixObject(String []  args) throws Exception{

    if (args.length == 0){
      var matrix = new int [0][0];
      return new Matrix( 0,0, matrix);
    }

    var integerList =
      Arrays
        .stream(args)
        .map( arg -> arg.replace(" ", "") )
        .mapToInt( arg -> Integer.parseInt(arg) )
        .toArray();

    var listSize = integerList.length;

    var maxColumn = integerList[1];

    var maxRow = integerList[0];

    var multiply = maxColumn * maxRow;

    if ((listSize-2) != multiply)
        throw new Exception(" You must need respect matrix sorted = "+ integerList[0]+" x "+integerList[1] +" != "+multiply);

    int []  cleanList = new int [integerList.length-2];

    var counter = 0;

    for ( int index = 2; index < integerList.length; index ++){
        cleanList[counter] =  integerList[index];
        counter++;
    }

    counter = 0;

    var lineBreaker = 0;

    var matrix = new int [maxRow][maxColumn];

    System.out.println("");
    System.out.println("");
    System.out.println(" "+maxRow +" "+maxColumn);

    for (int row = 0; row<= maxRow-1; row++)
    {
      for (int column = 0; column<= maxColumn-1; column++)
      {
        if (lineBreaker > maxColumn-1) lineBreaker = 0;

        if ( lineBreaker < maxColumn-1 )
        {
          matrix [row][column] = cleanList[counter];
          System.out.print(" " + matrix [row][column]);
        }
        else
        {
          matrix [row][column] = cleanList[counter];
          System.out.println(" " + matrix [row][column]);
        }
        counter++;
        lineBreaker++;
      }
    }

    return new Matrix(maxRow, maxColumn, matrix);
  }
}
