package com.leapfrog.rs.resources;

import com.leapfrog.rs.model.Employee;
import com.leapfrog.rs.service.EmployeeService;
import com.leapfrog.rs.serviceImpl.EmployeeServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class EmployeeRS {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> list(){
        return employeeService.getAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getById(@PathParam("id") String id){

        return employeeService.getById(Integer.parseInt(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(Employee employee){
        employeeService.add(employee);
        return (employee.getName());
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee update(@PathParam("id")int id, Employee employee){
        employee.setId(id);
        Employee emp = employeeService.update(employee);
        return emp;
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id")int id){
        employeeService.delete(id);
    }




}
