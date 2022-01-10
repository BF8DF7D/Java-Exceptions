import javax.print.Doc;
import java.util.Scanner;

public class Talon {
    private Date Admission_Date;
    private Time Admission_Time;
    private int kabinet;
    private Doctor medic;


    int FormatIntValue(){
        int Quantity_Input_Data;
        int value;
        do {
            System.out.print(" Номер кабинета: ");

            value = 0;

            Scanner in = new Scanner(System.in);
            Scanner buffer = new Scanner(in.nextLine());

            for(Quantity_Input_Data = 0; buffer.hasNext() && Quantity_Input_Data < 2; Quantity_Input_Data++){
                if (buffer.hasNextInt()) {
                    value = buffer.nextInt();
                } else
                    Quantity_Input_Data = 2;
            }
            if (Quantity_Input_Data != 1){
                System.out.println("\n <Формат данных не соотвествует требованиям>");
                continue;
            }
            if (value > 999 || value <= 0) {
                System.out.println("\n <Неверно введён кабинет>");
                Quantity_Input_Data--;
            }
        } while (Quantity_Input_Data != 1);
        return value;
    }

    public Talon(Date inp_date, Time inp_time, int inp_kab, Doctor inp_med) {
        Admission_Date = inp_date;
        Admission_Time = inp_time;
        kabinet = inp_kab;
        medic = inp_med;
    }

    public Talon(Doctor medic) {
        Admission_Date = new Date();
        Admission_Time = new Time();
        kabinet = FormatIntValue();
        this.medic = medic;
    }

    public Talon() {
        Admission_Date = new Date();
        Admission_Time = new Time();
        kabinet = FormatIntValue();
        this.medic = new Doctor();
    }

    public void PrintInfo() {
        Date date = this.Admission_Date;
        Time time = this.Admission_Time;

        System.out.printf("|%46s|", this.medic.GetsFio().Full_Name);
        System.out.printf("%3d.%2d.%4d|", date.day, date.mounth, date.year);
        System.out.printf("%3d.%2d|%4d|\n", time.hour, time.minutes, this.kabinet);
    }

    public Date GetsDate() {
        return this.Admission_Date;
    }

    public Time GetsTime() {
        return this.Admission_Time;
    }

    public int GetsKabinet() {
        return this.kabinet;
    }

    public Doctor GetsDoctor() {
        return this.medic;
    }
}

