package codeclan.booking_system.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    Course course;
    Booking booking1;
    Booking booking2;
    Booking booking3;
    Customer customer1;
    Customer customer2;
    Customer customer3;

    @Before
    public void setUp() throws Exception {
        course = new Course("Java", "Edinburgh", 5);

        customer1 = new Customer("Barry", "Edingurgh", 35);
        customer2 = new Customer("Wendy", "Glasgow", 25);
        customer3 = new Customer("Freddy", "Inverness", 18);

        booking1 = new Booking(course, customer1, "24/4");
        booking2 = new Booking(course, customer2, "25/4");
        booking3 = new Booking(course, customer3, "26/4");
    }

    @Test
    public void getName() {
        assertEquals("Java", course.getName());
    }

    @Test
    public void setName() {
        course.setName("CSS");
        assertEquals("CSS", course.getName());
    }

    @Test
    public void getTown() {
        assertEquals("Edinburgh", course.getTown());
    }

    @Test
    public void setTown() {
        course.setTown("Glasgow");
        assertEquals("Glasgow", course.getTown());
    }

    @Test
    public void getRating() {
        assertEquals(5, course.getRating());
    }

    @Test
    public void setRating() {
        course.setRating(4);
        assertEquals(4, course.getRating());
    }
}