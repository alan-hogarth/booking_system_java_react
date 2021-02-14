import { useState, useEffect} from 'react';
import './App.css';
import CustomerList from "./Components/CustomerList";

function App() {
  
  const [customers, setCustomers] = useState([]);
  const [courses, setCourses] = useState([]);
  const [bookings, setBookings] = useState([]);
  

  const fetchCustomers = ()=> {
    
    const customerUrl = `http://localhost:8080/customers`;
    
    fetch(customerUrl)
    .then((res)=>res.json())
    .then((data)=>setCustomers(data))
  }

  useEffect(()=>{
    fetchCustomers();
  }, [])

  const fetchCourses = ()=> {
    
    const courseUrl = `http://localhost:8080/courses`;
    
    fetch(courseUrl)
    .then((res)=>res.json())
    .then((data)=>setCourses(data))
  }

  useEffect(()=>{
    fetchCourses();
  }, [])

  const fetchBookings = ()=> {
    
    const bookingsUrl = `http://localhost:8080/bookings`;
    
    fetch(bookingsUrl)
    .then((res)=>res.json())
    .then((data)=>setBookings(data))
  }

  useEffect(()=>{
    fetchBookings();
  }, [])




  return (
    <div className="App">
          <h3>Customer Details</h3>
      <CustomerList customers={customers}/>
    </div>
  );
}

export default App;
