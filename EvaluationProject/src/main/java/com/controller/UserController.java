package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.FormData;
import com.example.demo.InsufficientBalanceException;
import com.example.demo.InvalidUserException;
import com.service.*;
import com.model.*;
/*
 * The request that are come with url '/user' is handled by the class
 * UserController.
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserInterfaceImplementation userService;

	public UserInterfaceImplementation getUserService() {
		return userService;
	}

	public void setUserService(UserInterfaceImplementation userService) {
		this.userService = userService;
	}

	/*
	 * @param ModelAndView modelAndView. This function will handle the request for
	 * the url '/menu' menu.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public ModelAndView menuPage(ModelAndView modelAndView) {
		modelAndView.setViewName("menu");
		return modelAndView;
	}

	/*
	 * @param ModelAndView modelAndView. This function will handle the request for
	 * the url '/create' UserSuccessPage.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView insertUser(UserDTO userDTO) {
		ModelAndView modelAndView = new ModelAndView();
		if(getUserService().isExists(userDTO.getId()))
		{
			modelAndView.setViewName("ExistingUser");
		}
		else
		{
			getUserService().createUser(userDTO);
			modelAndView.setViewName("UserSuccessPage");
		}		
		return modelAndView;
	}

	/*
	 * @param FormData formData. This function will handle the request for the url
	 * '/get' and for post method type. we are adding the data as a object in the
	 * modelAndView object and returning the view as a response. displayUser.jsp
	 * will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "get", method = RequestMethod.POST)
	public ModelAndView getUser(FormData formData) {
		ModelAndView modelAndView = new ModelAndView();
		if(getUserService().isExists(formData.getCreditID()))
		{
			UserDTO userDTO = getUserService().getUser(formData.getCreditID());
			modelAndView.addObject("balance", userDTO.getBalance());
			modelAndView.addObject("id", userDTO.getId());
			modelAndView.addObject("username", userDTO.getName());
			modelAndView.setViewName("displayUser");
		}
		else
		{
			modelAndView.setViewName("invalidUser");
		}
		
		return modelAndView;

	}

	/*
	 * This function will handle the request for the url '/get' and for type get. we
	 * are adding the data as a object in the modelAndView object and returning the
	 * view as a response. getuser.jsp will be loaded in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public ModelAndView getUser1() {
		FormData formData = new FormData();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("getuser");
		return modelAndView;
	}

	/*
	 * @param FormData data. This function will handle the request for the url
	 * '/transfer' and for type get. If transfer is success successtransfer.jsp will
	 * be loaded in the page. If transfer is failed UserErrorPage.jsp will be loaded
	 * in the page.
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public ModelAndView moneyTransfer(FormData data) {
		try {
			getUserService().moneyTransfer(data.getCreditID(), data.getDebitID(), data.getAmount());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("successtransfer");
			return modelAndView;
		} catch (InvalidUserException | InsufficientBalanceException e) {

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("UserErrorPage");
			return modelAndView;
		}
	}

	/*
	 * @param ModelAndView modelAndView. This function will handle the request for
	 * the url '/createForm'
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "createForm", method = RequestMethod.GET)
	public ModelAndView setStudent(ModelAndView modelAndView) {
		UserDTO userdto = new UserDTO();
		modelAndView.addObject("user", userdto);
		modelAndView.setViewName("forms");
		return modelAndView;
	}

	/*
	 * @param ModelAndView modelAndView. This function will handle the request for
	 * the url '/success'
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public ModelAndView sucess(ModelAndView modelAndView) {
		modelAndView.setViewName("UserSuccessPage");
		return modelAndView;
	}

	/*
	 * @param ModelAndView modelAndView. This function will handle the request for
	 * the url '/success'
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "moneytransfer", method = RequestMethod.GET)
	public ModelAndView moneytransfer(ModelAndView modelAndView) {
		FormData formData = new FormData();
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("moneytransfer");
		return modelAndView;
	}
}
