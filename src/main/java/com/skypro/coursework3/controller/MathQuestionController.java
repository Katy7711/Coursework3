package com.skypro.coursework3.controller;

import com.skypro.coursework3.Question;
import com.skypro.coursework3.Service.MathQuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    @Qualifier
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestion () {
        return mathQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion (@RequestParam("question") String question,
                                 @RequestParam ("answer") String answer) {
        return mathQuestionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion (@RequestParam("question") String question,
                                    @RequestParam ("answer") String answer) {
        Question q = new Question(question,answer);
        return mathQuestionService.remove(q);
    }

}
