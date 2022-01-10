import java.util.Scanner;

public class Disease {
	private String Name_Disease;
	private String[] Disease_Symptoms = new String[30];
	private static int number_of_deaths = 0;

	public void Disease() {
		System.out.println(" <Ввод информации о заболевании>");

		int Quantity_Input_Data;
		do {
			System.out.print(" Наименование: ");

			Scanner in = new Scanner(System.in);
			Quantity_Input_Data = 0;
			String[] boffer = in.nextLine().split(" ");
			for (String word : boffer)
				Quantity_Input_Data++;
			if (Quantity_Input_Data == 1)
				this.Name_Disease = boffer[0];
			else
				System.out.println("\n <Формат данных не соотвествует требованиям>");
		} while (Quantity_Input_Data != 1);


		Scanner in = new Scanner(System.in);
		int memory_point = 0;
		for (boolean flag = true; flag; memory_point++) {
			System.out.print(" : ");
			this.Disease_Symptoms[memory_point] = in.nextLine();
			if (this.Disease_Symptoms[memory_point].compareTo("0") == 0) {
				this.Disease_Symptoms[memory_point] = "";
				flag = false;
			}
		}
		System.out.print(" Ввод завершён\n");
	}

	public void PrintInfo() {
		System.out.printf(" Наименование: %s\n", this.Name_Disease);

		String[] Symptoms;
		Symptoms = this.GetsSymptoms();

		System.out.println(" Симптомы: ");
		for (int memory_point = 0; Symptoms[memory_point].compareTo("") != 0; memory_point++)
			System.out.printf(" [%2d] %s\n", memory_point + 1, Symptoms[memory_point]);
	}

	public String GetsName() {
		return this.Name_Disease;
	}

	public String[] GetsSymptoms() {
		return this.Disease_Symptoms;
	}

	public  void ChangeDeaths(int change){
		number_of_deaths = change;
	}
	public static int GetDeaths() {
		return number_of_deaths;
	}
	public int GetDiseaseDeaths(){
		return number_of_deaths;
	}
}