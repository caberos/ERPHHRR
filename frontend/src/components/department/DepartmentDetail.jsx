import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { departmentGetRequest } from "../../api/requests/departmentRequest";

function DepartmentDetail() {
  const location = useLocation();
  const idDepartment = location.pathname.split("/").pop();

  const [departmentData, setDepartmentData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await departmentGetRequest(idDepartment);
        setDepartmentData(response.data);
        console.log("Department data:", response.data);
      } catch (error) {
        console.error("Error fetching Department data:", error);
      }
    };

    fetchData();
  }, [idDepartment]);

 
  if (!departmentData) {
    return <div>Loading...</div>;
  }

  const {
    id,
    description,
    name,
    positions,
  } = departmentData;

  return (
    <section className="employee-detail">
      <h1>Department Detail</h1>
      <article className="employee-data">
        <>
          <div className="data-employee">
            <p>Id: {id}</p>
            <p>Name: {name}</p>
            <p>Description: {description}</p>
          </div>
        </>
      </article>
     
      <div>
        <h3>Position Table</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Description</th>
              <th>Salary</th>
              <th></th>
            </tr>
          </thead>
          {positions.map((position) => (
            <tbody>
              <tr>
                <td>{position.id}</td>
                <td>{position.name}</td>
                <td>{position.description}</td>
                <td>{position.salary}</td>
                <td>
                  <td>
                    <button className="btn-confirm">Edit</button>
                    <button
                      className="btn-confirm"
                    >
                      Delete
                    </button>
                  </td>
                </td>
              </tr>
            </tbody>
          ))}
        </table>
      </div>
      <div>
        {" "}
        <button className="btn-confirm" >create</button>
      </div>
    </section>
  );
}

export default DepartmentDetail;
