import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateEvaluationRequest,
  evaluationGetRequest,
} from "../../api/requests/evaluationRequest";

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

function EditEvaluation({ evaluation }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEvaluation = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    evaluationId: idEvaluation,
    year: "",
    timeScale: "",
    comments: "",
    score: "",
    evalTime: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await evaluationGetRequest(idEvaluation);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
          evaluationId: idEvaluation,
          year: "",
          timeScale: "",
          comments: "",
          score: "",
          evalTime: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching evaluation data:", error);
      }
    };
    fetchData();
  }, [idEvaluation]);

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
      const response = await updateEvaluationRequest(idEvaluation, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating Contact:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Evaluacion</h2>
      <form onSubmit={handleSubmit}>
        <label>Comentario</label>
        <input
          type="text"
          value={form.comments}
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

export default EditEvaluation;
