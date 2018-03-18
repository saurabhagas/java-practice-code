package sandbox.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
  @Test
  public void testPathFunctionalities() throws Exception {
    System.out.println(FileSystems.getDefault());
//    System.out.println(Paths.get("blah;:")); //RuntimeException on Windows since ":" is used as a Path separator

    System.out.println(Paths.get(new URI("file://random/test-programs.iml")));

    //URL, URI and Path interactions
    URL url = new URL("file:///c:/users/saag/Desktop/error.log");
    System.out.println(url);
    System.out.println(url.toURI());
    System.out.println(Paths.get(url.toURI()));
    System.out.println(url.getFile());
//    System.out.println(Paths.get(url.getFile()).toUri());

    Path path = Paths.get("C:/land/hippo/harry.happy");
    System.out.println("The Path Name is: " + path);
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println(" Element " + i + " is: " + path.getName(i));
    }

    //Filename, root and parent
    path = Paths.get("zoo/armadillo/shells.txt");
    System.out.println("Is absolute: " + path.isAbsolute());
    System.out.println("Root is: " + path.getRoot()); //Root is "C:\"
    System.out.println("Filename is: " + path.getFileName());
    System.out.println("File parent is: " + path.getParent());

    System.out.println(Paths.get("").toRealPath());
    System.out.println(Paths.get("../-1").toAbsolutePath());
  }

  @Test
  public void testPathNormalization() throws IOException {
    Path path = Paths.get("C:\\Users\\saag\\Google Drive\\Cert\\Level 2\\test-programs\\src\\..\\src\\Chapter9\\..");
    System.out.println("Absolute path: " + path.toAbsolutePath()); //Doesn't normalize
    System.out.println("Normalised path: " + path.normalize());

    //equals doesn't normalize, or check equivalent paths. Does check other stuff like case insensitivity on Windows
    System.out.println(path.equals(path.normalize()));
    System.out.println(path.equals(Paths.get("C:\\Users\\saag\\Google Drive\\Cert\\Level 2\\test-programs\\src\\..\\src\\")));
    System.out.println(path.equals(Paths.get("c:\\users\\saag\\google Drive\\Cert\\Level 2\\test-programs\\src\\..\\src\\Chapter9\\..")));
    System.out.println(path.equals(Paths.get("C:\\Users\\saag\\Google Drive\\Cert\\Level 2\\test-programs\\src\\..\\src\\Chapter9\\..")));

    System.out.println(path.compareTo(path.normalize()));
    System.out.println(path.toAbsolutePath().equals(path.normalize().toAbsolutePath()));
  }

  @Test
  public void testRelativize() {
    //Relative paths - assume that the files are present in the current working directory
    Path path1 = Paths.get("fish.txt");
    Path path2 = Paths.get("birds.txt");
    System.out.println(path1.relativize(path2));
    System.out.println(path2.relativize(path1));

    //Absolute paths with same root
    Path path3 = Paths.get("E:\\habitat");
    Path path4 = Paths.get("E:\\sanctuary\\raven");
    System.out.println(path3.relativize(path4));
    System.out.println(path4.relativize(path3));

    //Absolute paths with different roots
    Path path5 = Paths.get("E:\\habitat");
    Path path6 = Paths.get("C:\\sanctuary\\raven");
//    System.out.println(path5.relativize(path6)); //IllegalArgumentException
//    System.out.println(path6.relativize(path5)); //IllegalArgumentException

    //Absolute path and relative path mix - IllegalArgumentException
    Path path7 = Paths.get("E:\\habitat");
    Path path8 = Paths.get("raven");
//    System.out.println(path7.relativize(path8)); //IllegalArgumentException
//    System.out.println(path8.relativize(path7)); //IllegalArgumentException
  }

  @Test
  public void testResolve() {
    //Relative paths
    Path path1 = Paths.get("fish.txt");
    Path path2 = Paths.get("birds.txt");
    System.out.println(path1.resolve(path2));
    System.out.println(path2.resolve(path1));

    //Absolute paths with same root
    Path path3 = Paths.get("E:\\habitat");
    Path path4 = Paths.get("E:\\sanctuary\\raven");
    System.out.println(path3.resolve(path4));
    System.out.println(path4.resolve(path3));

    //Absolute paths with different roots
    Path path5 = Paths.get("E:\\habitat");
    Path path6 = Paths.get("C:\\sanctuary\\raven");
    System.out.println(path5.resolve(path6));
    System.out.println(path6.resolve(path5));

    //Absolute path and relative path mix
    Path path7 = Paths.get("E:\\habitat");
    Path path8 = Paths.get("raven");
    System.out.println(path7.resolve(path8));
    System.out.println(path8.resolve(path7));
  }

  @Test
  public void testRealAndAbsolutePaths() throws IOException {
    Path path = Paths.get("."); //toRealPath gives current working directory on "."
    /**
     * toRealPath():
     * 1. normalizes path
     * 2. only method which checks existence of the file
     * 3. throws checked IOException
     * 4. only Path API to support options (e.g LinkOption)
     * 5. converts to absolute path
     */
    System.out.println(path.toRealPath()); //Throws IOException
    System.out.println(path.toAbsolutePath());
    System.out.println(path.toAbsolutePath().normalize());
    System.out.println(path.toAbsolutePath().equals(path.toRealPath()));
  }
}
