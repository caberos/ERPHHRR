import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateVacationRequest,
  vacationGetRequest,
} from "../../api/requests/vacationRequest";

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

function EditVacation({ vacation }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idVacation = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    vacationId: idVacation,
    reason: "",
    duration: "",
    startAt: "",
    endAt: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await vacationGetRequest(idVacation);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
            vacationId: idVacation,
            reason: "",
            duration: "",
            startAt: "",
            endAt: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching vacation data:", error);
      }
    };
    fetchData();
  }, [idVacation]);

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
      const response = await updateVacationRequest(idVacation, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating vacation:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Vacacion</h2>
      <form onSubmit={handleSubmit}>
        <label>Razon</label>
        <input
          type="text"
          value={form.reason}
          onChange={handleChange}
          name="reason"
          required
        />
        <label>Duracion</label>
        <input
          type="number"
          value={form.duration}
          onChange={handleChange}
          name="duration"
          required
        />
        <label>Inicia en</label>
        <input
          type="date"
          value={form.startAt}
          onChange={handleChange}
          name="startAt"
          required
        />
        <label>Finaliza en</label>
        <input
          type="date"
          value={form.endAt}
          onChange={handleChange}
          name="endAt"
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

export default EditVacation;
