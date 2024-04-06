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
      <h1>Equipment Detail</h1>
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
              <th>employee</th>
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
                <td>{position.id}</td>
                <td>{position.salary}</td>
              </tr>
            </tbody>
          ))}
        </table>
      </div>
      <div>
        {" "}
        <button className="btn-confirm" onClick={closeModal}>Back</button>
      </div>
    </section>
  );
}

export default EquipmentDetail;
