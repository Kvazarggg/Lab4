import java.io.IOException;
import java.util.Scanner;


public class Lab4_main {
    public static ExamResults exRes = new ExamResults();

    public static int CheckCorrectFunction(String value) {
        int func = -1;
        try {
            func = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            func = -1;
        }

        return func;
    }

    public static void main(String[] args) throws IOException{
        final String[] discipline = {"Английский", "Математика", "Программирование", "Физика", "Химия"};
        int function;
        Scanner in = new Scanner(System.in);

        exRes.add(new ExamResult("Журавлёв", "Давид", "Тимофеевич", 1, "ИКС", 2,
                new Mark(discipline[0], "Кудряшова", 5), new Mark(discipline[1], "Фёдоров", 4),
                new Mark(discipline[2], "Гаврилов", 4), new Mark(discipline[3], "Александров", 5),
                new Mark(discipline[4], "Зайцева", 5)));

        exRes.add(new ExamResult("Иванов", "Иван", "Иванович", 2, "ИИРБТ", 3,
                new Mark(discipline[0], "Маркова", 3), new Mark(discipline[1], "Фёдоров", 5),
                new Mark(discipline[2], "Дементьев", 4), new Mark(discipline[3], "Шарапов", 2),
                new Mark(discipline[4], "Рогова", 2)));

        exRes.add(new ExamResult("Соколова", "Ольга", "Николаевна", 2, "УНИ", 3,
                new Mark(discipline[0], "Кудряшова", 2), new Mark(discipline[1], "Новиков", 2),
                new Mark(discipline[2], "Дорофеев", 1), new Mark(discipline[3], "Киселёв", 2),
                new Mark(discipline[4], "Зайцева", 2)));

        exRes.add(new ExamResult("Васильев", "Ростислав", "Аркадьевич", 2, "ИЕКСУ", 3,
                new Mark(discipline[0], "Кудряшова", 3), new Mark(discipline[1], "Фёдоров", 3),
                new Mark(discipline[2], "Дорофеев", 5), new Mark(discipline[3], "Прохоров", 5),
                new Mark(discipline[4], "Кузьмин", 4)));

        exRes.add(new ExamResult("Горбунова", "Анастасия", "Степановна", 2, "ХТФ", 3,
                new Mark(discipline[0], "Маркова", 5), new Mark(discipline[1], "Новиков", 2),
                new Mark(discipline[2], "Гаврилов", 3), new Mark(discipline[3], "Шарапов", 2),
                new Mark(discipline[4], "Гуляев", 4)));

        do {
            System.out.println("\nСписок функций: ");
            System.out.println("[1] - Вывод массива на экран");
            System.out.println("[2] - Показать отличников");
            System.out.println("[3] - Показать двоечников");
            System.out.println("[4] - Показать дисциплину с наибольшим количеством двоечников");
            System.out.println("[5] - Удаление студентов-двоечников");
            System.out.println("[6] - Сохранение в файл");
            System.out.println("[7] - Загрузить из файла");
            System.out.println("[8] - Загрузить резервную копию");
            System.out.println("[0] - Выход из программы");
            do {
                System.out.print("Введите номер функции: ");
                function = CheckCorrectFunction(in.nextLine());
            } while (function == -1);

            switch (function) {
                case 1:
                    System.out.println(exRes);
                    break;
                case 2:
                    System.out.println("\nСтуденты отличники: ");
                    exRes.IsExcellent();
                    break;
                case 3:
                    System.out.println("\nСтуденты двоечники: ");
                    exRes.IsBadStudent();
                    break;
                case 4:
                    exRes.SubjectWithBadMark();
                    break;
                case 5:
                    exRes.RemoveBadStudents();
                    break;
                case 6:
                    System.out.print("\nВведите путь для сохранения файл:");
                    String saveFileName = in.nextLine();
                    exRes.saveFile(saveFileName);
                    break;
                case 7:
                    System.out.print("\nВведите путь к базе данных:");
                    String loadFileName = in.nextLine();
                    exRes.loadFile(loadFileName);
                    break;
                case 8:
                    String loadReserve = "reserve.txt";
                    exRes.loadFile(loadReserve);
                    break;
                case 0:
                    String saveReserve = "reserve.txt";
                    exRes.saveFile(saveReserve);
                    break;
                default:
                    System.out.println("\nТакой функции нету");
            }
        } while (function != 0);
    }
}
