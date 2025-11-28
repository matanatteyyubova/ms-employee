package com.example.msemployee.controller;
import com.example.msemployee.dto.EmployeeDto;
import com.example.msemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
     EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);
     return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id){
        EmployeeDto savedEmployee =employeeService.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
    }


}
