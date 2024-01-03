package com.springbootlearning.learnspringboot3.ch2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class HomeController {
	
	private final VideoService videoService;
	
	public HomeController(VideoService videoService) {
		this.videoService = videoService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
	    model.addAttribute("videos", videoService.getVideos());
		//model.addAttribute("videos", videos);		
		return "index";
	}
	

	@PostMapping("/new-video")
	public String newVideo(@ModelAttribute Video newVideo) {
		// The @ModelAttribute upacks the form data to a Video record
		videoService.create(newVideo);
		return "redirect:/"; // not-sure, sends a 302
	}
}
