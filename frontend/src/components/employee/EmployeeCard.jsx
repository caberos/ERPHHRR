import React from "react";
import { Link } from "react-router-dom";

function EmployeeCard({ employee }) {

    const id =employee.id
  return (
    <div className="Employee-card">
      <div className="div">
        <h3>
          {employee.name} {employee.role}
        </h3>
        <li>
          <Link to={{
            pathname: `../employee/${employee.id}`,
            state: {id} 
          }}>
            {employee.id}
          </Link>
        </li>
      </div>
    </div>
  );
}

export default EmployeeCard;
