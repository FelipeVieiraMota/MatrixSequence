package com.mota.felipe;

import com.mota.felipe.service.AppService;
import com.mota.felipe.util.Util;

public class App {

  public static void main(String[] args) throws Exception {
      new App().process(args);
  }

  public String process(String[] args) throws Exception {
    var matrixObject = Util.stringListToMatrixObject(args);
    var matrix = matrixObject.getMatrix();
    var maxRows = matrixObject.getMaxRows();
    var maxColumns = matrixObject.getMaxColumns();
    var outPut = new AppService().findLongest(matrix, maxRows,maxColumns);
    System.out.println(outPut);
    return outPut;
  }
}
