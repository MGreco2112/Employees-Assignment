package com.careerdevs.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeeController {
    private final AtomicLong id = new AtomicLong();
    private final long idHeader = 2110;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Employee Database";
    }

    @GetMapping("/demoEmployee")
    public Employee employeeLanding() {
        return new Employee(idHeader - 1, "Smith, John");
    }

    @GetMapping("/selectEmployee")
    public Employee employeeSelection(@RequestParam(value="name", defaultValue = "Null, Null") String name) {
        return new Employee(idHeader + id.incrementAndGet(), name);
    }

    @GetMapping("/select/{name}")
    public Employee selectEmployee(@PathVariable String name) {
        return new Employee(idHeader + id.incrementAndGet(), name);
    }
}
