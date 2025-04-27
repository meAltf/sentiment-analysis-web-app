package com.alataf.learn.ai.sentiment.Controller;

import com.alataf.learn.ai.sentiment.Repository.FeedbackRepository;
import com.alataf.learn.ai.sentiment.service.SentimentAnalysisService;
import com.alataf.learn.ai.sentiment.Entity.Feedback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/spring/ai")
@CrossOrigin(origins = "http://localhost:5173/")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;
    private final SentimentAnalysisService service;

    public FeedbackController(FeedbackRepository feedbackRepository, SentimentAnalysisService service) {
        this.feedbackRepository = feedbackRepository;
        this.service = service;
    }

    /**
     * @return
     */
    @GetMapping("/get/feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }


    /**
     * @param content
     * @return
     */
    @PostMapping("/save/feedback")
    public Feedback saveFeedback(@RequestBody String content) {
        Feedback feedback = service.analyzeFeedback(content);
        return feedbackRepository.save(feedback);
    }
}