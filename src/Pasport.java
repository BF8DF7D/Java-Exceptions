import java.util.Scanner;

public class Pasport {
    public String Series,
    Number;

    public Pasport(){
        int Quantity_Input_Data;
        do {

            System.out.print(" Паспортные данные: ");

            Scanner in = new Scanner(System.in);
            Scanner buffer = new Scanner(in.nextLine()).useDelimiter("\\s");

            for (Quantity_Input_Data = 0; buffer.hasNext() && Quantity_Input_Data < 3; Quantity_Input_Data++) {
                if (buffer.hasNextInt()) {
                    if (Quantity_Input_Data == 0)
                        this.Series = buffer.next();
                    else if (Quantity_Input_Data == 1)
                        this.Number = buffer.next();
                }
                else
                    Quantity_Input_Data = 3;
            }

            if (Quantity_Input_Data != 2) {
                System.out.println("\n <Формат данных не соотвествует требованиям>");
                continue;
            }
            if (this.Series.codePointCount(0, this.Series.length()) != 4) {
                System.out.println("\n <Неверно введна серия паспорта>");
                Quantity_Input_Data--;
            }
            else if (this.Number.codePointCount(0, this.Number.length()) != 6) {
                System.out.println("\n <Неверно введён номер паспорта>");
                Quantity_Input_Data--;
            }
        } while (Quantity_Input_Data != 2);
    }
}
