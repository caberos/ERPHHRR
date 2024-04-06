import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { departmentListRequest } from "../api/requests/departmentRequest";
import DepartmentCard from "../components/department/DepartmentCard";

function DepartmentPage() {
  const [departments, setDepartments] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await departmentListRequest();
        setDepartments(response.data);
        console.log(departments)
      } catch (error) {
        console.error("Error fetching departments:", error.message);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <div className="div1"></div>
      <div>
        <h2>Department List</h2>
        <ul className="Employee-list">
          {departments.map((der) => (
            <li key={der.id}>
              <DepartmentCard department={der} />
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default DepartmentPage;
