import java.util.Scanner;

public class Time {
    int hour = 0,
            minutes = 0;

    public Time() {
        int Quantity_Input_Data;
        do {

            System.out.print(" Время: ");

            Scanner in = new Scanner(System.in);
            Scanner buffer = new Scanner(in.nextLine());
            buffer.useDelimiter("\\.");

            for (Quantity_Input_Data = 0; buffer.hasNext() && Quantity_Input_Data < 3; Quantity_Input_Data++) {
                if (buffer.hasNextInt()) {
                    if (Quantity_Input_Data == 0)
                        this.hour = buffer.nextInt();
                    else if (Quantity_Input_Data == 1)
                        this.minutes = buffer.nextInt();
                }
                else
                    Quantity_Input_Data = 3;
            }
            if (Quantity_Input_Data != 2) {
                System.out.println("\n <Формат данных не соотвествует требованиям>");
                continue;
            }
            if (this.hour > 23 || this.hour < 0) {
                System.out.println("\n <Неверно введены часы> ");
                Quantity_Input_Data--;
            }
            else if (this.minutes > 59 || this.minutes < -1) {
                System.out.println("\n <Неверно введены минуты> ");
                Quantity_Input_Data--;
            }
        } while (Quantity_Input_Data != 2);
    }
}

