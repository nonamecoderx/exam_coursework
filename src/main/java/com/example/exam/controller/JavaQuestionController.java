package com.example.exam.controller;

import com.example.exam.model.Question;
import com.example.exam.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

    @RestController
    @RequestMapping("/java")
    public class JavaQuestionController {

        private final com.example.exam.service.JavaQuestionService javaQuestionService;

        public JavaQuestionController(JavaQuestionService javaQuestionService) {
            this.javaQuestionService = javaQuestionService;
        }


        @GetMapping("/add")
        public Question add(@RequestParam("question") String question,
                                    @RequestParam("answer") String answer){
            return this.javaQuestionService.add(question, answer);
        }

        @GetMapping
        public Collection<Question> getQuestions(){
            return this.javaQuestionService.getAll();
        }

        @GetMapping("/remove")
        public Question removeQuestion(@RequestParam("question") String question,
                                       @RequestParam("answer") String answer){
            Question q = new Question(question, answer);
            return this.javaQuestionService.remove(q);
        }
    }

