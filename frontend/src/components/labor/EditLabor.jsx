import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateLaborHistoryRequest,
  laborHistoryGetRequest,
} from "../../api/requests/laborRequest";

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

function EditLabor({ labor }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idLabor = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    historyId: idLabor,
    description: "",
    startAt: "",
    endAt: "",
    position: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await laborHistoryGetRequest(idLabor);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
            historyId: idLabor,
            description: "",
            startAt: "",
            endAt: "",
            position: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching labor history  data:", error);
      }
    };
    fetchData();
  }, [idLabor]);

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
      const response = await updateLaborHistoryRequest(idLabor, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating labor history:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Historial laboral</h2>
      <form onSubmit={handleSubmit}>
        <label>Descripcion</label>
        <input
          type="text"
          value={form.description}
          onChange={handleChange}
          name="description"
          required
        />
        <label>Posicion</label>
        <input
          type="number"
          value={form.position}
          onChange={handleChange}
          name="position"
          required
        />
        <label>Inicio en:</label>
        <input
          type="date"
          value={form.startAt}
          onChange={handleChange}
          name="startAt"
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

export default EditLabor;
