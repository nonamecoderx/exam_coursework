package com.example.exam.service;

import com.example.exam.model.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getQuestions(int amount);
}
