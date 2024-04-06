import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import { createLicenses } from "../../api/requests/licensesRequest";

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

function AddLicenses({ licenses }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEmployee = location.pathname.split("/").pop();
  const [form, setForm] = useState({
    name: "",
    expired: "",
  });

  const handleChange = (event) => {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
      employee: { id: idEmployee },
      licensesId: Math.floor( Math.random() * 100),
    });
  };

  function closeModal() {
    setIsOpen(false);
    navigate(-1);
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log(form);
      const response = await createLicenses(form);
      console.log("Liceses created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating Licenses:", error.message);
    }
    setForm(false);
  };

  return (
    <div className="add-form">
      <h2>Create Licenses</h2>
      <form onSubmit={handleSubmit}>
        <label>Name</label>
        <input
          type="text"
          value={form.name}
          onChange={handleChange}
          name="name"
          required
        />
        <label>Expired</label>
        <input
          type="date"
          value={form.expired}
          onChange={handleChange}
          name="expired"
          required
        />
        <div>
          <button className="btn-cancel" onClick={closeModal}>
            Cancel
          </button>
          <button className="btn-confirm" type="submit" onClick={handleSubmit}>
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddLicenses;
