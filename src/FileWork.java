import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileWork {
    public void save(ArrayList<ExamResult> examResults, String fileName) throws IOException {
        FileWriter outStream = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (ExamResult object : examResults) {
            try {
                bw.write(object.getF());
                bw.write(System.lineSeparator());
                bw.write(object.getI());
                bw.write(System.lineSeparator());
                bw.write(object.getO());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getNumberGradeBook()));
                bw.write(System.lineSeparator());
                bw.write(object.getFacultyName());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getCourse()));
                bw.write(System.lineSeparator());
                for (int i = 0; i < 5; i++) {
                    bw.write(object.result[i].getTeacherName());
                    bw.write(System.lineSeparator());
                    bw.write(object.result[i].getSubjectName());
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(object.result[i].getMark()));
                    bw.write(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        examResults.clear();
        bw.close();
        outStream.close();
    }

    public void load(ArrayList<ExamResult> examResults, String fileName) throws IOException {
        examResults.clear();
        try {
            Scanner scan = new Scanner(new FileReader(fileName));
            String f;
            String i;
            String o;
            int numberGradeBook;
            String facultyName;
            int course;
            String[] subjectName = new String[5];
            String[] teacherName = new String[5];
            int[] mark = new int[5];

            while (scan.hasNextLine()) {
                f = scan.nextLine();
                i = scan.nextLine();
                o = scan.nextLine();
                numberGradeBook = Integer.valueOf(scan.nextLine());
                facultyName = scan.nextLine();
                course = Integer.valueOf(scan.nextLine());
                for (int j = 0; j < 5; j++) {
                    teacherName[j] = scan.nextLine();
                    subjectName[j] = scan.nextLine();
                    mark[j] = scan.nextInt();
                    scan.nextLine();
                }

                examResults.add(new ExamResult(f, i, o, numberGradeBook, facultyName, course,
                        new Mark(teacherName[0], subjectName[0], mark[0]),
                        new Mark(teacherName[1], subjectName[1], mark[1]),
                        new Mark(teacherName[2], subjectName[2], mark[2]),
                        new Mark(teacherName[3], subjectName[3], mark[3]),
                        new Mark(teacherName[4], subjectName[4], mark[4])));
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
