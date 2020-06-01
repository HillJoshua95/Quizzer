
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Quizzer {

	public static int numQuestions=0;
	public static int numCorrect=0;
	public static int numWrong=0;

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public void start(String file) throws Exception {
		countLines(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		int i=0;
		String response = "initial";
		Scanner scan = new Scanner(System.in);
		clearScreen();
		while ((line = br.readLine()) != null) {
			if (i%2==0) {
				System.out.println(line);
				response = new String(scan.nextLine());
				numQuestions++;
			} else {
				if (response.equals(line)) {
					System.out.println(ANSI_GREEN + "Correct!" + ANSI_RESET);
					numCorrect++;
				} else {
					System.out.println(ANSI_RED + "Wrong, it is actually:" + ANSI_RESET);
					System.out.println(line);
					numWrong++;
				}
				System.out.println("Press enter to continue...");
				scan.nextLine();
				clearScreen();
			}
			i++;
		}
		br.close();

		double percentage = ((double)numCorrect/numQuestions)*100;
		String grade = getGrade(percentage);
		System.out.println("Grade: " + grade);
		System.out.println(numCorrect + "/" + numQuestions + "=" + percentage);
	}

	public void printQuestion() {
		String question = "Who is the Steelers Quarterback?";
		System.out.println(question);
	}
	public void getResponse() {
		//
	}
	public void printAnswer() {
		String answer = "Ben Roethlisberger";
		System.out.println(answer);
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void countLines(String file) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
	}

	public String getGrade(double percentage) {
		if (isBetween(percentage, 97, 100)) {
			return ANSI_GREEN+"A+"+ANSI_RESET;
		} else if (isBetween(percentage, 93, 97)) {
			return ANSI_GREEN+"A"+ANSI_RESET;
		} else if (isBetween(percentage, 90, 93)) {
			return ANSI_GREEN+"A-"+ANSI_RESET;
		} else if (isBetween(percentage, 87, 90)) {
			return ANSI_BLUE+"B+"+ANSI_RESET;
		} else if (isBetween(percentage, 83, 87)) {
			return ANSI_BLUE+"B"+ANSI_RESET;
		} else if (isBetween(percentage, 80, 83)) {
			return ANSI_BLUE+"B-"+ANSI_RESET;
		} else if (isBetween(percentage, 77, 80)) {
			return ANSI_YELLOW+"C+"+ANSI_RESET;
		} else if (isBetween(percentage, 73, 77)) {
			return ANSI_YELLOW+"C"+ANSI_RESET;
		} else if (isBetween(percentage, 71, 73)) {
			return ANSI_YELLOW+"C-"+ANSI_RESET;
		} else if (isBetween(percentage, 70, 70)) {
			return "D";
		} else if (isBetween(percentage, 0, 70)) {
			return ANSI_RED+"F"+ANSI_RESET;
		}
		return "Error";
	}

	public static boolean isBetween(double x, double lower, double upper) {
		return lower <= x && x <= upper;
	}
}
