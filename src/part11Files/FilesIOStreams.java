package part11Files;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Files and I/O streams
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesIOStreams {
    public static void main(String[] args) {
        Path testFile = Path.of("TestingFile.txt");
        readingAFile(testFile);
        try {
            Path newFile = Path.of("NewFile.txt");
            writingAFile(newFile);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void readingAFile(Path testFile) {
        String line = null;

        // Pre - JDK 7 Method of reading a file...
        System.out.println("-- Pre - JDK 7 Method of reading a file--");
        String fileName = testFile.toString();

        // Use BufferedReader to use readLine operation
        try (BufferedReader inStream =
                     new BufferedReader(new FileReader(fileName))) {

            while ((line = inStream.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException io) {
            System.out.println(io);
        }

        System.out.println("-- Files.newInputStream passed to a " +
                "BufferedReader --");
        // Hybrid - Get an InputStream passing Path to
        // Files.newInputStream
        try (InputStream in = Files.newInputStream(testFile);
             // Use BufferedReader to leverage readLine operation
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(in))) {

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException io) {
            System.out.println(io);
        }

        // Using Files.newBufferedReader
        System.out.println("-- Files.newBufferedReader --");
        // Get a BufferedReader directly from Files class
        // passing Path instance
        try (BufferedReader reader = Files.newBufferedReader(testFile)) {

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    // Three Examples of writing to a file using output streams,
// BufferedWriter
    private static void writingAFile(Path testFile) throws IOException {
        String line = "Hello Janet";

        // Pre - JDK 7 Method of writing data to  a file...
        System.out.println("-- Pre - JDK 7 Method of writing a file--");
        String fileName = testFile.toString();
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException io) {
            System.err.println(io);
        }
        Files.readAllLines(testFile)
                .forEach((s) -> System.out.println("\t" + s));

        // Hybrid - Files.newOutputStream in a BufferedOutputStream
        System.out.println("-- Files.newOutputStream passed to a " +
                "BufferedOutputStream --");

        byte data[] = line.getBytes();
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(testFile, StandardOpenOption.CREATE))) {
            out.write(data, 0, data.length);
        } catch (IOException io) {
            System.err.println(io);
        }
        Files.readAllLines(testFile)
                .forEach((s) -> System.out.println("\t" + s));

        // Using Files.newBufferedWriter
        System.out.println("-- Files.newBufferedWriter --");
        try (BufferedWriter out = Files.newBufferedWriter(testFile)) {
            out.write(line);
            out.newLine();
        } catch (IOException io) {
            System.out.println(io);
        }
        Files.readAllLines(testFile)
                .forEach((s) -> System.out.println("\t" + s));
    }
}