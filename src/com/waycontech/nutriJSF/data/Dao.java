package com.waycontech.nutriJSF.data;

import java.util.List;

import com.waycontech.nutriJSF.model.Answer;
import com.waycontech.nutriJSF.model.Question;

public class Dao {
	
	protected List<Question> questionList;
	
	public List<Question> getQuestions() {
		return questionList;
	}

	public void saveAnswers(List<Answer> answers) {
		// TODO Save answers to DB
		
	}

	public void saveAnswer(int questionNum, String answer) {
		// TODO Save single answer to DB
//		System.out.println("Answer to question #" + questionNum +
//				 " = " + answer);
		
	}

}
