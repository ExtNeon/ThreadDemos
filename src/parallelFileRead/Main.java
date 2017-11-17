package parallelFileRead;

import java.io.*;

/**
 * Created by Кирилл on 10.11.2017.
 */

public class Main {
    static final String FIRST_FILE = "src\\parallelFileRead\\files\\1.txt";
    static final String SECOND_FILE = "src\\parallelFileRead\\files\\2.txt";
    static final String RESULT_FILE = "src\\parallelFileRead\\files\\result.txt";

    public static void main(String args[]) throws IOException {
        ThreadedFileReader firstFile = new ThreadedFileReader(FIRST_FILE);
        ThreadedFileReader secondFile = new ThreadedFileReader(SECOND_FILE);
        firstFile.allowRead();
        secondFile.allowRead();
        try (BufferedWriter resultFile = new BufferedWriter(new FileWriter(RESULT_FILE))) {
            firstFile.join();
            secondFile.join();
            for (int i = 0; i < firstFile.getCountOfLines() || i < secondFile.getCountOfLines(); i++) {
                if (i < firstFile.getCountOfLines()) {
                    resultFile.write(firstFile.getLine(i) + '\n');
                }
                if (i < secondFile.getCountOfLines()) {
                    resultFile.write(secondFile.getLine(i) + '\n');
                }
            }
            resultFile.flush();
        } catch (IOException e) {
            throw new IOException("We have a small trouble:\n" + e.toString());
        } catch (InterruptedException e) {}
    }
}
