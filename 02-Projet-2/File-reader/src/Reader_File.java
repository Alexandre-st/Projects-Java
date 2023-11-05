import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Reader_File {
  File file;

  public Reader_File(String filename) {
    this.file = new File(filename);
  }

  public void readerFile() {
    try {
      FileInputStream in = new FileInputStream(file);

      int i = in.read();

      while (i != -1) {
        System.out.println((char) i);
        i = in.read();
      }

      in.close();

    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  public void readerFileInLine() {
    try {
      FileInputStream in = new FileInputStream(file);

      Scanner scanner = new Scanner(file);

      while (scanner.hasNext()) {
        String word = scanner.next();
        System.out.print(word + " ");
      }
      scanner.close();
      in.close();
    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  public void readerFileInReverse() {
    try {
      FileInputStream in = new FileInputStream(file);

      Scanner scanner = new Scanner(in);

      String line = scanner.nextLine();

      String[] arr = line.split("\\s");

      String newLine = "";

      for (int i = arr.length - 1; i >= 0; i--) {
        newLine = newLine + arr[i] + ' ';
      }

      System.out.println(newLine);
      scanner.close();
      in.close();
    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  public void readerFileInPalindrome() {
    try {
      FileInputStream in = new FileInputStream(file);

      Scanner scanner = new Scanner(in);

      String line = scanner.nextLine();

      char[] arr = line.toCharArray();

      String reversed = "";

      for (int i = arr.length - 1; i >= 0; i--) {
        reversed += arr[i];
      }

      System.out.println(reversed);
      scanner.close();
      in.close();
    } catch (IOException e) {
      e.getStackTrace();
    }
  }
}