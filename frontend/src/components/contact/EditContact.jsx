import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import {
  updateContactRequest,
  contactGetRequest,
} from "../../api/requests/contactRequest";

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

function EditContact({ contact }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idContact = location.pathname.split("/").pop();

  const [idEmployee, setIdEmployee] = useState(null);
  const [form, setForm] = useState({
    contactId: idContact,
    name: "",
    relation: "",
    phone: "",
    address: "",
    employee: { id: "" },
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await contactGetRequest(idContact);
        var data = response.data;
        setIdEmployee(data.employee.id); 
        console.log(idEmployee);
        console.log(data);
        setForm({
          contactId: idContact,
          name: "",
          relation: "",
          phone: "",
          address: "",
          employee: data.employee,
        });
      
      } catch (error) {
        console.error("Error fetching Contact data:", error);
      }
    };
    fetchData();
  }, [idContact]);

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
      
      const response = await updateContactRequest(idContact, form);
      console.log(response.data);
      closeModal();
    } catch (error) {
      console.error("Error updating Contact:", error.message);
    }
  };

  return (
    <div className="add-form">
      <h2>Editar Contact</h2>
      <form onSubmit={handleSubmit}>
        <label>Name</label>
        <input
          type="text"
          value={form.name}
          onChange={handleChange}
          name="name"
          required
        />
        <label>Relation</label>
        <input
          type="text"
          value={form.relation}
          onChange={handleChange}
          name="relation"
          required
        />
        <label>Address</label>
        <input
          type="text"
          value={form.address}
          onChange={handleChange}
          name="address"
          required
        />
        <label>Phone</label>
        <input
          type="text"
          value={form.phone}
          onChange={handleChange}
          name="phone"
          required
        />
        <div>
          <button className="btn-cancel" onClick={closeModal}>
            Cancelar
          </button>
          <button className="btn-confirm" type="submit">
            Enviar
          </button>
        </div>
      </form>
    </div>
  );
}

export default EditContact;