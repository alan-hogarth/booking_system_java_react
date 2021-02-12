package codeclan.booking_system.models;

import codeclan.booking_system.repositories.CourseRepository;
import codeclan.booking_system.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void contextLoads(){

    }

    @Test
    public void canFindCustomersInGivenTownForGivenCourse() {
//        Customer customer1 = new Customer("Barry", 35);
//        Course course1 = new Course("Intro Java", "Edinburgh", 4);
//        Booking booking1 = new Booking(course1, customer1, "03/03/20");

        List<Customer> foundCustomersOnCourseInGivenTown = customerRepository.findByBookingsCourseTownAndBookingsCourseName("Edinburgh", "Java");
        assertEquals("Barry", foundCustomersOnCourseInGivenTown.get(0).getName());

    } // Barry is on "Java" course that is in Edinburgh

    @Test
    public void canFindCustomersInGivenTownForGivenCourseOverCertainAge(){
        List <Customer> foundCustomerWithAgeOnCourseInGivenTown = customerRepository.findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(24, "Highlands", "CSS");
        assertEquals("Wendy", foundCustomerWithAgeOnCourseInGivenTown.get(0).getName());

    }

}