package codeclan.booking_system.models;

import codeclan.booking_system.repositories.BookingRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.BadPaddingException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

    @Autowired
    BookingRepository bookingRepository;

    Booking booking1;
    Course course1;
    Customer customer1;

    @Before
    public void before(){
        course1 = new Course("Intro Java", "Edinburgh", 5);
        booking1 = new Booking(course1, customer1, "02/02/21");
        bookingRepository.save(booking1);
    }

    @Test
    public void getCourseWithBooking() {
        List<Booking> bookingCourse = bookingRepository.findByCourseName("Intro Java");
        assertEquals("Intro Java", bookingCourse.get(0).getCourse().getName());
    }

//    @Test
//    public void getCustomerWithBooking() {
//        List <Booking> bookingCustomer = bookingRepository.getBookingByCustomer(customer1);
//        assertEquals("")
//    }

    @Test
    void setCourse() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void setCustomer() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }

}