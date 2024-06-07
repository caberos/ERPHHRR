import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { employeeGetRequest } from "../api/requests/employeeRequest";
import { deleteAccomplishment } from "../api/requests/accomplishmentRequest";
import { Link, state } from "react-router-dom";
import ReactModal from "react-modal";

function AccomplishmentPage() {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
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
      console.log("Accomplishment delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteAccomplishment(id);
        console.log("Accomplishment delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          accomplishments: prevData.accomplishments.filter(
            (accomplishment) => accomplishment.accomplishmentId !== id
          ),
        }));

        alert(`Accomplishment ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete accomplishment:", error.message);
    }
  };

  if (!employeeData) {
    return <div>Loading...</div>;
  }

  const { name, role, phone, city, accomplishments } = employeeData;

  console.log(accomplishments);

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
                Vacaciones
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
                Evaluaciones
              </Link>
            </li>
          </ul>
        </nav>
      </div>
      <h1>Detalles del Empleado</h1>
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
        <h3>Tabla de logros</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Descripcion</th>
              <th>Fecha del logro</th>
              <th></th>
            </tr>
          </thead>
          {accomplishments.map((accomplishment) => (
            <tbody>
              <tr>
                <td>{accomplishment.accomplishmentId}</td>
                <td>{accomplishment.description}</td>
                <td>
                  {new Date(
                    accomplishment.accomplishmentDate
                  ).toLocaleDateString("en-US")}
                </td>
                <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/accomplishment/edit/${accomplishment.accomplishmentId}`,
                        state: { accomplishment },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                  <button
                    className="btn-confirm"
                    onClick={() =>
                      handleDelete(accomplishment.accomplishmentId)
                    }
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            </tbody>
          ))}
        </table>
        <div>
          {" "}
          <button className="btn-cancel" onClick={closeModal}>
            Atras
          </button>
          <button className="btn-confirm">
            <Link to={`../employee/AddAccomplishment/${idEmployee}`}>
              Crear
            </Link>
          </button>
        </div>
      </div>
    </section>
  );
}

export default AccomplishmentPage;
