import java.util.Scanner;

public class Doctor {
    private FIO Fio = new FIO();
    private String Dolgnost;


    public Doctor() {
        int Quantity_Input_Data;
        do {
            System.out.print(" Должность: ");

            Scanner in = new Scanner(System.in);
            Quantity_Input_Data = 0;
            String[] boffer = in.nextLine().split(" ");
            for (String word : boffer)
                Quantity_Input_Data++;
            if (Quantity_Input_Data == 1)
                this.Dolgnost = boffer[0];
            else
                System.out.println("\n <Формат данных не соотвествует требованиям>");
        } while (Quantity_Input_Data != 1);
    }

    public void PrintInfo() {
        System.out.printf(" |%45s|%20s|\n", this.Fio.Full_Name, this.Dolgnost);
    }

    public FIO GetsFio() {
        return this.Fio;
    }

    public String GetDolgnost() {
        return this.Dolgnost;
    }
}
