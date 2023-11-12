package com.mintous.coursework2.service;

import com.mintous.coursework2.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TestUtils {
    public static final String FIRST_QUESTION = "first question";
    public static final String FIRST_ANSWER = "first answer";
    public static final String SECOND_QUESTION = "second question";
    public static final String SECOND_ANSWER = "second answer";
    public static final String THIRD_QUESTION = "third question";
    public static final String THIRD_ANSWER = "third answer";

    public static Question getFirstQuestion(){
        return new Question(FIRST_QUESTION, FIRST_ANSWER);
    }

    public static Question getSecondQuestion(){
        return new Question(SECOND_QUESTION, SECOND_ANSWER);
    }

    public static Question getThirdQuestion(){
        return new Question(THIRD_QUESTION, THIRD_ANSWER);
    }

    public static List<Question> getAllQuestions() {
        return Arrays.asList(getFirstQuestion(),getSecondQuestion(),getThirdQuestion());
    }
}
