import React, { useEffect, useState } from "react";
import SearchEmployee from "../components/employee/SearchEmployee";
import { Link } from "react-router-dom";
import EmployeeCard from "../components/employee/EmployeeCard";
import { employeeListRequest } from "../api/requests/employeeRequest";
import AddEmployee from "../components/employee/AddEmployee";

function EmployeePage() {
  const [employees, setEmployees] = useState([]);
  const [searchValue, setSearchValue] = useState("");

  const handleSearch = (e) => setSearchValue(e.target.value);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await employeeListRequest();
        setEmployees(response.data);
      } catch (error) {
        console.error("Error fetching employees:", error.message);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <div className="div1">
        <SearchEmployee searchValue={searchValue} HandleSearch={handleSearch} />
        <AddEmployee />
      </div>
      <div>
        <h2>Lista de Empleado</h2>
        <ul className="Employee-list">
          {employees.map((emp) => (
            <li key={emp.id}>
              <EmployeeCard employee={emp} />
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default EmployeePage;
