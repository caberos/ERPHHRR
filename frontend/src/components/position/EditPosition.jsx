import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updatePositionRequest,
  positionGetRequest,
} from "../../api/requests/positionRequest";

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

function EditPosition({ position }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idPosition = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    positionId: idPosition,
    name: "",
    description: "",
    salary: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await positionGetRequest(idPosition);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
            positionId: idPosition,
            name: "",
            description: "",
            salary: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching position data:", error);
      }
    };
    fetchData();
  }, [idPosition]);

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
      const response = await updatePositionRequest(idPosition, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating position:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Posicion</h2>
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
        <label>Salario</label>
        <input
          type="number"
          value={form.salary}
          onChange={handleChange}
          name="salary"
          required
        />
        <label>Departamento</label>
        <select
          value={depSelect}
          onChange={handleSelect}
          name="department"
          required
        >
          <option selected>Escojer un Departamento</option>
          {dep.map((department) => (
            <option value={department.id}>
              {department.id} - {department.name}
            </option>
          ))}
        </select>

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

export default EditPosition;
