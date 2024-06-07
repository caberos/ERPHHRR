import React, { useEffect, useState } from "react";
import { useLocation, Link, useNavigate } from "react-router-dom";
import {
  employeeGetRequest,
  employeeGetPositionRequest,
  deleteEmployee,
} from "../../api/requests/employeeRequest";
import { deleteTraining } from "../../api/requests/trainingRequest";
import { deleteContact } from "../../api/requests/contactRequest";
import { deleteLicenses } from "../../api/requests/licensesRequest";
import { deletePosition } from "../../api/requests/positionRequest";
import { parse, format } from "@formkit/tempo";

function EmployeeDetail() {
  const location = useLocation();
  const idEmployee = location.pathname.split("/").pop();

  const [employeeData, setEmployeeData] = useState(null);
  const [employeePositions, setemployeePositions] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await employeeGetRequest(idEmployee);
        setEmployeeData(response.data);
        const resPos = await employeeGetPositionRequest(idEmployee);
        setemployeePositions(resPos.data);
        console.log("Employee data:", response.data);
        console.log("Positions data:", resPos);
      } catch (error) {
        console.error("Error fetching employee data:", error);
      }
    };

    fetchData();
  }, [idEmployee]);

  const trainingDelete = async (id) => {
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Training delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteTraining(id);
        console.log("training delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          trainings: prevData.trainings.filter(
            (training) => training.trainingId !== id
          ),
        }));
        alert(`Training ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete training:", error.message);
    }
  };

  const contactDelete = async (id) => {
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Contact delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteContact(id);
        console.log("Contact delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          contacts: prevData.contacts.filter(
            (contact) => contact.contactId !== id
          ),
        }));

        alert(`Contact ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete contact:", error.message);
    }
  };

  const licensesDelete = async (id) => {
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Licenses delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteLicenses(id);
        console.log("Licenses delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          licensesCertifications: prevData.licensesCertifications.filter(
            (license) => license.licensesId !== id
          ),
        }));

        alert(`Licenses ${id} deleted successfully.`);
      }
    } catch (error) {
      console.error("Error delete evaluation:", error.message);
    }
  };

  const employeeDelete = async (id) => {
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Employee delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deleteEmployee(id);
        console.log("Employee delete response:", res);

        alert(`Employee ${id} deleted successfully.`);
        navigate(`/employees`);
      }
    } catch (error) {
      console.error("Error delete evaluation:", error.message);
    }
  };

  const positionDelete = async (id) => {
    console.log("this is a example");
    try {
      const confirmDelete = window.confirm(
        `Are you sure you want to delete ${id}?`
      );
      console.log("Position delete:", confirmDelete);

      if (confirmDelete) {
        const res = await deletePosition(id);
        console.log("Position delete response:", res);

        setEmployeeData((prevData) => ({
          ...prevData,
          positions: prevData.positions.filter(
            (position) => position.id !== id
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

  const {
    name,
    role,
    phone,
    city,
    birthday,
    startAt,
    contacts,
    trainings,
    licensesCertifications,
  } = employeeData;

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
      <h1>Detalle del Empleado</h1>
      <article className="employee-data">
        <>
          <div className="data-employee">
            <p>Nombre: {name}</p>
            <p>Rol: {role}</p>
            <p>Fono: {phone}</p>
            <p>Ciudad: {city}</p>
            <p>Cumpleaños: {new Date(birthday).toLocaleDateString("en-US")}</p>
            <p>
              Fecha de Inicio: {new Date(startAt).toLocaleDateString("en-US")}
            </p>
          </div>
          <div>
            <button className="btn-edit">Edit</button>
            <button
              className="btn-confirm"
              onClick={() => employeeDelete(idEmployee)}
            >
              Eliminar
            </button>
          </div>
        </>
      </article>
      <div>
        <h3>Table de Capacitaciones</h3>
        <table>
          <thead>
            <tr>
              <th>Descripcion</th>
              <th>Tipo</th>
              <th>Fecha de Inicio</th>
              <th>Fecha de Conclusion</th>
              <th></th>
            </tr>
          </thead>
          {trainings.map((training) => (
            <tbody>
              <tr>
                <td>{training.description}</td>
                <td>{training.type}</td>
                <td>
                  {new Date(training.startAt).toLocaleDateString("en-US")}
                </td>
                <td>{new Date(training.endAt).toLocaleDateString("en-US")}</td>
                <td>
                  <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/training/edit/${training.trainingId}`,
                        state: { training },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                    <button
                      className="btn-confirm"
                      onClick={() => trainingDelete(training.trainingId)}
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
          <button className="btn-confirm">
            <Link to={`../employee/AddTraining/${idEmployee}`}>Create</Link>
          </button>
        </div>
      </div>
      <div>
        <h3>Tabla de Posiciones</h3>
        <table>
          <thead>
            <tr>
              <th>id</th>
              <th>Nombre</th>
              <th>Departamento</th>
              <th>Descripcion</th>
              <th>Salario</th>
              <th></th>
            </tr>
          </thead>
          {employeePositions.map((position) => (
            <tbody>
              <tr>
                <td>{position.id}</td>
                <td>{position.name}</td>
                <td>{position.department.name}</td>
                <td>{position.description}</td>
                <td>{position.salary}</td>
                <td>
                  <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/position/edit/${position.id}`,
                        state: { position },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                    <button
                      className="btn-confirm"
                      onClick={() => positionDelete(position.id)}
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
          <button className="btn-confirm">
            <Link to={`../employee/AddPosition/${idEmployee}`}>Crear</Link>
          </button>
        </div>
      </div>
      <div>
        <h3>Tabla de Contacto</h3>
        <table>
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Fono</th>
              <th>Direccion</th>
              <th>Relacion</th>
              <th></th>
            </tr>
          </thead>
          {contacts.map((contact) => (
            <tbody>
              <tr>
                <td>{contact.name}</td>
                <td>{contact.phone}</td>
                <td>{contact.address}</td>
                <td>{contact.relation}</td>
                <td>
                  <td>
                    <button className="btn-confirm">
                      <Link
                        to={{
                          pathname: `/employee/${idEmployee}/contact/edit/${contact.contactId}`,
                          state: { contact },
                        }}
                      >
                        Editar
                      </Link>
                    </button>
                    <button
                      className="btn-confirm"
                      onClick={() => contactDelete(contact.contactId)}
                    >
                      Eliminar
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
        <button className="btn-confirm">
          <Link to={`../employee/AddContact/${idEmployee}`}>Crear</Link>
        </button>
      </div>
      <div>
        <h3>Tabla de Licencias</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Expiracion</th>
              <th></th>
            </tr>
          </thead>
          {licensesCertifications.map((license) => (
            <tbody>
              <tr>
                <td>{license.licensesId}</td>
                <td>{license.name}</td>
                <td>{new Date(license.expired).toLocaleDateString("en-US")}</td>
                <td>
                  <td>
                  <button className="btn-confirm">
                    <Link
                      to={{
                        pathname: `/employee/${idEmployee}/licenses/edit/${license.licensesId}`,
                        state: { license },
                      }}
                    >
                      Editar
                    </Link>
                  </button>
                    <button
                      className="btn-confirm"
                      onClick={() => licensesDelete(license.licensesId)}
                    >
                      Eliminar
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
        <button className="btn-confirm">
          <Link to={`../employee/AddLicenses/${idEmployee}`}>Crear</Link>
        </button>
      </div>
    </section>
  );
}

export default EmployeeDetail;
