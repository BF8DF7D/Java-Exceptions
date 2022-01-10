import java.util.Scanner;

public class FIO {
    public String Last_Name = "",
            First_Name = "",
            Patronymic = "",
            Full_Name = "";

    public FIO() {
        int Quantity_Input_Data;
        do {
            System.out.print(" ФИО: ");

            Quantity_Input_Data = 0;
            Scanner in = new Scanner(System.in);
            String[] boffer = in.nextLine().split(" ");
            for (String word : boffer)
                Quantity_Input_Data++;
            if (Quantity_Input_Data == 3) {
                this.Last_Name = boffer[0];
                this.First_Name = boffer[1];
                this.Patronymic = boffer[2];
            }
            else
                System.out.println("\n <Формат данных не соотвествует требованиям>");
        } while (Quantity_Input_Data != 3);

        this.Full_Name = String.join(" ", this.Last_Name, this.First_Name, this.Patronymic);
    }
}

