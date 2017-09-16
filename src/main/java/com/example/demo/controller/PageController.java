package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
	/*@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model){
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/greeting/{name}")
	public String greetingPath (@PathVariable String name, Model model){
		model.addAttribute("name", name);
		return "greeting";
	}*/
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
			if(name.isPresent()){
				model.addAttribute("name", name.get());
			} else {
				model.addAttribute("name", "dengklek");
			}
			return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value = "a", required = false, defaultValue = "0") Integer a, 
			@RequestParam(value = "b", required = false, defaultValue = "0") Integer b, Model model){
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", a*b);
		
		return "perkalian";
	}
	/*@RequestMapping(value = {"/perkalian", "perkalian/{a}", "perkalian/{b}", "perkalian/{a}/{b}"})
	public String perkalianPath(@PathVariable Optional<Integer> a, @PathVariable Optional<Integer> b, Model model) {
			
			if(a.isPresent()){
				if(b.isPresent()){
					model.addAttribute("a", a.get());
					model.addAttribute("b", b.get());
					model.addAttribute("c", a.get()*b.get());
				} else{
					model.addAttribute("a", a.get());
					model.addAttribute("b", 0);
					model.addAttribute("c", a.get()*0);
				}
			} else if(b.isPresent()){
				if(a.isPresent()){
					model.addAttribute("a", a.get());
					model.addAttribute("b", b.get());
					model.addAttribute("c", a.get()*b.get());
				} else{
					model.addAttribute("b", a.get());
					model.addAttribute("a", 0);
					model.addAttribute("c", 0*b.get());
				}
			} else {
				model.addAttribute("a", 0);
				model.addAttribute("b", 0);
				model.addAttribute("c", 0);
			}
			
			return "perkalian";
	}*/
	
	
}


