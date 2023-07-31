package com.example.kw_2.service.impl;

import com.example.kw_2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionService implements com.example.kw_2.service.QuestionService {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }


}
