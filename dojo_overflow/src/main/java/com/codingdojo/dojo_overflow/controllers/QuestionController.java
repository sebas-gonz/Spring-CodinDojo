package com.codingdojo.dojo_overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojo_overflow.models.Answer;
import com.codingdojo.dojo_overflow.models.Question;
import com.codingdojo.dojo_overflow.models.Tag;
import com.codingdojo.dojo_overflow.services.AnswerService;
import com.codingdojo.dojo_overflow.services.QuestionService;
import com.codingdojo.dojo_overflow.services.TagService;

import jakarta.validation.Valid;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private TagService tagService;

	@Autowired
	private AnswerService answerService;

	@GetMapping("/question/new")
	public String newQuestion(@ModelAttribute("quest") Question question) {

		return "views/new_question.jsp";
	}

	@PostMapping("/question/new")
	public String createQuestion(@Valid @ModelAttribute("quest") Question question, BindingResult result,
			@RequestParam("tags") String tags, Model model) {

		List<String> tagsQuest = Arrays.asList((tags.split("\\s*,\\s*")));

		if (tagsQuest.size() > 3) {
			return "views/new_question.jsp";
		}

		if (result.hasErrors()) {
			return "views/new_question.jsp";
		}

		model.addAttribute("error", false);
		List<Tag> tagsList = new ArrayList<>();
		for (String tagSubject : tagsQuest) {
			Tag existingTag = tagService.findBySubject(tagSubject);
			if (existingTag != null) {
				tagsList.add(existingTag);

			} else {
				Tag newTag = new Tag(tagSubject);
				tagService.createTag(newTag);
				tagsList.add(newTag);
			}
		}
		question.setTag(tagsList);
		questionService.createQuestion(question);

		return "redirect:/question/" + question.getId();

	}

	@GetMapping("/question/{id}")
	public String newAnswer(@ModelAttribute("reply") Answer answer, @PathVariable("id") Long id, Model model) {
		model.addAttribute("question", questionService.findQuestion(id));
		model.addAttribute("tag", questionService.findQuestion(id).getTag());

		return "views/new_answer.jsp";

	}

	@PostMapping("/question/{questionId}")
	public String createAnswer(@Valid @ModelAttribute("reply") Answer answer, BindingResult result,
			@PathVariable("questionId") Long questionId, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", questionService.findQuestion(questionId));
			model.addAttribute("tag", questionService.findQuestion(questionId).getTag());
			return "views/new_answer.jsp";
		}
		answer.setQuestion(questionService.findQuestion(questionId));
		answerService.createAnswer(answer);

		return "redirect:/";

	}
}
