import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { employeeGetRequest } from "../../api/request";

function EmployeeDetail() {
  const location = useLocation();
  const idEmployee = location.pathname.split("/").pop();

  const [employeeData, setEmployeeData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await employeeGetRequest(idEmployee);
        setEmployeeData(response.data);
        console.log("Employee data:", response.data);
      } catch (error) {
        console.error("Error fetching employee data:", error);
      }
    };

    fetchData();
  }, [idEmployee]);

  if (!employeeData) {
    return <div>Loading...</div>;
  }

 const { name, role, phone, city, birthday, startAt , contact}  = employeeData;

console.log(employeeData["contact"])

  return (
     <section className="employee-detail">
      <h1>Employee Detail</h1>
      <article className="employee-data"><>
        <div className="data-employee">
      <p>Name: {name}</p>
      <p>Role: {role}</p>
      <p>Phone: {phone}</p>
      <p>City: {city}</p>
      <p>Birthday: {birthday}</p>
      <p>Start Date: {startAt}</p>
      </div></>
      </article>
      <table><thead></thead></table>
    </section>
  );
}

export default EmployeeDetail;
