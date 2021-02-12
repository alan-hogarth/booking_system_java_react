
const CustomerList = (({ customers }) => {
    
    const custNodes = customers.map((current)=>{
        return(
        <p>customer={current} key={current.id}</p>
        )
    });

    return (
        <section >
            {custNodes}
        </section>
    )

});

export default CustomerList;