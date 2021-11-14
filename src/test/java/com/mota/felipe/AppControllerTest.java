package com.mota.felipe;

import com.mota.felipe.service.AppService;
import com.mota.felipe.service.interfaces.MatrixInterface;
import com.mota.felipe.util.Util;
import org.junit.Assert;
import org.junit.Test;

public class AppControllerTest
{

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C3xR3_Matrix_By_MainMethod_withSpace()
      throws Exception {

        String [] args =
          new String[] { "3 ","3 ", "5 ", "8 ", "7 ", "6 ", "9 ", "1 ", "4 ", "3 ", "2 "};

        var longest = new AppController().process(args);
        Assert.assertEquals("1, 2, 3, 4", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C3xR3_Matrix_By_MainMethod_withoutSpace()
      throws Exception {

        String [] args =
          new String[] { "3","3", "5", "8", "7", "6", "9", "1", "4", "3", "2"};

        var longest = new AppController().process(args);
        Assert.assertEquals("1, 2, 3, 4", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C3xR3_Matrix(){
        MatrixInterface service = new AppService();
        var matrix = new int[][] {
          {5, 8, 7},
          {6, 9, 1},
          {4, 3, 2}
        };
        Util.showMatrix(matrix, 3, 3);
        String longest = service.findLongest(matrix,3,3);
        System.out.println(" "+longest);
        Assert.assertEquals("1, 2, 3, 4", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted__C2xR2_Matrix(){
        MatrixInterface service = new AppService();
        var matrix = new int[][] {
          {5, 8},
          {6, 9}
        };
        Util.showMatrix(matrix,2,2);
        String longest = service.findLongest(matrix,2,2);
        System.out.println(" "+longest);
        Assert.assertEquals("5, 6", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C5xR5_Matrix(){
        MatrixInterface service = new AppService();
        var matrix = new int[][] {
          { 10, 13, 14, 21, 23 },
          { 11, 10, 22, 2, 3 },
          { 12, 9, 1, 5, 4 },
          { 15, 8, 7, 6, 20 },
          { 16, 17, 18, 19, 25}
        };
        Util.showMatrix(matrix,5,5);
        String longest = service.findLongest(matrix,5,5);
        System.out.println(" "+longest);
        Assert.assertEquals("2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C3xR4_Matrix(){
        MatrixInterface service = new AppService();
        var matrix = new int[][] {
          {   9,   8,   7,  6  },
          {  21,  60,  12,  5  },
          {   1,   2,   3,  4  }
        };

        Util.showMatrix(matrix,3,4);
        String longest = service.findLongest(matrix,3,4);
        System.out.println(" "+longest);
        Assert.assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_C3xR4_Matrix_By_String_Args()
      throws Exception {

        String [] args =
          new String[] { "3", "4", "9", "8", "7", "6", "21", "60", "12", "5", "1", "2", "3", "4" };

        var longest = new AppController().process(args);
        Assert.assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9", longest);
    }
}
