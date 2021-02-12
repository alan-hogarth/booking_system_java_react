package codeclan.booking_system.components;

import codeclan.booking_system.models.Booking;
import codeclan.booking_system.models.Course;
import codeclan.booking_system.models.Customer;
import codeclan.booking_system.repositories.BookingRepository;
import codeclan.booking_system.repositories.CourseRepository;
import codeclan.booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }
    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Barry", "Aberdeen", 35);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Wendy", "Dundee", 25);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Freddy", "Inverness", 18);
        customerRepository.save(customer3);

        Course course1 = new Course("Java", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("CSS", "Highlands", 5);
        courseRepository.save(course2);

        Course course3 = new Course("HTML", "Glasgow", 5);
        courseRepository.save(course3);

        Booking booking1 = new Booking(course1, customer1, "24/4");
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(course2, customer2, "25/5");
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(course3, customer3, "26/6");
        bookingRepository.save(booking3);

        customer3.addBooking(booking1);  // Barry is on "Java" course that is in Edinburgh
//        customer2.addBooking(booking2);
//        customer1.addBooking(booking3);







    }
}


