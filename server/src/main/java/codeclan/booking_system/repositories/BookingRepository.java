package codeclan.booking_system.repositories;

import codeclan.booking_system.models.Booking;
import codeclan.booking_system.models.Course;
import codeclan.booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(String date);
    List<Booking> findByCourseName(String name);
    List<Booking> findByCustomerName(String customer);

}
