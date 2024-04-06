import React from "react";
import { Link } from "react-router-dom";

function EquipmentCard({ equipment }) {

    const id =equipment.id
    console.log(equipment)
    console.log("----------")
  return (
    <div className="Employee-card">
      <div className="div">
        <h3>
          {equipment.name}
        </h3>
        <li>
          <Link to={{
            pathname: `../equipments/${equipment.id}`,
            state: {id} 
          }}>
            {equipment.id}
          </Link>
        </li>
      </div>
    </div>
  );
}

export default EquipmentCard;
