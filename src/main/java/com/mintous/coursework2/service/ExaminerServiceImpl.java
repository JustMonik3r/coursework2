package com.mintous.coursework2.service;

import com.mintous.coursework2.exceptions.NotEnoughQuestionsException;
import com.mintous.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int requestedAmountOfQuestions) {
        if (questionService.getAll().size() < requestedAmountOfQuestions) {
            throw new NotEnoughQuestionsException("Запрошено слишком большое число вопросов. Количество запрошенных вопросов не может превышать " + questionService.getAll().size());
        }
        Collection<Question> totalAmountOfQuestions = new HashSet<>();
        while (totalAmountOfQuestions.size() < requestedAmountOfQuestions) {
            totalAmountOfQuestions.add(questionService.getRandomQuestion());
        }
        return totalAmountOfQuestions;
    }
}
