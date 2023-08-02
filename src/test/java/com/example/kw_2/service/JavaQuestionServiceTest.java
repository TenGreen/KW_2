package com.example.kw_2.service;

import com.example.kw_2.model.Question;
import com.example.kw_2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    JavaQuestionService service = new JavaQuestionService();
    Question q1 = new Question("zaq", "qaz");
    Question q2 = new Question("xsw", "wsx");
    Collection<Question> actual;

    @BeforeEach
    void createQuestion() {
        service.add(q1);
        service.add(q2);
        actual = service.getAll();
    }

    @Test
    void add() {

        assertEquals(2, actual.size());
        assertTrue(actual.contains(q1));
        assertTrue(actual.contains(q2));
    }

    @Test
    void remove() {
        service.remove(q1);
        assertEquals(1, actual.size());
        assertFalse(actual.contains(q1));
        assertTrue(actual.contains(q2));
    }
}
