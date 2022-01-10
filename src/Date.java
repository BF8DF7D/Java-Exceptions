import java.util.InputMismatchException;
import java.util.Scanner;

public class Date {
    public int day,
            mounth,
            year;

    public Date() throws InputMismatchException {
        int Input_data_number;
        do {
            System.out.print(" Дата: ");

            Scanner in = new Scanner(System.in);
            Scanner buffer = new Scanner(in.nextLine().replace('.', ' '));

            //INPUT BLOCK
            int[] data_entered = new int[3];
            for (Input_data_number = 0; buffer.hasNext(); Input_data_number++) {
                try {
                    if (buffer.hasNextInt()) {
                        data_entered[Input_data_number] = buffer.nextInt();
                        if (Input_data_number == 0 && (data_entered[Input_data_number] > 31 || data_entered[Input_data_number] <= 0)
                                || Input_data_number == 1 && (data_entered[Input_data_number] > 12 || data_entered[Input_data_number] <= 0)
                                || Input_data_number == 2 && (data_entered[Input_data_number] > 9999 || data_entered[Input_data_number] <= 1999)) {
                            throw new Exception("Введёное значение не является форматом даты");
                        }
                    } else if (buffer.hasNext() && Input_data_number >= 3)
                        throw new Exception("Избыток считываемых данных");
                    else
                        throw new Exception("Формат данных не соотвестует ожидаемым");

                    //EXCEPTION PROCESSING BLOCK
                } catch (Exception e) {
                    String name_error = e.getMessage();
                    System.out.printf(" ОШИБКА: %s\n", name_error);
                    switch (name_error) {
                        case "Формат данных не соотвестует ожидаемым" -> {
                            String error = buffer.nextLine();
                            System.out.printf("""
                                     В вдёной строке присуствуют сторонние символы, не являющиеся целым числом
                                     Номер символа в строке: %d\s
                                     Визуальное представление ошибки > %s
                                    """, Input_data_number * 3, error);
                        }
                        case "Избыток считываемых данных" -> {
                            String error = buffer.nextLine();
                            System.out.printf("""
                                     После считывания всех необходимых данных в потоке ввода ещё остались символы
                                     Количество сторонних символов: %d\s
                                     Визуальное представление ошибки > %s\s
                                    """, error.length() - 10, error);
                        }
                        case "Введёное значение не является форматом даты" ->
                                System.out.print(" Однай из частей введённой строки, разделённая '.' вызвала ошибку\n");
                    }
                    Input_data_number = 0;
                    System.out.println();
                }
                if (Input_data_number == 3) {
                    day = data_entered[0];
                    mounth = data_entered[1];
                    year = data_entered[2];
                    break;
                }
            }
        } while (Input_data_number != 3);
    }
}


//System.out.printf(" [%d] %d.%d.%d\n",Input_data_number, data_entered[0],  data_entered[1],  data_entered[2]);
//

