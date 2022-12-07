package com.skypro.coursework3.Service;

import com.skypro.coursework3.Question;
import com.skypro.coursework3.exception.InsufficientQuestionException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<> ();
    private final static Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
       Question q = new Question(question,answer);
       questions.add(q);
       return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new InsufficientQuestionException();
        }
        return questions.stream().skip(RANDOM.nextInt(0, questions.size())).findFirst().orElseThrow();
    }
}
