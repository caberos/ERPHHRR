import React from "react";
import { Link } from "react-router-dom";

function DepartmentCard({ department }) {

    const id =department.id
    console.log(department)
    console.log("----------")
  return (
    <div className="Employee-card">
      <div className="div">
        <h3>
          {department.name}
        </h3>
        <li>
          <Link to={{
            pathname: `../department/${department.id}`,
            state: {id} 
          }}>
            {department.id}
          </Link>
        </li>
      </div>
    </div>
  );
}

export default DepartmentCard;
