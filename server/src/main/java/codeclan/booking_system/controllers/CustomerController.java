package codeclan.booking_system.controllers;

import codeclan.booking_system.models.Customer;
import codeclan.booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name="courseName", required = false) String courseName,
            @RequestParam(name="courseTown", required = false) String courseTown,
            @RequestParam(name="age", required = false) Integer age

    ){
        if (courseName != null){ // This returns all customer objects
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        if (courseTown != null && courseName != null){  // This returns all customer objects
            return new ResponseEntity<>(customerRepository.findByBookingsCourseTownAndBookingsCourseName(courseTown, courseName), HttpStatus.OK);
        }
        if (courseName != null && courseTown != null && age != null){  // This query works
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(age, courseTown, courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/customers/{id}")
    public ResponseEntity<Optional<Customer>> getDistillery(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);

    }

    @PostMapping(value="/customers")
    public ResponseEntity<Customer> createShip(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);

    }
}
