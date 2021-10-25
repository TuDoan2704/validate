package com.loginspringboot.API;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginspringboot.Entity.RoleEntity;
import com.loginspringboot.Entity.UserEntity;
import com.loginspringboot.Service.IRoleService;
import com.loginspringboot.Service.IUserService;

@Controller
@RequestMapping("/information")
public class StaffController {
	@Autowired
	IUserService userService;
	@Autowired
	IRoleService roleService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listStaff(ModelMap model) {
		model.addAttribute("list", userService.findAll());
		return "view-staffs";
	}

	@PostMapping("/edit")
	public String saveUser(@Valid @ModelAttribute("user") UserEntity userEntity, BindingResult errors) {
		if (errors.hasErrors()) {
			return "staff";
		}
		userService.save(userEntity);
		return "redirect:/information/list";
	}

	@GetMapping("/")
	public String editStaff(ModelMap model) {
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		model.addAttribute("ACTION", "/information/edit");
		return "staff";
	}

	@RequestMapping("/sua/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Long id) {
		Optional<UserEntity> opUserEntity = userService.findById(id);

		if (opUserEntity.isPresent()) {
			model.addAttribute("user", opUserEntity.get());
		} else {
			model.addAttribute("user", new UserEntity());
		}
		model.addAttribute("ACTION", "/information/edit");
		return "staff";
	}

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Long id) {
		userService.deleteById(id);
		model.addAttribute("list", userService.findAll());
		return "view-staffs";
	}

	@ModelAttribute(name = "Role")
	public List<RoleEntity> getAllRole() {
		return roleService.findAll();
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String erro() {
		return "404";
	}

	@GetMapping("/excep")
	public String failed() {
		return "excep";
	}

}
