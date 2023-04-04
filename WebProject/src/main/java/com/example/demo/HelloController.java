package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public void sayHello()
	{
		System.out.println("Helloo world");
	}
	@RequestMapping(value = "hello2",method = RequestMethod.GET)
	public String sayHello2()
	{
		System.out.println("Hello2 is called");
		return "Welcome";
	}
	@RequestMapping(value = "hello3",method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3()
	{
		return ResponseEntity.ok("Hai and Welcome to MVC");
	}
	@RequestMapping(value = "hello4",method = RequestMethod.GET)
	public ModelAndView sayHello4()
	{
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("mykey", "Welcome to Spring mvc3 from injected object...");
		mandv.setViewName("Welcome1");
		return mandv;
	}
	@RequestMapping(value = "hello5",method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mandv)
	{
		mandv.addObject("mykey", "Welcome to Spring mvc4 from injected object...");
		mandv.setViewName("Welcome1");
		return mandv;
	}
	@RequestMapping(value = "hello6",method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv,HttpServletRequest request)
	{
		mandv.addObject("mykey","welcome to spring from SayHello6....");
		mandv.setViewName("Welcome1");
		HttpSession session = request.getSession();
		request.setAttribute("hello", "Hello World from request 6 Object");
		session.setAttribute("hello2", "Hello from session object");
		return mandv;
	}
	@RequestMapping(value = "repeat",method = RequestMethod.GET)
	public ModelAndView sayHello7(ModelAndView mandv,HttpServletRequest request)
	{
		mandv.addObject("mykey","welcome to spring from Repeat....");
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}
	@RequestMapping(value = "hello7/{id}", method = RequestMethod.GET)
	public ModelAndView sayHello8(@PathVariable String name,ModelAndView mandv,HttpServletRequest request) {
//		ApplicationContext ctx = SpringApplication.run(WebProjectApplication.class, args);;
//		MyService mtx = MyService.getBean("myService",MyService.class);
		
		mandv.addObject("mykey",name);
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}
	@RequestMapping(value = "hello8", method = RequestMethod.GET)
	public ModelAndView sayHello9(@RequestParam("uname") String name,ModelAndView mandv,HttpServletRequest request) {
		mandv.addObject("mykey",name);
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}
	@RequestMapping(value ="hello9",method = RequestMethod.GET)
	public ResponseEntity<User> sayHello11()
	{
		User user= new User();
		user.setUid(100);
		user.setUsername("Hareesh");
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello10",method = RequestMethod.POST)
	public ResponseEntity<User> sayHello12(@RequestBody User user)
	{
		user.setUid(1000000);
		user.setUsername("raj");
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello11",method = RequestMethod.POST)
	public User sayHello13(@RequestBody User user)
	{
		user.setUid(500);
		user.setUsername("Hareesh Raj");
		return user;
	}
	@RequestMapping(value="hello12",method = RequestMethod.GET)
	public ModelAndView sayHello14(@MatrixVariable String name,ModelAndView mandv)
	{
		mandv.addObject("mykey",name);
		mandv.setViewName("welcome1");
		return mandv;
	}
}
