import java.util.Scanner;

public class Diagnosis {
    private Talon History;
    private Disease Illness;
    private String Recomendations;

    public Diagnosis(Talon history, Disease illness) {
        this.History = history;
        this.Illness = illness;
        this.Recomendations = "";

        System.out.println(" <Запишите рекомендации>\n <Остановка записи - сивол '0' в конце вводимой строки>");

        int Leght_Entire_Record = 0,
                Sum_Leght_OldStrings = 0,
                Length_Record = 60;
        Scanner in = new Scanner(System.in);
        while (Sum_Leght_OldStrings != -1) {
            System.out.print(" : ");
            String[] buffer = in.nextLine().concat("\n").split(" ");
            for (String word : buffer) {
                word = word.concat(" ");
                Leght_Entire_Record += word.codePointCount(0, word.length());
                if ((Leght_Entire_Record - Sum_Leght_OldStrings) / Length_Record == 1) {
                    this.Recomendations = this.Recomendations.concat("\n ");
                    Sum_Leght_OldStrings = Leght_Entire_Record + 1 - word.codePointCount(0, word.length());
                    Leght_Entire_Record += 2;
                }

                if (word.length() - 2 >= 0) {
                    if (word.codePointAt(word.length() - 2) == '\n') {
                        Sum_Leght_OldStrings = Leght_Entire_Record;
                    }
                }
                if (word.length() - 3 >= 0) {
                    if (word.codePointAt(word.length() - 3) == '0') {
                        word = word.substring(0, word.codePointCount(0, word.length()) - 3);
                        Sum_Leght_OldStrings = -1;
                    }
                }
                if (word.length() == 0) {
                    this.Recomendations = this.Recomendations.concat(" ");
                }
                this.Recomendations = this.Recomendations.concat(word);
            }
        }
    }
    public Diagnosis() {}

    public void PrintInfo() {
        Doctor medic = this.GetsTalon().GetsDoctor();
        Date date = this.GetsTalon().GetsDate();
        Time time = this.GetsTalon().GetsTime();

        System.out.printf(" Доктор: %s\n", medic.GetsFio().Full_Name);
        System.out.printf(" Дата приёма: %d.%d.%d\n", date.day, date.mounth, date.year);
        System.out.printf(" Время приёма: %d.%d\n", time.hour, time.minutes);
        System.out.printf(" Кабинет: %d\n", this.GetsTalon().GetsKabinet());
        this.GetsDisease().PrintInfo();
        System.out.printf(" Реаомендации врача:\n %s\n", this.GetsRecomendations());
    }

    public Talon GetsTalon() {
        return this.History;
    }
    public Disease GetsDisease() {
        return this.Illness;
    }
    public String GetsRecomendations() {
        return this.Recomendations;
    }
}
