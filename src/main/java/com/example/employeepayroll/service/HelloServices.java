package com.example.employeepayroll.service;
import com.example.employeepayroll.dto.EmpDto;
import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.repo.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HelloServices implements IService {
@Autowired
Repo repository ;
    /**Hello mesaage method to get welcome message*/
    public String helloMessage() {
            return "Welcome To EmployeePayRoll";
        }
    /*Save data method is added to save data to repo*/

        public Model saveData(EmpDto emp) {
        Model  newemp= new Model(emp);
             repository.save(newemp);
        return newemp;
    }
    /*Find by id method*/

    public Optional<Model> sayHelloById(Long employeeId) {
        return repository.findById(employeeId);

    }
    /*Find by All method*/

    public List<Model> sayAll(){
        return repository.findAll();
    }
    /*Edit by id method*/

    public Model editEmp( EmpDto model, Long employeeId) {
        Model editdata = repository.findById(employeeId).orElse(null);
        if (editdata != null) {
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setDepartment(model.getDepartment());
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setProfilePic(model.getProfilePic());
            editdata.setGender(model.getGender());
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setSalary(model.getSalary());
            editdata.setStartDate(model.getStartDate());
            editdata.setNotes(model.getNotes());
            return repository.save(editdata);
        }
        else
            return null;
        }
    /*Delete by id method*/

    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);

    }

    public List<Model> getEmployeesByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }
}




