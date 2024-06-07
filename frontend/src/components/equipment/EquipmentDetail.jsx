import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { equipmentGetRequest } from "../../api/requests/equipmentRequest";

function EquipmentDetail() {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEquipment = location.pathname.split("/").pop();

  const [equipmentData, setEquipmentData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await equipmentGetRequest(idEquipment);
        setEquipmentData(response.data);
        console.log("Equipment data:", response.data);
      } catch (error) {
        console.error("Error fetching equipment data:", error);
      }
    };

    fetchData();
  }, [idEquipment]);

  function closeModal() {
    setIsOpen(false);
    navigate(-1);
  }

 
  if (!equipmentData) {
    return <div>Loading...</div>;
  }

  const {
    id,
    description,
    name,
    positions,
  } = equipmentData;

  return (
    <section className="employee-detail">
      <h1>Detalle Equipamiento</h1>
      <article className="employee-data">
        <>
          <div className="data-employee">
            <p>Id: {id}</p>
            <p>Nombre: {name}</p>
            <p>Descripcion: {description}</p>
          </div>
        </>
      </article>
     
      <div>
        <h3>Tabla Posiciones</h3>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Descripcion</th>
              <th>Empleado</th>
              <th>Salario</th>
              <th></th>
            </tr>
          </thead>
          {positions.map((position) => (
            <tbody>
              <tr>
                <td>{position.id}</td>
                <td>{position.name}</td>
                <td>{position.description}</td>
                <td>{position.id}</td>
                <td>{position.salary}</td>
              </tr>
            </tbody>
          ))}
        </table>
      </div>
      <div>
        {" "}
        <button className="btn-confirm" onClick={closeModal}>Atras</button>
      </div>
    </section>
  );
}

export default EquipmentDetail;
