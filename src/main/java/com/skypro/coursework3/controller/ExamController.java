package com.skypro.coursework3.controller;

import com.skypro.coursework3.Question;
import com.skypro.coursework3.Service.ExaminerService;
import com.skypro.coursework3.Service.ExaminerServiceImpl;
import com.skypro.coursework3.exception.InsufficientQuestionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    @ExceptionHandler (InsufficientQuestionException.class)
    public ResponseEntity<String> handleException(){
        return ResponseEntity.badRequest().body("Недостаточно вопросов");
    }

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerServiceImpl = examinerService;
    }

    @GetMapping ("/{amount}")
    public Collection<Question> getQuestions (@PathVariable ("amount") int amount) {
        return examinerServiceImpl.getQuestion(amount);
    }
}
