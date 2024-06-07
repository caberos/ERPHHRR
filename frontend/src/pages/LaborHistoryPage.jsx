import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { employeeGetRequest } from "../api/requests/employeeRequest";
import { deleteLaborHistory } from "../api/requests/laborRequest";
import { Link } from "react-router-dom";

function LaborHistoryPage() {
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
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Labor history delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteLaborHistory(id);
        console.log("Labor history delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          laborHistories: prevData.laborHistories.filter(
            (labor) => labor.historyId !== id
          ),
        }));

        alert(`Evaluation ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete evaluation:", error.message);
    }
  };

  if (!employeeData) {
    return <div>Loading...</div>;
  }

  const { name, role, phone, city, laborHistories } = employeeData;

  console.log(laborHistories);

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
      <div className="data-details">
        <h3>Tabla de Historial Laboral</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Descripcion</th>
              <th>Dia de inicio</th>
              <th>Dia Final</th>
              <th></th>
            </tr>
          </thead>
          {laborHistories.map((labor) => (
            <tbody>
              <tr>
                <td>{labor.historyId}</td>
                <td>{labor.description}</td>
                <td>{(new Date(labor.startAt)).toLocaleDateString('en-US')}</td>
                <td>{(new Date(labor.endAt)).toLocaleDateString('en-US')}</td>
                <td><td>
                <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/laborHistory/edit/${labor.historyId}`,
                        state: { labor },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                  <button
                      className="btn-confirm"
                      onClick={() => handleDelete(labor.historyId)}
                    >
                      Eliminar
                    </button>
                </td></td>
              </tr>
            </tbody>
          ))}
        </table>
        <div className="create-btns">
          {" "}
          <button className="btn-cancel" onClick={closeModal}>Atras</button>
          <button className="btn-confirm" ><Link to={`../employee/AddLabor/${idEmployee}`}>Crear</Link></button>
        </div>
      </div>
      
      
    </section>
  );
}

export default LaborHistoryPage;
