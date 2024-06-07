import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateEmployeeRequest,
  employeeGetRequest,
} from "../../api/requests/employeeRequest";

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

function EditEmployee({ employee }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEmployee = location.pathname.split("/").pop();

  const [employee, setEmployee] = useState(null);

  const [form, setForm] = useState({
    id: idEmployee,
    supervisorId: "",
    name: "",
    role: "",
    phone: "",
    password: "",
    city: "",
    birthday: "",
    startAt: "",
    positions: [],
    laborHistories: [],
    trainings: [],
    licensesCertifications: [],
    evaluations: [],
    incidents: [],
    contacts: [],
    accomplishments: [],
    vacations: [],
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await employeeGetRequest(idEmployee);
        var data = response.data;
        setEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
          id: idEmployee,
          supervisorId: "",
          name: "",
          role: "",
          phone: "",
          password: "",
          city: "",
          birthday: "",
          startAt: "",
          positions: data.positions,
          laborHistories: data.laborHistories,
          trainings: data.trainings,
          licensesCertifications: data.licensesCertifications,
          evaluations: data.evaluations,
          incidents: data.incidents,
          contacts: data.contacts,
          accomplishments: data.accomplishments,
          vacations: data.vacations,
        });
      } catch (error) {
        console.error("Error fetching employee data:", error);
      }
    };
    fetchData();
  }, [idEmployee]);

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
      const response = await updateEmployeeRequest(idEmployee, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating employee:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Incidente</h2>
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

export default EditEmployee;
