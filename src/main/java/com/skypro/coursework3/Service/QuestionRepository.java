package com.skypro.coursework3.Service;

import com.skypro.coursework3.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add (String question, String answer);
    Question remove (Question question);
    Collection<Question> getAll();

}
