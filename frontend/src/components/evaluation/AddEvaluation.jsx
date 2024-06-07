import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import { createVacation } from "../../api/requests/vacationRequest";
import { createEvaluation } from "../../api/requests/evaluationRequest";

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

function AddEvaluation({ evaluation }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEmployee = location.pathname.split("/").pop();
  const [form, setForm] = useState({
    evaluation_id: "",
    year: "",
    time: "",
    comment: "",
    score: "",
    evalTime: "",
  });

  const handleChange = (event) => {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
      evaluation_id: Math.floor( Math.random() * 100),
    });
  };

  function closeModal() {
    setIsOpen(false);
    navigate(-1)
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log(form);
      const response = await createEvaluation(form);
      console.log("Vacation created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating Vacation:", error.message);
    }
    setForm(false);
  };

  return (
    <div className="add-form">
      <h2>Crear Evaluacion</h2>
      <form onSubmit={handleSubmit}>
        <label>Comentario</label>
        <input
          type="text"
          value={form.comment}
          onChange={handleChange}
          name="comment"
          required
        />
        <label>Puntuacion</label>
        <input
          type="number"
          value={form.score}
          onChange={handleChange}
          name="score"
          required
        />
        <label>Año</label>
        <input
          type="number"
          value={form.year}
          onChange={handleChange}
          name="year"
          required
        />
        <label>Tiempo de Evaluacion</label>
        <input
          type="date"
          value={form.evalTime}
          onChange={handleChange}
          name="eval_time"
          required
        />
        <label>Escala de Tiempo</label>
        <input
          type="date"
          value={form.time}
          onChange={handleChange}
          name="time"
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

export default AddEvaluation;
