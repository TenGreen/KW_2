package com.example.kw_2.service.impl;

import com.example.kw_2.exeptions.QuestionAlreadyExistsException;
import com.example.kw_2.exeptions.QuestionNotFoundException;
import com.example.kw_2.exeptions.StorageIsEmptyException;
import com.example.kw_2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements com.example.kw_2.service.QuestionService {
    private Set<Question> questions = new HashSet<>();
    private static final Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionAlreadyExistsException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new StorageIsEmptyException();
        }
        int index = RANDOM.nextInt(questions.size());
//        ArrayList<Question> list = new ArrayList<>(questions);
        return questions.stream()
                .skip(index)
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
    }


}
