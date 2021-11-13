package com.mota.felipe;

import org.junit.Assert;
import org.junit.Test;

public class AppTest
{
    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted(){
        App sequenceSearch = new App();
        String longest = sequenceSearch.findLongest(new int[][] {
          {5, 8, 7},
          {6, 9, 1},
          {4, 3, 2}
        },3,3);
        Assert.assertEquals("1, 2, 3, 4", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_3(){
        App sequenceSearch = new App();
        String longest = sequenceSearch.findLongest(new int[][] {
          {5, 8},
          {6, 9}
        },2,2);
        Assert.assertEquals("5, 6", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_2(){
        App sequenceSearch = new App();
        String longest = sequenceSearch.findLongest(new int[][] {
          { 10, 13, 14, 21, 23 },
          { 11, 10, 22, 2, 3 },
          { 12, 9, 1, 5, 4 },
          { 15, 8, 7, 6, 20 },
          { 16, 17, 18, 19, 25}
          },5,5);
        Assert.assertEquals("2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12", longest);
    }

    @Test
    public void shouldFindTheLongestSequenceOfValuesSorted_4(){
        App sequenceSearch = new App();
        String longest = sequenceSearch.findLongest(new int[][] {
          {   9,   8,   7,  6  },
          {  21,  60,  12,  5  },
          {   1,   2,   3,  4  }
        },3,4);
        Assert.assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9", longest);
    }
}
