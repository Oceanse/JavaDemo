package com.demo.exception.finallyDemo;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 */
public class FinallyDemo2 {


    /**
     * The class BufferedReader, in Java SE 7 and later, implements the interface java.lang.AutoCloseable.
     * Because the BufferedReader instance is declared in a try-with-resource statement, it will be closed
     * regardless of whether the try statement completes normally or abruptly (as a result of the method BufferedReader.readLine throwing an IOException).
     */
    @Test
    public void test() {

        String path = "none";
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * You may declare one or more resources in a try-with-resources statement. The following example retrieves the names of
     * the files packaged in the zip file zipFileName and creates a text file that contains the names of these files:
     * @param zipFileName
     * @param outputFileName
     * @throws java.io.IOException
     */
    @Test
    public void test2(String zipFileName,
                      String outputFileName) throws java.io.IOException{

        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (
                java.util.zip.ZipFile zf =
                        new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer =
                        java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                 zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }

    }


}
