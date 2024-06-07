import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateLicRequest,
  licensesGetRequest,
} from "../../api/requests/licensesRequest";

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

function EditLicenses({ licenses }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idLicenses = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    licensesId: idLicenses,
    name: "",
    expired: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await licensesGetRequest(idLicenses);
        var data = response.data;
        setIdEmployee(data.employee.id);
        console.log(idEmployee);
        console.log(data);
        setForm({
          licensesId: idLicenses,
          name: "",
          expired: "",
          employee: data.employee,
        });
      } catch (error) {
        console.error("Error fetching licenses data:", error);
      }
    };
    fetchData();
  }, [idLicenses]);

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
      const response = await updateLicRequest(idLicenses, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating licenses:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Licencia</h2>
      <form onSubmit={handleSubmit}>
        <label>Nombre</label>
        <input
          type="text"
          value={form.name}
          onChange={handleChange}
          name="name"
          required
        />
        <label>Expira</label>
        <input
          type="date"
          value={form.expired}
          onChange={handleChange}
          name="expired"
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

export default EditLicenses;
