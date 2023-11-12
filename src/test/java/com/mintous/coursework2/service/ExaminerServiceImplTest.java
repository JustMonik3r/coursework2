package com.mintous.coursework2.service;

import com.mintous.coursework2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static com.mintous.coursework2.service.TestUtils.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestions_shouldGetASetAmountOfQuestions() {
        //Входные данные

        when(javaQuestionService.getAll()).thenReturn(getAllQuestions());
        when(javaQuestionService.getRandomQuestion()).thenCallRealMethod();

        //Ожидаемый результат
        Set<Question> expectedResult = new HashSet<>(examinerService.getQuestions(3));

        //Начало теста
        Set<Question> actualResult = new HashSet<>(TestUtils.getAllQuestions());
        assertEquals(expectedResult.size(), 3);
        for (Question question : expectedResult) {
            assertTrue(actualResult.contains(question));
        }
    }
}