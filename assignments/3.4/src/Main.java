//------------Task 1-------------
import java.io.*;
import java.net.*;
import java.util.Arrays;

class CSVReader {
    private final static String FILENAME = "data.csv";
    public static void main(String[] args) {

        int index = 0;
        double sum = 0;
        URL myUrl;
        try {
            // the url in the task cannot be accessed outside the university network, so I have uploaded the file to my GitHub.
            myUrl = new URL("https://raw.githubusercontent.com/RyougiLee/java-test/refs/heads/master/assignments/3.4/src/Data%20Streams%20and%20Exceptions.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        BufferedReader bufferedstream = null;
        String line;
        String[] columnNames = new String[0];
        boolean header = true;

        try {
            InputStream istream = myUrl.openStream();

            // jump to character streams
            InputStreamReader istreamreader = new InputStreamReader(istream);

            // and to buffered reader for efficiency
            BufferedReader reader = new BufferedReader(istreamreader);

            do {
                line = reader.readLine();
                if (line != null) {
                    if (header) {
                        // first row of the file contains names of columns
                        columnNames = line.split(";");
                        for (int i = 0; i < columnNames.length; i++) {
                            if (columnNames[i].equals("UlkoTalo")){
                                index = i;
                            }
                        }
                        header = false;
                    } else {
                        // just print data lines with column names
                        String[] columns = line.split(";");
                        if(columns[0].contains("01.01.2023")){
                            sum += Double.parseDouble(columns[index].replace(',','.'));
                        }
                    }
                }
            } while (line != null);
        } catch (IOException e) {
            // Error output, will print to console even in case of output redirection
            System.err.println(e);
        } finally {
            try {
                // we will close the stream only if we were able to open it
                if (bufferedstream != null)
                    bufferedstream.close();
            } catch (Exception e) {
                System.out.println("Error while closing the file " + FILENAME);
            }
        }
        System.out.println("Sum = " + sum);
    }
}