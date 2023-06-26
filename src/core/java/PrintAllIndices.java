package core.java;

public class PrintAllIndices {

	public static void main(String[] args) {
//      int[] array = {2, 4, 1, 5, 6, 3, 7, 8};
      int[] array = {1, 4, 2, 7, 8, 3, 5, 6};
      PrintAllIndices printAllIndices = new PrintAllIndices();
      printAllIndices.printAllIndices1(array);
  }

  void printAllIndices(int[] array) {
      int sum;
      for (int i = 0; i < array.length; i++) {
          for (int j = i + 1; j < array.length; j++) {
              sum = array[i] + array[j];
              for (int k = 0; k < array.length; k++) {
                  if (array[k] == sum) {
                      System.out.println(i + "," + j + "," + k);
                  }
              }
          }
      }
  }
  
  void printAllIndices1(int[] array) {
      int sum;
      for (int i = 0; i < array.length; i++) {
          for (int j = i + 1; j < array.length; j++) {
              sum = array[i] + array[j];
              for (int k = 0; k < array.length; k++) {
                  if (array[k] == sum) {
                      System.out.println(i + "," + j + "," + k);
                  }
              }
          }
      }
  }
}
