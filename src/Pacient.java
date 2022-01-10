import java.util.Scanner;

public class Pacient {
    private FIO Fio = new FIO();
    private Date Data_Brith = new Date();
    private Pasport Personal_Data = new Pasport();
    private Diagnosis[] History_Disease = new Diagnosis[30];
    private String Medical_Card;
    private int Diagnosis_point;

    public Pacient() {
        Scanner in = new Scanner(System.in);

        System.out.print(" Мед.карта: ");
        this.Medical_Card = in.nextLine();

        System.out.println(" <Конец ввода>");

    }

    public void PrintInfo() {
        FIO name = this.GetsFio();
        Date brith = this.GetsDataBrith();
        Pasport Personal = this.GetsPersonalData();
        String MedicalCard = this.GetsMedicalCard();
        int Diagnosis_Point = this.GetsQuantityDisease();

        System.out.print(" <Персональные данные>\n");
        System.out.printf(" ФИО пациента            : %s\n", name.Full_Name);
        System.out.printf(" Серия и номер паспорта  : %s %s\n", Personal.Series, Personal.Number);
        System.out.printf(" Дата рождения           : %d.%d.%d\n", brith.day, brith.mounth, brith.year);
        System.out.printf(" Номер медецинской карты : %s\n\n", MedicalCard);
        System.out.print(" <Краткая история болезни>\n");

        if (Diagnosis_Point > 0) {
            System.out.printf(" Общее число зарегистрированных заболеваний: %d\n", Diagnosis_Point);
            System.out.print(" Наименование болезни : Дата постановки диагноза\n");

            Diagnosis[] History_Disease = this.GetsHistoryDisease();
            String Name_Disease;
            Date Admission_Date;
            for (int number_Diagnosis = 0; number_Diagnosis < Diagnosis_Point; number_Diagnosis++) {
                Name_Disease = History_Disease[number_Diagnosis].GetsDisease().GetsName();
                Admission_Date = History_Disease[number_Diagnosis].GetsTalon().GetsDate();
                System.out.printf(" %20s :               %2d.%2d.%4d\n", Name_Disease, Admission_Date.day, Admission_Date.mounth, Admission_Date.year);
            }
        }
        else
            System.out.printf(" Нет заригестрированных заболеваний\n");

        System.out.println(" <Вывод завершён>");
    }


    public FIO GetsFio() {
        return this.Fio;
    }

    public Date GetsDataBrith() {
        return this.Data_Brith;
    }

    public Pasport GetsPersonalData() {
        return this.Personal_Data;
    }

    public Diagnosis[] GetsHistoryDisease() {
        return this.History_Disease;
    }

    public String GetsMedicalCard() {
        return this.Medical_Card;
    }

    public int GetsQuantityDisease() {
        return this.Diagnosis_point;
    }


    public void GiveDiagnosis(Diagnosis OneDiagnos) {
        this.History_Disease[this.Diagnosis_point] = OneDiagnos;
        this.Diagnosis_point++;
    }

    public void DeleteDiagnosis(int number_delDiagnosis) {
        int Disease_Number = number_delDiagnosis;
        for (; Disease_Number < this.Diagnosis_point - 1; Disease_Number++) {
            this.History_Disease[Disease_Number] = this.History_Disease[Disease_Number + 1];
        }
        this.History_Disease[Disease_Number] = new Diagnosis();
        this.Diagnosis_point--;
    }

    public void ClearHistoryDisease() {
        int Disease_Number = 0;
        for (; Disease_Number < this.Diagnosis_point; Disease_Number++) {
            this.History_Disease[Disease_Number] = new Diagnosis();
        }
        this.Diagnosis_point = 0;
    }

    public boolean DiseaseOfPacient(String Name_Disease) {
        boolean True_Disease = false;
        int Diagnosis_point = this.Diagnosis_point;
        Diagnosis[] History_Disease = this.History_Disease;

        for (int number_diagnosis = 0; number_diagnosis < Diagnosis_point && !True_Disease; number_diagnosis++) {
            String disease = History_Disease[number_diagnosis].GetsDisease().GetsName();
            True_Disease = disease.equals(Name_Disease);
        }
        return True_Disease;
    }
}
