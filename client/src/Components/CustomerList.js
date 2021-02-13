import Customer from "./Customer";

const CustomerList = (({ customers }) => {
    
    const custNodes = customers.map((currentCustomer)=>{
        return(
        <Customer customer={currentCustomer} key={currentCustomer.id}/>
        )
    });

    return (
        <section >
            {custNodes}
        </section>
    )

});

export default CustomerList;