import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { createEmployee } from "../../api/requests/employeeRequest";

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

function AddEmployee({ employee }) {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [form, setForm] = useState({
    id:"",
    name: "",
    birthday: "",
    phone: "",
    mail: "",
    city: "",
    ci: "",
    supervisorId: "",
    role: "",
    password: "",
    admin: "",
    startAt: "",
  });

  const handleChange = (event) => {
    setForm({ ...form, [event.target.name]: event.target.value });
  };

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await createEmployee(form);
      console.log("Employee created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating employee:", error.message);
    }
  };

  return (
    <div className="add-employee">
      <button className="add-employee-btn" onClick={openModal}>
        Añadir Empleado
      </button>
      <ReactModal
        style={customStyles}
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
      >
        <h2>Añadir Empleado</h2>
        <div style={customStyles.scrollContainer}>
          <form onSubmit={handleSubmit}>
            <label>CI</label>
            <input
              type="text"
              value={form.id}
              onChange={handleChange}
              name="id"
              required
            />
            <label>Nombre</label>
            <input
              type="text"
              value={form.name}
              onChange={handleChange}
              name="name"
              required
            />
            <label>Cumpleaños</label>
            <input
              type="date"
              value={form.birthday}
              onChange={handleChange}
              name="birthday"
              required
            />
            <label>Numero de Telefono</label>
            <input
              type="tel"
              value={form.phone}
              onChange={handleChange}
              name="phone"
              required
            />
            <label>Email</label>
            <input
              type="email"
              value={form.mail}
              onChange={handleChange}
              name="mail"
              required
            />
            <label>Ciudad</label>
            <input
              type="text"
              value={form.city}
              onChange={handleChange}
              name="city"
              required
            />
            <label>Supervisor Id</label>
            <input
              type="text"
              value={form.supervisorId}
              onChange={handleChange}
              name="supervisorId"
              required
            />
            <label>Rol</label>
            <input
              type="text"
              value={form.role}
              onChange={handleChange}
              name="role"
              required
            />
            <label>Password</label>
            <input
              type="Password"
              value={form.password}
              onChange={handleChange}
              name="password"
              required
            />
            <label>Administrador</label>
            <input
              type="Boolean"
              value={form.admin}
              onChange={handleChange}
              name="admin"
              required
            />
            <label>Inicio de trabajo</label>
            <input
              type="date"
              value={form.startAt}
              onChange={handleChange}
              name="startAt"
              required
            />
          </form>
        </div>
        <div>
          <button className="btn-cancel" onClick={closeModal}>
            Cancelar
          </button>
          <button
            className="btn-confirm"
            type="submit"
            onClick={handleSubmit}
          >
            Enviar
          </button>
        </div>
      </ReactModal>
    </div>
  );
}

export default AddEmployee;
