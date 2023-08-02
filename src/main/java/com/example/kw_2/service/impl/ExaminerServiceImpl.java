package com.example.kw_2.service.impl;

import com.example.kw_2.exeptions.NotEnoughQuestionException;
import com.example.kw_2.model.Question;
import com.example.kw_2.service.ExaminerService;
import com.example.kw_2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    public final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }


    @Override

    public Collection<Question> getQuestion(int amount) {
        if (amount > service.getAll().size()) {
            throw new NotEnoughQuestionException();
        }

        return Stream.generate(service::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}
