package com.mintous.coursework2.service;

import com.mintous.coursework2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static com.mintous.coursework2.service.TestUtils.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    void add_shouldAddNewQuestion() {
        //Входные данные
        String answer = FIRST_ANSWER;
        String question = FIRST_QUESTION;

        //Ожидаемый результат
        Question expectedQuestion = getFirstQuestion();

        //Начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void remove_shouldRemoveAddedQuestion() {
        //Входные данные
        String answer = FIRST_ANSWER;
        String question = FIRST_QUESTION;
        Question firstQuestion = new Question(question, answer);

        //Ожидаемый результат
        Set<Question> expectedQuestions = new HashSet<>();

        //Начало теста
        Set<Question> actualQuestion = new HashSet<>();
        actualQuestion.add(firstQuestion);
        actualQuestion.remove(firstQuestion);
        assertEquals(expectedQuestions, actualQuestion);
    }

    @Test
    void getAll_shouldGetAllAddedQuestions() {
        //Входные данные
        String answer = FIRST_ANSWER;
        String question = FIRST_QUESTION;

        String answer2 = SECOND_ANSWER;
        String question2 = SECOND_QUESTION;

        String answer3 = THIRD_ANSWER;
        String question3 = THIRD_QUESTION;

        Question firstQuestion = new Question(question, answer);
        Question secondQuestion = new Question(question2, answer2);
        Question thirdQuestion = new Question(question3, answer3);

        //Ожидаемый результат
        javaQuestionService.add(question, answer);
        javaQuestionService.add(question2, answer2);
        javaQuestionService.add(question3, answer3);

        //Начало теста
        Set<Question> actualQuestions = new HashSet<>();
        actualQuestions.add(firstQuestion);
        actualQuestions.add(secondQuestion);
        actualQuestions.add(thirdQuestion);
        assertIterableEquals(javaQuestionService.getAll(), actualQuestions.stream().toList());
    }
}