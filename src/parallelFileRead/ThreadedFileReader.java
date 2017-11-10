package parallelFileRead;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Класс построчно читает всё содержимое текстового файла в отдельном потоке.
 * @author Малякин Кирилл. 15-20.
 */
public class ThreadedFileReader extends Thread {

    private BufferedReader reader;

    private ArrayList<String> buffer; //Решил сделать таким образом, так как получить одну строку становится проще.

    public void run() {
        String tempString;
        try {
            while((tempString = reader.readLine()) != null) {
                buffer.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ThreadedFileReader(String inputFileName) {
        super();
        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            buffer = new ArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start(); //Начинаем читать немедленно после создания.
    }

    public String getLine(int index) {
        if (index < 0) {
            throw new InvalidParameterException("Index cannot be lower zero");
        }
        return buffer.get(index);
    }

    public int getCountOfLines() {
        return buffer.size();
    }

}
