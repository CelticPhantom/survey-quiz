package com.waycontech.nutriJSF.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.waycontech.nutriJSF.controller.Questions;
import com.waycontech.nutriJSF.model.Question;

@ManagedBean(name = "questionAnswer")
@SessionScoped
public class QuestionAnswer {
	
	private Question question;
	private String questionText;
	private int questionNum;
	private List<String> answerOptions;
	private int questionCount;
	
	/**
	 * Controller
	 */
	private Questions questions;
	
	/**
	 * Holds the answer selected by the user
	 */
	private String answer;
	
	public QuestionAnswer() {
		questions = Questions.getInstance();
		questionCount = questions.getQuestionCount();
		question = questions.getCurrentQuestion();
		questionNum = question.getQuestionNum();
		questionText = question.getQuestion();
		answerOptions = question.getAnswerOptions();
		/*questionText = "Is this a question?";
		answerOptions = new ArrayList<>();
		answerOptions.add("Yes");
		answerOptions.add("No");
		answerOptions.add("Maybe!");*/
	}
	
	/*public String nextQuestion() {
		boolean lastQuestion = questions.isLastQuestion();
		questions.setAnswer(questionNum, answer);
		questions.nextQuestion();
		question = questions.getCurrentQuestion();
		questionNum = question.getQuestionNum();
		questionText = question.getQuestion();
		answerOptions = question.getAnswerOptions();
		
		String nextPage = "show-question";
		
		if(lastQuestion) {
			nextPage = "completed";
		}
		
		return nextPage;
	}*/

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public int getQuestionCount() {
		return questionCount;
	}

}
