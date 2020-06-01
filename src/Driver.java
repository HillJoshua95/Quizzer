

public class Driver {
	
	static String file = "/Users/josh/Projects/quizzer/files/question_lists/steelers_offense";

	public static void main(String[] args) throws Exception {
		Quizzer quizzer = new Quizzer();
		quizzer.start(file);
	}

}
