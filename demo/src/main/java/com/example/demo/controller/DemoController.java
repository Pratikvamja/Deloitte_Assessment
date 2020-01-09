package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class DemoController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String welcome()

	{
		return "index";
	}
	
	@RequestMapping("/login")
	public ModelAndView requestLogin(@RequestParam String user, @RequestParam String password)
	{
		ModelAndView modelAndView;
		if ((user.equals("user")) && (password.equals("password"))) {
			modelAndView = new ModelAndView("home");
		} else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;
	}
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addEmpGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("addEmp");
		Employee e=new Employee();
		mv.addObject("emp", e);
		return mv;
	}
	
	@PostMapping("/addEmp")
	public ModelAndView addEmpPost(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.addNewEmployee(e));
		return mv;
	}
	@GetMapping("/allEmp")
	public ModelAndView allEmp()throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.listEmployees();
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/printEmployee")
	public ModelAndView print(@RequestParam("id")Long id)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		Employee e=new Employee();
		mv.addObject("emps",e);
		return mv;
	}
	
	@GetMapping("/updateEmp")
	public ModelAndView updateEmpGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("updateEmp");
		Employee e=new Employee();
		mv.addObject("emp", e);
		return mv;
	}
	
	@PostMapping("/updateEmp")
	public ModelAndView updateEmpPost(@ModelAttribute("emp")Employee e)throws Exception{
		ModelAndView mv=new ModelAndView("updateEmp");
		mv.addObject("emp",employeeService.addNewEmployee(e));
		return mv;
	}
	
	@GetMapping("/deleteEmp")
	public ModelAndView deleteEmpGet() throws Exception{
		Employee e=new Employee();
		ModelAndView mv=new ModelAndView("deleteEmp");
		mv.addObject("emp",e);
		return mv;
	}

	@PostMapping("/deleteEmp")
	public ModelAndView deleteEmpPost(@RequestParam("eid")Long id)throws Exception{
		ModelAndView mv=new ModelAndView("deletedemployee");
		mv.addObject("emp",employeeService.deleteEmployee(id));
//		if(message.equals("deleted"))
//			message="Employee having emp ID :" + id +"has been deleted";
//		else
//			message="Employee having emp ID :" + id +"has not been deleted";	
		return mv;
	}
	
	@GetMapping("/findEmpByName")
	public String findByNameGet()throws Exception
	{
		return "findEmpByName";
	}
	
	@PostMapping("/findEmpByName")
	public ModelAndView findByNamePost(@RequestParam("name")String name)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByName(name);
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/findEmpByDesig")
	public String findByDesigGet()throws Exception
	{
		return "findEmpByDesig";
	}
	
	@PostMapping("/findEmpByDesig")
	public ModelAndView findByDesigPost(@RequestParam("desig")String desig)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByDesig(desig);
		mv.addObject("emps",emps);
		return mv;
	}

	@GetMapping("/findEmpId")
	public String findByIdGet()throws Exception
	{
		return "findEmpId";
	}
	
	@PostMapping("/findEmpId")
	public ModelAndView findByIdPost(@RequestParam("id")long id)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.findByEmployeeId(id));
		return mv;
	}
	
	@GetMapping("/findEmpByDeptNo")
	public String findByDeptNoGet()throws Exception
	{
		return "findEmpByDeptNo";
	}
	
	@PostMapping("/findEmpByDeptNo")
	public ModelAndView findByDeptNoPost(@RequestParam("deptNo")int deptNo)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByDeptNo(deptNo);
		mv.addObject("emps",emps);
		return mv;
	}
	
	
}
