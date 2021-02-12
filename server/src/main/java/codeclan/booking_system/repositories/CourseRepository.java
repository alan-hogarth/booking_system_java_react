package codeclan.booking_system.repositories;

import codeclan.booking_system.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
    List<Course> findByBookingsCustomerName(String name);
    List<Course> findByBookingsCustomerId(Long id);
    List<Course> findByRatingAndBookingsCustomerId(int rating, Long id);
    List<Course> findByRatingAndBookingsCustomerName(int rating, String name);
}
