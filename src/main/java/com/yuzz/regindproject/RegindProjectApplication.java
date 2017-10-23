package com.yuzz.regindproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class RegindProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegindProjectApplication.class, args);
	}

	static List<Map<String,String>> list = new ArrayList<>();


	@RequestMapping("in")
	public ModelAndView getIn(){
		ModelAndView modelAndView = new ModelAndView("registe");
		return modelAndView;
	}

	@RequestMapping("registe")
	public ModelAndView registe(String acc,String password){
		System.out.printf(acc+password);
		ModelAndView modelAndView = new ModelAndView("registe");
		Map<String,String> user = new HashMap<>();
		user.put("acc",acc);
		user.put("password",password);
		list.add(user);
		System.out.printf(String.valueOf(list.size()));

		/*hsr.getSession().setAttribute("user",list);*/
		return modelAndView;
	}

	@RequestMapping("go")
	public ModelAndView go(){
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("index")
	public ModelAndView index(String acc,String password){
		ModelAndView modelAndView = new ModelAndView();
		System.out.printf(String.valueOf(list.size()));
		/*List<Map<String,String>> list= (List) hsr.getSession().getAttribute("list");*/
		for (int i = 0; i < list.size(); i++) {
			if(acc.equals(list.get(i).get("acc"))&&password.equals(list.get(i).get("password"))){
				System.out.printf("登陆成功!");
				modelAndView.setViewName("success");
				break;
			}
			modelAndView.setViewName("index");

		}
		modelAndView.addObject("acc",acc);
		modelAndView.addObject("user",list);
		return modelAndView;
	}

}
