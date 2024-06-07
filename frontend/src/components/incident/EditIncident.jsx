import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateIncidentRequest,
  incidentGetRequest,
} from "../../api/requests/incidentsRequest";

const customStyles = {
  content: {
    top: "50%",
    left: "50%",
    right: "auto",
    bottom: "auto",
    marginRight: "-50%",
    transform: "translate(-50%, -50%)",
    maxWidth: "400px",
    padding: "20px",
    borderRadius: "8px",
    boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
  },
  scrollContainer: {
    maxHeight: "500px", // Adjust this height as needed
    overflowY: "auto",
  },
};

ReactModal.setAppElement("#root");

function EditIncident({ incident }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idIncident = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    incidentId: idIncident,
    description: "",
    level: "",
    incidentDate: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await incidentGetRequest(idIncident);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
          evaluationId: idIncident,
          description: "",
          level: "",
          incidentDate: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching incident data:", error);
      }
    };
    fetchData();
  }, [idIncident]);

  const handleChange = (event) => {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
    });
  };

  const closeModal = () => {
    setIsOpen(false);
    navigate(-1);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await updateIncidentRequest(idIncident, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating incident:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Incidente</h2>
      <form onSubmit={handleSubmit}>
        <label>Descripcion</label>
        <input
          type="text"
          value={form.description}
          onChange={handleChange}
          name="description"
          required
        />
        <label>Nivel</label>
        <input
          type="number"
          value={form.level}
          onChange={handleChange}
          name="level"
          required
        />
        <label>Fecha</label>
        <input
          type="date"
          value={form.date}
          onChange={handleChange}
          name="date"
          required
        />
        <div>
          <button className="btn-cancel" onClick={closeModal}>
            Cancelar
          </button>
          <button className="btn-confirm" type="submit" onClick={handleSubmit}>
            Enviar
          </button>
        </div>
      </form>
    </div>
  );
}

export default EditIncident;
