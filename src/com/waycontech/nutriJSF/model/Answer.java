package com.waycontech.nutriJSF.model;

public class Answer {
	
	private int questionNum;
	private String answer;
	
	public Answer(int qNum, String answer) {
		questionNum = qNum;
		this.answer = answer;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public String getAnswer() {
		return answer;
	}
	
	

}
