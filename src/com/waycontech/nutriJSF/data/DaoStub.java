package com.waycontech.nutriJSF.data;

import java.util.ArrayList;
import java.util.List;

import com.waycontech.nutriJSF.model.Answer;
import com.waycontech.nutriJSF.model.Question;

public class DaoStub extends Dao {
	
	private List<String> answerList = new ArrayList<>();
	
	public List<Question> getQuestions() {
		List<String> answer1Options = new ArrayList<>();
		answer1Options.add("Male");
		answer1Options.add("Female");
		Question question1 = new Question(1, 
				"What is your gender?", answer1Options);
		
		List<String> answer2Options = new ArrayList<>();
		answer2Options.add("18 - 30");
		answer2Options.add("31 - 45");
		answer2Options.add("46 - 60");
		answer2Options.add("61+");
		Question question2 = new Question(2, 
				"What is your age?", answer2Options);
		
		List<String> answer3Options = new ArrayList<>();
		answer3Options.add("Family");
		answer3Options.add("Single");
		Question question3 = new Question(3, 
				"What is your family status?", answer3Options);
		
		List<String> answer4Options = new ArrayList<>();
		answer4Options.add("Yes");
		answer4Options.add("No");
		Question question4 = new Question(4, 
				"Do you own a smartphone?", answer4Options);
		
		List<String> answer5Options = new ArrayList<>();
		answer5Options.add("Yes");
		answer5Options.add("No");
		Question question5 = new Question(5, 
				"Do you use mobile apps?", answer5Options);
		
		List<String> answer6Options = new ArrayList<>();
		answer6Options.add("Yes");
		answer6Options.add("No");
		Question question6 = new Question(6, 
				"Have you used a Health/Cooking app?", answer6Options);
		
		List<String> answer7Options = new ArrayList<>();
		answer7Options.add("Fitness");
		answer7Options.add("Health Advice/Monitoring");
		answer7Options.add("Nutrition");
		answer7Options.add("Recipe/Cooking");
		answer7Options.add("Weight Loss");
		Question question7 = new Question(7, 
				"What kind of health/food app?", answer7Options);
		
		List<String> answer8Options = new ArrayList<>();
		answer8Options.add("Yes");
		answer8Options.add("No");
		Question question8 = new Question(8, 
				"Did you pay for these apps?", answer8Options);
		
		List<String> answer9Options = new ArrayList<>();
		answer9Options.add("One off fee");
		answer9Options.add("Subscription");
		answer9Options.add("Both");
		Question question9 = new Question(9, 
				"Did you pay a one-off fee, or subscription or both?", answer9Options);
		
		List<String> answer10Options = new ArrayList<>();
		answer10Options.add("Annually");
		answer10Options.add("Monthly");
		answer10Options.add("Weekly");
		Question question10 = new Question(10, 
				"How often did you pay the fee?", answer10Options);
		
		questionList = new ArrayList<>();
		questionList.add(question1);
		questionList.add(question2);
		questionList.add(question3);
		questionList.add(question4);
		questionList.add(question5);
		questionList.add(question6);
		questionList.add(question7);
		questionList.add(question8);
		questionList.add(question9);
		questionList.add(question10);
		
		return questionList;
	}

	@Override
	public void saveAnswers(List<Answer> answers) {
		// TODO Auto-generated method stub
		super.saveAnswers(answers);
		
		for(Answer answer : answers) {
			answerList.add(answer.getAnswer());
		}
	}
	
	@Override
	public void saveAnswer(int questionNum, String answer) {
		// TODO Auto-generated method stub
		super.saveAnswer(questionNum, answer);
		answerList.add(answer);
	}

	public List<String> getAnswerList() {
		return answerList;
	}
	
	

}
