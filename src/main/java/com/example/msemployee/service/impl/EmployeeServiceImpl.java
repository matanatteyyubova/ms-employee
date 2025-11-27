package com.example.msemployee.service.impl;

import com.example.msemployee.dto.EmployeeDto;
import com.example.msemployee.entity.Employee;
import com.example.msemployee.mapper.EmployeeMapper;
import com.example.msemployee.repository.EmployeeRepository;
import com.example.msemployee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((EmployeeMapper::mapToEmployeeDto)).toList();
    }
}
