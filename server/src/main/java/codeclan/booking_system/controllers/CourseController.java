package codeclan.booking_system.controllers;

import codeclan.booking_system.models.Course;
import codeclan.booking_system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customerName", required = false) String customerName,
            @RequestParam(name = "customerId", required = false) Long customerId
            )
    {
        if (customerId != null && rating != null) {
            return courseByRatingAndCustomerId(rating, customerId);
        }
        if (customerName != null && rating != null) {
            return courseByRatingAndCustomerName(rating, customerName);
        }
        if (rating != null) {
            return courseByRating(rating);
        }
        if (customerName != null) {
            return courseByCustomerName(customerName);
        }
        if (customerId != null) {
            return courseByCustomerId(customerId);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    private ResponseEntity<List<Course>> courseByRating(Integer rating) {
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }

    private ResponseEntity<List<Course>> courseByCustomerId(Long id) {
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(id), HttpStatus.OK);
    }

    private ResponseEntity<List<Course>> courseByCustomerName(String name) {
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(name), HttpStatus.OK);
    }

    private ResponseEntity<List<Course>> courseByRatingAndCustomerId(Integer rating, Long id) {
        return new ResponseEntity<>(courseRepository.findByRatingAndBookingsCustomerId(rating, id), HttpStatus.OK);
    }

    private ResponseEntity<List<Course>> courseByRatingAndCustomerName(Integer rating, String name) {
        return new ResponseEntity<>(courseRepository.findByRatingAndBookingsCustomerName(rating, name), HttpStatus.OK);
    }


}
