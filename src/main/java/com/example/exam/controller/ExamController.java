package com.example.exam.controller;

import com.example.exam.exception.IncorrectQuestionsNumber;
import com.example.exam.model.Question;
import com.example.exam.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExamService examService;

    @ExceptionHandler(IncorrectQuestionsNumber.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.badRequest().body("Недостаточно воопросов");
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examService.getQuestions(amount);
    }

    public ExamController(ExamService examService) {
        this.examService = examService;
    }
}
