package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value= "/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("user",new User());
		return modelAndView;
	}
	
	@ResponseBody
	@PostMapping("/register")
	public String saveUser(@ModelAttribute(name="user") User user) {
		user = userDao.saveUser(user);
		return "User saved with Id: " + user.getId(); 
	}
	
	@RequestMapping(value= "/open-update")
	public ModelAndView openUpdate(ModelAndView modelAndView) {
		modelAndView.setViewName("update");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@ResponseBody
	@PostMapping("/update")
	public String updateUser(@ModelAttribute(name= "user")User user, @RequestParam(name="id")int id) {
		user = userDao.updateUser(user, id);
		return "User updated with ID: " + user.getId();
	}
	
	
	@GetMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}
	
	@GetMapping("/find-by-id")
	public ModelAndView findById(@RequestParam(name="id")int id, ModelAndView modelAndView) {
		User user = userDao.findUserById(id);
		if(user!=null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid User ID");
		return modelAndView;
	}
	
	@GetMapping("/delete-by-id")
	public ModelAndView deleteById(@RequestParam(name="id")int id, ModelAndView modelAndView) {
		boolean flag = userDao.deleteUserById(id);
		if(flag==true) {
			modelAndView.setViewName("delete-display");
			modelAndView.addObject("message", "User deleted");
			return 			modelAndView;
			
			
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message","Invalid User ID");
		return 			modelAndView;
		
	}
	
	@GetMapping("/verify-by-id")
	public ModelAndView verifyUserById(@RequestParam(name="id")int id, @RequestParam(name="password") String password, ModelAndView modelAndView ) {
		User user = userDao.verifyUser(id, password);
		if(user!=null) {
			modelAndView.setViewName("verify");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid credentials");
		return modelAndView;
	}
	
	@GetMapping("/verify-by-phone")
	public ModelAndView verifyUserById(@RequestParam(name="phone")long phone, @RequestParam(name="password") String password, ModelAndView modelAndView ) {
		User user = userDao.verifyUser(phone, password);
		if(user!=null) {
			modelAndView.setViewName("verify");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid credentials");
		return modelAndView;
	}
	
	@GetMapping("/verify-by-email")
	public ModelAndView verifyUserById(@RequestParam(name="email")String email, @RequestParam(name="password") String password, ModelAndView modelAndView ) {
		User user = userDao.verifyUser(email, password);
		if(user!=null) {
			modelAndView.setViewName("verify");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("message", "Invalid credentials");
		return modelAndView;
	}
}
