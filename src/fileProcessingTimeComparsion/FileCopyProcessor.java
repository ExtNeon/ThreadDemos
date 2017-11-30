package fileProcessingTimeComparsion;

import java.io.*;

/**
 * Данный класс копирует файл целиком в отдельном потоке.
 * @author Малякин Кирилл. Гр. 15 - 20.
 */
public class FileCopyProcessor extends Thread {
    private String inputFileName;
    private String outputFileName;

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            int readedChar;
            while ((readedChar = reader.read()) != -1) {
                writer.write(readedChar);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FileCopyProcessor(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }


}
