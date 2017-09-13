package com.waycontech.nutriJSF.model;

import java.util.List;

public class Question {
	
	private String question;
	private int questionNum;
	private List<String> answerOptions;
	
	public Question(int number, String question, List<String> answers) {
		questionNum = number;
		this.question = question;
		answerOptions = answers;
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public List<String> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}
	
	

}
