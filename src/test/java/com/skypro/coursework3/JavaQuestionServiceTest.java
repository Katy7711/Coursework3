package com.skypro.coursework3;

import com.skypro.coursework3.Service.JavaQuestionService;
import com.skypro.coursework3.exception.InsufficientQuestionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    private List<Question> questions = List.of(new Question("Тест1", "1"),
            new Question("Тест2", "2"),
            new Question("Тест3", "3"),
            new Question("Тест4", "4"));

    @BeforeEach
    public void setUp() {
        this.javaQuestionService = new JavaQuestionService();
        questions.forEach(javaQuestionService::add);
    }
    @Test
    void addQuestionTest(){
        Question question = new Question("Тест5", "5");
        Question actual = this.javaQuestionService.add(question);
        assertThat(actual).isEqualTo(question);
        assertThat(this.javaQuestionService.getAll()).hasSize(5).contains(question);
    }
    @Test
    void removeQuestionTest(){
        Question expected = this.questions.get(0);
        Question actual = this.javaQuestionService.remove(expected);
        assertThat(actual).isEqualTo(expected);
        assertThat(this.javaQuestionService.getAll()).hasSize(3).doesNotContain(expected);
    }
    @Test
    void getRandomQuestion(){
        Question actual = this.javaQuestionService.getRandomQuestion();
        assertThat(actual).isIn(questions);
    }
    @Test
    void getAllTest () {
        assertThat(this.javaQuestionService.getAll()).hasSize(4).containsAll(this.questions);
    }
    @Test
    void whenListIsEmptyThenGetRandomQuestionReturnException (){
        this.javaQuestionService = new JavaQuestionService();
        assertThatThrownBy(() -> javaQuestionService.getRandomQuestion()).isInstanceOf(InsufficientQuestionException.class);
    }
}

