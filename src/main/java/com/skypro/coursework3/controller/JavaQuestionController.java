package com.skypro.coursework3.controller;

import com.skypro.coursework3.Question;
import com.skypro.coursework3.Service.JavaQuestionService;
import com.skypro.coursework3.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestion () {
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion (@RequestParam("question") String question,
                                 @RequestParam ("answer") String answer) {
        return javaQuestionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion (@RequestParam("question") String question,
                                    @RequestParam ("answer") String answer) {
        Question q = new Question(question,answer);
        return javaQuestionService.remove(q);
    }



}
