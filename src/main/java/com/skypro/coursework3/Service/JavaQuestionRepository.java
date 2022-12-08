package com.skypro.coursework3.Service;

import com.skypro.coursework3.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();
    private final static Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }
}
