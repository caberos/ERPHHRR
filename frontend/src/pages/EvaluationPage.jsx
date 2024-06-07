import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { employeeGetRequest } from "../api/requests/employeeRequest";
import { deleteEvaluation } from "../api/requests/evaluationRequest";
import { Link } from "react-router-dom";

function EvaluationPage() {
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

  const { name, role, phone, city, evaluations } = employeeData;

  const handleDelete = async (id) => {
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Evaluation delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteEvaluation(id);
        console.log("Evaluation delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          evaluations: prevData.evaluations.filter(
            (evaluation) => evaluation.evaluationId !== id
          ),
        }));

        alert(`Evaluation ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete evaluation:", error.message);
    }
  };

  console.log(evaluations);

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
        <h3>Tabla de Evaluaciones</h3>
        <table>
          <thead>
            <tr>
              <th>Año</th>
              <th>Puntuacion</th>
              <th>Dia</th>
              <th>Comentarios</th>
              <th></th>
            </tr>
          </thead>
          {evaluations.map((evaluation) => (
            <tbody>
              <tr>
                <td>{evaluation.year}</td>
                <td>{evaluation.score}</td>
                <td>{(new Date(evaluation.timeScale)).toLocaleDateString('en-US')}</td>
                <td>{evaluation.comments}</td>
                <td>
                  <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/evaluation/edit/${evaluation.evaluationId}`,
                        state: { evaluation },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                    <button
                      className="btn-confirm"
                      onClick={() => handleDelete(evaluation.evaluationId)}
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
          <button className="btn-cancel">Atras</button>
          <button className="btn-confirm" ><Link to={`../employee/AddEvaluation/${idEmployee}`}>Crear</Link></button>
        </div>
      </div>
    </section>
  );
}

export default EvaluationPage;
