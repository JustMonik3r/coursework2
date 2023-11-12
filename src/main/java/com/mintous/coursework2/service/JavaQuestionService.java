package com.mintous.coursework2.service;

import com.mintous.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemoval = new Question(question, answer);
        questions.remove(questionForRemoval);
        return questionForRemoval;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        //question = null;
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int index = new Random().nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(index);
    }
}
