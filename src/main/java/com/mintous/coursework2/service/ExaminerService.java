package com.mintous.coursework2.service;

import com.mintous.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int size);

}
