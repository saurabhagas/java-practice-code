package code.nio;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class SymbolicLinks {
  public static void main(String[] args) throws Exception {
    Path target = Paths.get("c:/a.txt");
    Path symbolicLink = Paths.get("c:/links/symbolicLink.txt");

// creates test link
    Files.createSymbolicLink(symbolicLink, target);

    BasicFileAttributes targetAttributes = Files.readAttributes(symbolicLink, BasicFileAttributes.class);
    BasicFileAttributes linkAttributes = Files.readAttributes(symbolicLink, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

    System.out.println("File attribute - isSymbolicLink\tTarget: " + targetAttributes.isSymbolicLink() + "\t\t\t\tLink: " + linkAttributes.isSymbolicLink());
    System.out.println("File attribute - size\t\tTarget: " + targetAttributes.size() + "\t\t\t\tLink: " + linkAttributes.size());
    System.out.println("File attribute - creationTime:\tTarget: " + targetAttributes.creationTime() + "\tLink: " + linkAttributes.creationTime());
  }
}
