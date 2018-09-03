package com.example.Controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao = new EmployeeDao();

    @Autowired
    DepartmentDao deptno = new DepartmentDao();

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String addPage(Model model){
        Collection<Department> departments = deptno.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){

        System.out.println("保存的员工信息:"+employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

       Collection<Department> departments = deptno.getDepartments();
       model.addAttribute("depts",departments);
       return "emp/add";
    }

    @PutMapping("/emp")
    public  String Update(Employee employee){
        System.out.println("修改的员工数据"+employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }


    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
