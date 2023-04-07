package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
/*
 * The request that are come with url '/hello' is handled by the class
 * HelloContainer.
 */
@RequestMapping("/hello")
public class HelloController {
	/*
	 * This function will handle the request for the url '/hello1'. this function
	 * will print in console.
	 */
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Helloo world");
	}

	/*
	 * This function will handle the request for the url '/hello2'. this function
	 * will print in console.
	 * 
	 * @return String.
	 */
	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("Hello2 is called");
		return "Welcome";
	}

	/*
	 * This function will handle the request for the url '/hello3'.
	 * 
	 * @return ResponseEntity of type String.
	 */
	@RequestMapping(value = "hello3", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3() {
		return ResponseEntity.ok("Hai and Welcome to MVC");
	}

	/*
	 * This function will handle the request for the url '/hello4'. we are adding
	 * the object to the modelandview object. and the welcome1.jsp will be loaded in
	 * the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("mykey", "Welcome to Spring mvc3 from injected object...");
		mandv.setViewName("Welcome1");
		return mandv;
	}

	/*
	 * @param ModelAndView mandv. This function will handle the request for the url
	 * '/hello5'. without creating the new object the spring will open a object of
	 * modelnadview. we are adding the object to the modelandview object. and the
	 * welcome1.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello5", method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mandv) {
		mandv.addObject("mykey", "Welcome to Spring mvc4 from injected object...");
		mandv.setViewName("Welcome1");
		return mandv;
	}

	/*
	 * @param ModelAndView mandv, HttpServletRequest request. This function will
	 * handle the request for the url '/hello6'. without creating the new object the
	 * spring will open a object of modelnadview. we are adding the object to the
	 * modelandview object. and the welcome1.jsp will be loaded in the page. we are
	 * cretaing a session object and and setting the attribute in the session. and
	 * we are creating a request object and setting the attribute.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello6", method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey", "welcome to spring from SayHello6....");
		mandv.setViewName("Welcome1");
		HttpSession session = request.getSession();
		request.setAttribute("hello", "Hello World from request 6 Object");
		session.setAttribute("hello2", "Hello from session object");
		return mandv;
	}

	/*
	 * @param ModelAndView mandv, HttpServletRequest request. This function will
	 * handle the request for the url '/hello7'. In this we are checking whether
	 * session attribute is available in various request which is set in the above
	 * function.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "repeat", method = RequestMethod.GET)
	public ModelAndView sayHello7(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey", "welcome to spring from Repeat....");
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}

	/*
	 * @param String name, ModelAndView mandv, HttpServletRequest request. This
	 * function will handle the request for the url '/hello7{name}'. In this we are
	 * getting the string in the path and we are manipulating the string.
	 * welcome1.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello7/{name}", method = RequestMethod.GET)
	public ModelAndView sayHello8(@PathVariable String name, ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey", name);
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}

	/*
	 * @param String name,ModelAndView mandv, HttpServletRequest request. This
	 * function will handle the request for the url '/hello8'. In this we are
	 * getting the string in the request param and we are manipulating the string.
	 * welcome1.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello8", method = RequestMethod.GET)
	public ModelAndView sayHello9(@RequestParam("uname") String name, ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey", name);
		mandv.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return mandv;
	}

	/*
	 * This function will handle the request for the url '/hello9'. In this we are
	 * getting the string in the request param and we are manipulating the string.
	 * we are creating the user object and setting the value and returning it.
	 * 
	 * @return ResponseEntity<User>.
	 */
	@RequestMapping(value = "hello9", method = RequestMethod.GET)
	public ResponseEntity<User> sayHello11() {
		User user = new User();
		user.setUserID(100);
		user.setUsername("Hareesh");
		return ResponseEntity.ok(user);
	}

	/*
	 * @param User user. This function will handle the request for the url
	 * '/hello10'. In this we are getting the string in the request param and we are
	 * manipulating the string. we are setting the value and returning it.
	 * 
	 * @return ResponseEntity<User>.
	 */
	@RequestMapping(value = "hello10", method = RequestMethod.POST)
	public ResponseEntity<User> sayHello12(@RequestBody User user) {
		user.setUserID(1000000);
		user.setUsername("raj");
		return ResponseEntity.ok(user);
	}

	/*
	 * @param User user. This function will handle the request for the url
	 * '/hello11'. In this we are getting the string in the request param and we are
	 * manipulating the string. we are setting the value and returning it.
	 * 
	 * @return User.
	 */
	@RequestMapping(value = "hello11", method = RequestMethod.POST)
	public User sayHello13(@RequestBody User user) {
		user.setUserID(500);
		user.setUsername("Hareesh Raj");
		return user;
	}

	/*
	 * @param int id, String name, ModelAndView mandv. This function will handle the
	 * request for the url '/hello12/{id}'. In this we are getting the string in the
	 * request param and we are manipulating the string. we are setting the value
	 * and returning it.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "hello12/{id}", method = RequestMethod.GET)
	public ModelAndView sayHello14(@PathVariable int id, @MatrixVariable String name, ModelAndView mandv) {
		System.out.println(id);
		mandv.addObject("mykey", name);
		mandv.setViewName("welcome1");
		return mandv;
	}
}
