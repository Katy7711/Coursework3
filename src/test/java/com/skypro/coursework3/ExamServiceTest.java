package com.skypro.coursework3;

import com.skypro.coursework3.Service.ExaminerServiceImpl;
import com.skypro.coursework3.Service.JavaQuestionService;
import com.skypro.coursework3.Service.QuestionService;
import com.skypro.coursework3.exception.InsufficientQuestionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {

@Mock
private QuestionService questionService;

@InjectMocks
private ExaminerServiceImpl examinerServiceImpl;

@Test
    void whenAmountOfQuestionsIsSufficientThanGetQuestionReturnExactAmount (){
    List <Question> questions = List.of(new Question("Тест1", "1"),
            new Question("Тест2", "2"),
            new Question("Тест3", "3"),
            new Question("Тест4", "4"));
    when(this.questionService.getAll()).thenReturn(questions);
    when(this.questionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(1));
    assertThat(examinerServiceImpl.getQuestion(3)).hasSize(3).containsOnly(questions.get(0),questions.get(1));
}
    @Test
    void whenAmountOfQuestionsIsInSufficientThanGetQuestionReturnExactAmount (){
    when(this.questionService.getAll()).thenReturn(Collections.emptyList());
    assertThatThrownBy(() -> examinerServiceImpl.getQuestion(100)).isInstanceOf(InsufficientQuestionException.class);
    }

}
