package codeclan.booking_system.repositories;

import codeclan.booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);

    List<Customer> findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(int age, String courseTown, String courseName);

    List<Customer> findByBookingsCourseTownAndBookingsCourseName(String courseTown, String courseName);
}
