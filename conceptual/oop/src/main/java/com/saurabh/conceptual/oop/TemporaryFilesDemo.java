package com.saurabh.conceptual.oop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * TemporaryFilesDemo
 */
public class TemporaryFilesDemo {
  private static String uniqueTempDirectory;

  public static void main(String[] args) {
    if (uniqueTempDirectory == null) {
      try {
        uniqueTempDirectory = Files.createTempDirectory("terracotta").toAbsolutePath().toString();
      } catch (IOException e) {
        uniqueTempDirectory = System.getProperty("java.io.tmpdir");
      }

      try {
        File theFile = File.createTempFile("terracotta", "data");
        boolean deleted = theFile.delete();
        if (!deleted || !theFile.mkdir()) {
          uniqueTempDirectory = System.getProperty("java.io.tmpdir");
        } else {
          uniqueTempDirectory = theFile.getAbsolutePath();
        }
      } catch (IOException ioe) {
        uniqueTempDirectory = System.getProperty("java.io.tmpdir");
      }
    }
  }
}
