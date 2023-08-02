package com.example.kw_2.controller;

import com.example.kw_2.model.Question;
import com.example.kw_2.service.impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam (name = "question")String question,
                        @RequestParam (name = "answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remowe")
    public Question remove(@RequestParam (name = "question")String question,
                           @RequestParam (name = "answer") String answer) {

        return service.remove(new Question(question,answer));
    }

}
