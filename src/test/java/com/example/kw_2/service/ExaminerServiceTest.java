package com.example.kw_2.service;

import com.example.kw_2.model.Question;
import com.example.kw_2.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private List<Question> questions = List.of(
            new Question("qaz", "zaq"),
            new Question("wsx", "xsw"),
            new Question("edc", "cde")
    );

    @Test
    void getQuestions() {
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(2))
                .thenReturn(questions.get(2))
                .thenReturn(questions.get(1))
                .thenReturn(questions.get(3))
                .thenReturn(questions.get(2));

        Collection<Question> actual = examinerService.getQuestion(3);
        assertEquals(3, actual.size());
        assertTrue(questions.containsAll(actual));
    }


}
