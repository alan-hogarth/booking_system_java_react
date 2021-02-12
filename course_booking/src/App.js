import { useState, useEffect} from 'react';
import './App.css';
import CustomerList from "./Components/CustomerList";

function App() {
  
  const [customers, setCustomers] = useState([]);
  

  const fetchCustomers = ()=> {
    
    const customerUrl = `http:localhost:8080/customers`;
    
    fetch(customerUrl)
    .then((res)=>res.json())
    .then((data)=>{
        setCustomers(data);
    })
  }

  useEffect(()=>{
    fetchCustomers();
  }, [])



  return (
    <div className="App">
      <CustomerList customers={customers.name}/>
    </div>
  );
}

export default App;
