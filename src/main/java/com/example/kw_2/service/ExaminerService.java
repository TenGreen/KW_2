package com.example.kw_2.service;

import com.example.kw_2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount );
}
