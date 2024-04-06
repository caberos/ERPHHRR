import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { equipmentListRequest } from "../api/requests/equipmentRequest";
import EquipmentCard from "../components/equipment/EquipmentCard";

function EquipmentPage() {
  const [equipments, setEquipments] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await equipmentListRequest();
        setEquipments(response.data);
        console.log(equipments)
      } catch (error) {
        console.error("Error fetching departments:", error.message);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <div className="div1"></div>
      <div>
        <h2>Equipment List</h2>
        <ul className="Employee-list">
          {equipments.map((equip) => (
            <li key={equip.id}>
              <EquipmentCard equipment={equip} />
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default EquipmentPage;
