package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserInterfaceImpl userService;

	public UserInterfaceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserInterfaceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public ModelAndView menuPage(ModelAndView modelAndView) {
		modelAndView.setViewName("menu");
		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView createUser(UserDTO user) {
		getUserService().createUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserSuccessPage");
		return modelAndView;
	}

	@RequestMapping(value = "get", method = RequestMethod.POST)
	public ModelAndView getUser(FormData formData) {

		UserDTO userDTO = getUserService().getUser(formData.getCreditID());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("balance", userDTO.getBalance());
		modelAndView.addObject("id", userDTO.getId());
		modelAndView.addObject("username", userDTO.getName());
		modelAndView.setViewName("displayUser");
		return modelAndView;

	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public ModelAndView getUser1() {
		FormData formData = new FormData();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("getuser");
		return modelAndView;
	}

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

	@RequestMapping(value = "createForm", method = RequestMethod.GET)
	public ModelAndView setStudent(ModelAndView modelAndView) {
		UserDTO userdto = new UserDTO();
		modelAndView.addObject("user", userdto);
		modelAndView.setViewName("forms");
		return modelAndView;
	}

	@RequestMapping(value = "success", method = RequestMethod.GET)
	public ModelAndView sucess(ModelAndView modelAndView) {
		modelAndView.setViewName("UserSuccessPage");
		return modelAndView;
	}

	@RequestMapping(value = "moneytransfer", method = RequestMethod.GET)
	public ModelAndView moneytransfer(ModelAndView modelAndView) {
		FormData formData = new FormData();
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("moneytransfer");
		return modelAndView;
	}
}
