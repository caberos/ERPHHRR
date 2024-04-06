import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { employeeGetRequest } from "../api/requests/employeeRequest";
import { Link } from "react-router-dom";

function IncidentPage() {
  const [modalIsOpen, setIsOpen] = useState(true);
  const navigate = useNavigate();
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

  function closeModal() {
    setIsOpen(false);
    navigate(-1);
  }

  const handleDelete = (id) => {
    try {
      const confirmDelete = window.confirm(`Are you sure you want to delete ${id}?`);

      console.log("training created:", confirmDelete);
      console.log("training created:", id);
    } catch (error) {
      console.error("Error creating employee:", error.message);
    }
  };

  if (!employeeData) {
    return <div>Loading...</div>;
  }

  const { name, role, phone, city, incidents } = employeeData;

  console.log(incidents);

  return (
    <section className="employee-detail">
      <div className="top-menu">
        <nav>
          <ul>
            <li>
              <Link
                to={{
                  pathname: `../employee/vacation/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Vacation
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/laborHistory/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Labor History
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/accomplishment/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Accomplishments
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/incident/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Incidents
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/evaluation/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Evaluation
              </Link>
            </li>
          </ul>
        </nav>
      </div>
      <h1>Employee Detail</h1>
      <article className="employee-data">
        <>
          <div className="data-employee">
            <p>Name: {name}</p>
            <p>Role: {role}</p>
            <p>Phone: {phone}</p>
            <p>City: {city}</p>
          </div>
        </>
      </article>
      <div>
        <h3>Incidents Table</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Description</th>
              <th>Level</th>
              <th>Incident Date</th>
              <th></th>
            </tr>
          </thead>
          {incidents.map((incident) => (
            <tbody>
              <tr>
                <td>{incident.incidentId}</td>
                <td>{incident.description}</td>
                <td>{incident.level}</td>
                <td>{(new Date(incident.IncidentDate)).toLocaleDateString('en-US')}</td>
                <td>
                  <td>
                    <button className="btn-cancel">Edit</button>
                    <button
                      className="btn-confirm"
                      onClick={() => handleDelete(incident.incidentId)}
                    >
                      Delete
                    </button>
                  </td>
                </td>
              </tr>
            </tbody>
          ))}
        </table>
        <div>
          {" "}
          <button className="btn-cancel" onClick={closeModal}>Back</button>
          <button className="btn-confirm" ><Link to={`../employee/AddIncident/${idEmployee}`}>Create</Link></button>
        </div>
      </div>
    </section>
  );
}

export default IncidentPage;
