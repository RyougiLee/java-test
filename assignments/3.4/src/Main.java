import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
//------------Task 1-------------
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
//------------Task 2-------------
public class Main {
    public static void main(String[] args) {
        ArrayList<Long> fibList = new ArrayList<>(Arrays.asList(0L, 1L));
        for (int i = 2; i < 60; i++) {
            fibList.add(fibList.get(i - 1) + fibList.get(i - 2));
        }
        System.out.println(fibList);
        try (Writer writer = new FileWriter("assignments/3.4/src/Fibonacci.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Long num : fibList) {
                bufferedWriter.write(num.toString());
                bufferedWriter.newLine();
            }

            // It is important to flush or close the writer to ensure the data is written to the file
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//------------Task 3-------------
class Student implements Serializable {
    private int id, age;
    private String name;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return  name;
    }
}

class Course implements Serializable {
    private String courseCode, courseName, instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }
    public String getCourseName(){
        return courseName;
    }
}

class Enrollment implements Serializable {
    private String enrollmentDate;
    private Student student;
    private Course course;

    public Enrollment(String enrollmentDate, Student student, Course course) {
        this.enrollmentDate = enrollmentDate;
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment Date: " + enrollmentDate + ", Student: " + student.getName() + ", Course: " + course.getCourseName();
    }
}

class Test {
    private final static String FILENAME = "assignments/3.4/src/Enrollments.ser";
    public static void main(String[] args) {
        // Create instances of Student, Course, and Enrollment
        // Serialize and save the Enrollment instance
        // Deserialize and print the Enrollment instance
        File f = new File(FILENAME);
        Student students = new Student(1, "Alice", 20);
        Course course = new Course("ABC", "Mathematics", "Dr. Smith");
        Enrollment enrollment = new Enrollment("2023-10-01", students, course);

        if (f.exists() && f.isFile()) {
            // we have objects state stored to the file, read it
            try (
                    FileInputStream inputstream = new FileInputStream(FILENAME);
                    ObjectInputStream objects = new ObjectInputStream(inputstream);
            ) {
                enrollment = (Enrollment) objects.readObject();
            } catch (Exception e) {
                System.err.println("Reading person: " + e);
            }
        } else {
            // there are no stored object state, let's create an object
            try (
                    FileOutputStream outputstream = new FileOutputStream(FILENAME);
                    ObjectOutputStream objects = new ObjectOutputStream(outputstream);
            ) {
                objects.writeObject(enrollment);
            } catch (Exception e) {
                System.err.println("Writing person: " + e);
            }
        }

        System.out.println("Person: " + enrollment);
    }
}