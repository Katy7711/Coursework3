package com.skypro.coursework3.Service;

import com.skypro.coursework3.Question;
import com.skypro.coursework3.exception.InsufficientQuestionException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new InsufficientQuestionException();
        }
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
            return questions;
    }
}

