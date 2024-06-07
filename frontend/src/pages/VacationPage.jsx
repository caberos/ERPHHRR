import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { employeeGetRequest } from "../api/requests/employeeRequest";
import { deleteVacation } from "../api/requests/vacationRequest";
import { Link } from "react-router-dom";

function VacationPage() {
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

  const handleDelete = async (id) => {
    console.log("this is a example")
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("vacation delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteVacation(id);
        console.log("Vacation delete response:", res);
  
        setEmployeeData((prevData) => ({
          ...prevData,
          vacations: prevData.vacations.filter((vacation) => vacation.vacationId !== id),
        }));
  
        alert(`Vacation ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error creating employee:", error.message);
    }
  };

  if (!employeeData) {
    return <div>Loading...</div>;
  }

  const { name, role, phone, city, vacations } = employeeData;

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
                Vacacion
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/laborHistory/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Historial Laboral
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/accomplishment/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Logros
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/incident/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Incidentes
              </Link>
            </li>
            <li>
              <Link
                to={{
                  pathname: `../employee/evaluation/${idEmployee}`,
                  state: { idEmployee },
                }}
              >
                Evaluacion
              </Link>
            </li>
          </ul>
        </nav>
      </div>
      <h1>Detalle de Empleado</h1>
      <article className="employee-data">
        <>
          <div className="data-employee">
            <p>Nombre: {name}</p>
            <p>Rol: {role}</p>
            <p>Fono: {phone}</p>
            <p>Ciudad: {city}</p>
          </div>
        </>
      </article>
      <div>
        <h3>Tabla de Vacaciones</h3>
        <table>
          <thead>
            <tr>
              <th>Razon</th>
              <th>Duracion</th>
              <th>Dia de inicio</th>
              <th>Dia de finalizacion</th>
              <th></th>
            </tr>
          </thead>
          {vacations.map((vacation) => (
            <tbody>
              <tr>
                <td>{vacation.reason}</td>
                <td>{vacation.duration}</td>
                <td>{(new Date(vacation.startAt)).toLocaleDateString('en-US')}</td>
                <td>{(new Date(vacation.endAt)).toLocaleDateString('en-US')}</td>
                <td>
                  <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/vacation/edit/${vacation.vacationId}`,
                        state: { vacation },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                    <button
                      className="btn-confirm"
                      onClick={() => handleDelete(vacation.vacationId)}
                    >
                      Eliminar
                    </button>
                  </td>
                </td>
              </tr>
            </tbody>
          ))}
        </table>
        <div>
          {" "}
          <button className="btn-cancel" onClick={closeModal}>Atras</button>
          <button className="btn-confirm" ><Link to={`../employee/AddVacation/${idEmployee}`}>Crear</Link></button>
        </div>
      </div>
    </section>
  );
}

export default VacationPage;
