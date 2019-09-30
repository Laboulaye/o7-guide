package com.study.o7guide.controller;

import java.util.List;
import com.study.o7guide.dao.EmployeeDao;
import com.study.o7guide.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainRestController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }


    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDao.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employee/{empNo}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee getEmployee(@PathVariable String empNo){
        return employeeDao.getEmployee(empNo);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp){
        System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
        return employeeDao.addEmployee(emp);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp){
        System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
        return employeeDao.updateEmployee(emp);
    }

    @RequestMapping(value = "/employee/{empNo}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable String empNo){
        System.out.println("(Service Side) Deleting employee: " + empNo);
        employeeDao.deleteEmployee(empNo);
    }






}
