import javax.tools.FileObject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NewFileClass {
    public static ArrayList<FileValue> fileValueArrayList = new ArrayList<>();
    public static final String wayToFile = "src/main/java/lesson5/dz/JavacoreHW5";
    public static final String title = "value1" + ";" + "value2" + ";" + "value3" + ";" + System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        writeFlow();

        AppData appData = readToObject();
    }

    public static void writeFlow() throws IOException {
        try (FileWriter writer = new FileWriter(wayToFile);) {
            writer.write(title);
            for (FileValue fileValue : fileValueArrayList) {
                String raw = fileValue.getValue1() + ";" + fileValue.getValue2()
                        + ";" + fileValue.getValue3() + ";" + System.getProperty("line.separator");
            }
        }
    };
            
    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(wayToFile))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }
        int[][] resultData = new int[records.size()][3];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
        return appData;

    }
}

            