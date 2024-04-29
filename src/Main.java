import java.util.*;

class Question {
	private String question;
	private List<String> options;
	private int correctOption;

	public Question(String question, List<String> options, int correctOption) {
		this.question = question;
		this.options = options;
		this.correctOption = correctOption;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getCorrectOption() {
		return correctOption;
	}
}

class Quiz {
	private List<Question> questions;

	public Quiz() {
		questions = new ArrayList<>();
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void startQuiz() {
		Scanner scanner = new Scanner(System.in);
		int score = 0;

		for (Question question : questions) {
			System.out.println(question.getQuestion());
			List<String> options = question.getOptions();
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i + 1) + ". " + options.get(i));
			}
			System.out.print("Your answer: ");
			int userAnswer = scanner.nextInt();

			if (userAnswer == question.getCorrectOption()) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect!");
			}
		}
		scanner.close();
		System.out.println("Quiz complete!");
		System.out.println("Your score: " + score + "/" + questions.size());
	}
}

public class Main {
	public static void main(String[] args) {
		Quiz quiz = new Quiz();

		Question q1 = new Question("What is the capital of France?",
				Arrays.asList("London", "Paris", "Berlin", "Madrid"), 2);
		Question q2 = new Question("What is the largest planet in our solar system?",
				Arrays.asList("Venus", "Saturn", "Jupiter", "Mars"), 3);
		Question q3 = new Question("Who wrote 'Romeo and Juliet'?",
				Arrays.asList("Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"), 2);

		quiz.addQuestion(q1);
		quiz.addQuestion(q2);
		quiz.addQuestion(q3);

		quiz.startQuiz();
	}
}
