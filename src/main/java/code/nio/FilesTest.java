package code.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesTest {
  @Test
  public void testFileAttributes() throws Exception {
    Path path = Paths.get("c:/users/saurabh/desktop/");
    Files.walk(path).forEach(System.out::println);
    Files.find(path, 10, (path1, basicFileAttributes) -> {
      System.out.println("##########");
      System.out.println(path1);
      System.out.println(Files.isExecutable(path1));

      System.out.println(Files.isSymbolicLink(path1));
//      System.out.println(basicFileAttributes.isSymbolicLink());

      try {
        System.out.println(Files.isHidden(path1));
        System.out.println(Files.size(path1));
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(basicFileAttributes.size());

//      System.out.println(basicFileAttributes.creationTime());
//      System.out.println(basicFileAttributes.fileKey());

      System.out.println(Files.isDirectory(path1));
      System.out.println(basicFileAttributes.isDirectory());

//      System.out.println(basicFileAttributes.isOther());

      System.out.println(Files.isRegularFile(path1));
      System.out.println(basicFileAttributes.isRegularFile());

//      System.out.println(basicFileAttributes.lastAccessTime());
      try {
        System.out.println(Files.getLastModifiedTime(path1));
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(basicFileAttributes.lastModifiedTime());
      return path1.endsWith("lnk");
//      return basicFileAttributes.isSymbolicLink();
    }).forEach(System.out::println);
  }

  @Test
  public void testLines() throws IOException {
    Files.lines(Paths.get("blah.csv"))
        .flatMap(line -> Stream.of(line.split(",")))
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }

  @Test
  public void testPathAndFile() throws IOException {
    Path path1 = Paths.get("C:/./").resolve(Paths.get("users"));
    Path path2 = new File("C:/././users").toPath();

    System.out.println(path1);
    System.out.println(path2);
    System.out.println("Same file: " + Files.isSameFile(path1, path2));
    System.out.println("Paths equal: " + path1.equals(path2));
    System.out.println("Only path1 normalized: " + path1.normalize().equals(path2));
    System.out.println("Both path1 and path 2 normalized: " + path1.normalize().equals(path2.normalize()));
  }

  @Test
  public void testNormalizeOnCurrentDirectory() {
    Path path = Paths.get(".").normalize();
    System.out.println(path);
    int count = 0;
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println(path.getName(i));
      count++;
    }
    System.out.println("Count: " + count);
  }
}
