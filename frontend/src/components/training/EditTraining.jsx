import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateTrainingRequest,
  trainingGetRequest,
} from "../../api/requests/trainingRequest";

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

function EditTraining({ training }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idTraining = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    trainingId: idTraining,
    name: "",
    type: "",
    description: "",
    startAt: "",
    endAt: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await trainingGetRequest(idTraining);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
            trainingId: idTraining,
            name: "",
            type: "",
            description: "",
            startAt: "",
            endAt: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching training data:", error);
      }
    };
    fetchData();
  }, [idTraining]);

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
      const response = await updateTrainingRequest(idTraining, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating training:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Capacitacion</h2>
      <form onSubmit={handleSubmit}>
        <label>Nombre</label>
        <input
          type="text"
          value={form.name}
          onChange={handleChange}
          name="name"
          required
        />
        <label>Descripcion</label>
        <input
          type="text"
          value={form.description}
          onChange={handleChange}
          name="description"
          required
        />
        <label>Tipo</label>
        <input
          type="text"
          value={form.address}
          onChange={handleChange}
          name="address"
          required
        />
        <label>Inicio</label>
        <input
          type="date"
          value={form.startAt}
          onChange={handleChange}
          name="startAt"
          required
        />

        <label>Finaliza</label>
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

export default EditTraining;
