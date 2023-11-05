import java.io.IOException;

public class FileReaderMain {
  public static void main(String[] args) throws IOException {
    // Lui passer l'url du fichier qu'on veut lire.
    Reader_File file = new Reader_File(
        "/Users/alexandresaint-prix/Developer/JAVA-Projects/02-Projet-2/File-reader/notes.txt");

    System.out.println("---Lecture du fichier---");
    file.readerFile();
    System.out.println("---Lecture du fichier en ligne---");
    file.readerFileInLine();
    System.out.println();
    System.out.println("---Lecture du fichier à l'envers---");
    file.readerFileInReverse();
    System.out.println("---Lecture du fichier en palindrome---");
    file.readerFileInPalindrome();
  }
}