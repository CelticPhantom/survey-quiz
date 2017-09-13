package com.waycontech.nutriJSF.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.waycontech.nutriJSF.data.Dao;
import com.waycontech.nutriJSF.data.DaoStub;
import com.waycontech.nutriJSF.model.Answer;
import com.waycontech.nutriJSF.model.Question;
import com.waycontech.nutriJSF.ui.QuestionAnswer;

@ManagedBean
@SessionScoped
public class Questions {
	
	private Dao data;
	private int current;
	private List<Question> questions;
	private Question currentQuestion;
	private static Object mutex = null;
	/**
	 * Holds the answer selected by the user
	 */
	private String answer;
	private List<Answer> answers;
	private List<String> answerList;
	
	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}

	/**
	 * QuestionAnswer bean
	 */
	@ManagedProperty(value="#{questionAnswer}")
	private QuestionAnswer questionAnswer;
	
	public QuestionAnswer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(QuestionAnswer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public List<String> getAnwerList() {
		return answerList;
	}

	public static Questions getInstance() {
		if(mutex == null) {
			mutex = new Questions();
			return (Questions)mutex;
		} else {
			return (Questions)mutex;
		}
	}

	public Questions() {
		data = new DaoStub();
		questions = data.getQuestions();
		current = 0;
		currentQuestion = questions.get(current);
		answers = new ArrayList<>();
	}
	
	public Question getCurrentQuestion() {
		currentQuestion = questions.get(current);
		return currentQuestion;
	}
	
	public void goToNextQuestion() {
		current++;
		if(current >= questions.size()) {
			current %= questions.size();
		}
	}
	
	public int getQuestionCount() {
		return questions.size();
	}

	public int getCurrent() {
		return current;
	}
	
	public int getQuestionNum() {
		return questions.get(current).getQuestionNum();
	}
	
	public boolean isLastQuestion() {
		boolean lastQ = false;
		int qNum = currentQuestion.getQuestionNum();
		if(qNum == questions.size()) {
			lastQ = true;
		}
		
		return lastQ;
	}

	/*public void setAnswer(int qNum, String answer) {
		answers.add(new Answer(qNum, answer));
		
	}*/
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String nextQuestion() {
		boolean lastQuestion = isLastQuestion();
		int questionNum = getQuestionNum();
		String answer = questionAnswer.getAnswer();
		Answer saveAns = new Answer(questionNum, answer);
		data.saveAnswer(questionNum, answer);
//		setAnswer(questionNum, answer);
		goToNextQuestion();
		Question question = getCurrentQuestion();
		String questionText = question.getQuestion();
		questionNum = question.getQuestionNum();
		List<String> answerOptions = question.getAnswerOptions();
		questionAnswer.setQuestionText(questionText);
		questionAnswer.setQuestionNum(questionNum);
		questionAnswer.setAnswerOptions(answerOptions);
		questionAnswer.setAnswer("");
		
		String nextPage = "show-question";
		
		if(lastQuestion) {
			nextPage = "completed";
			data.saveAnswers(answers);
			setAnswerList(((DaoStub)data).getAnswerList());
		}
		
		return nextPage;
	}
	
	private void saveAnswers() {
		data.saveAnswers(answers);
		answerList = ((DaoStub)data).getAnswerList();
	}



}
