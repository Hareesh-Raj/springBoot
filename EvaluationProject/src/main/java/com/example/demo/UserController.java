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
	private UserInterfaceImpl user;
	
	public UserInterfaceImpl getUser() {
		return user;
	}

	public void setUser(UserInterfaceImpl user) {
		this.user = user;
	}

	@RequestMapping(value = "create",method = RequestMethod.POST)
	public ModelAndView createUser(UserDTO user)
	{
	 	getUser().createUser(user);
	 	ModelAndView mandv = new ModelAndView();
	 	mandv.setViewName("UserSuccessPage");
		return mandv;
	}
	@RequestMapping(value = "get",method = RequestMethod.POST)
	public ModelAndView getUser(FormData data)
	{
		
		 UserDTO dto = getUser().getUser(data.getCrid());
//		 UserDTO dto = getUser().getUser()
		 ModelAndView mandv = new ModelAndView();
		 mandv.addObject("balance",dto.getBalance());
		 mandv.addObject("id",dto.getId());
		 mandv.addObject("username",dto.getName());
		 	mandv.setViewName("displayUser");
			return mandv;
		
	}
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public ModelAndView getUser1()
	{
		FormData data = new FormData();
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("data", data);
		mandv.setViewName("getuser");
		return mandv;
	}
	@RequestMapping(value = "transfer",method = RequestMethod.POST)
	public ModelAndView moneyTransfer(FormData data)
	{
		try {
			 getUser().moneyTransfer(data.getCrid(),data.getDbid(),data.getAmount());
			 ModelAndView mandv = new ModelAndView();
			 	mandv.setViewName("UserSuccessPage");
				return mandv;
		} catch (InvalidUserException | InsufficientBalance e) {
			
			ModelAndView mandv = new ModelAndView();
		 	mandv.setViewName("UserErrorPage");
			return mandv;
		}
	}
	@RequestMapping(value = "createForm",method = RequestMethod.GET)
	public ModelAndView setStudent(ModelAndView mandv) {
		UserDTO user = new UserDTO();
		mandv.addObject("user", user);
		mandv.setViewName("forms");
		return mandv;
	}
	@RequestMapping(value = "success",method = RequestMethod.GET)
	public ModelAndView sucess(ModelAndView mandv) {
		mandv.setViewName("UserSuccessPage");
		return mandv;
	}
	@RequestMapping(value = "menu",method = RequestMethod.GET)
	public ModelAndView menuPage(ModelAndView mandv)
	{
		mandv.setViewName("menu");
		return mandv;
	}
	@RequestMapping(value = "moneytransfer",method = RequestMethod.GET)
	public ModelAndView moneytransfer(ModelAndView mandv)
	{
		FormData data =new FormData();
		mandv.addObject("data", data);
		mandv.setViewName("moneytransfer");
		return mandv;
	}
}
