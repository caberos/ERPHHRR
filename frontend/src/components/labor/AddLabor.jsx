import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import { createVacation } from "../../api/requests/vacationRequest";
import { createLaborHistory } from "../../api/requests/laborRequest";

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

function AddLabor({ labor }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEmployee = location.pathname.split("/").pop();
  const [form, setForm] = useState({
    labor_id: "",
    description: "",
    posId: "",
    startAt: "",
  });

  const handleChange = (event) => {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
      labor_id: Math.floor( Math.random() * 100),
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
      const response = await createLaborHistory(form);
      console.log("Vacation created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating Vacation:", error.message);
    }
    setForm(false);
  };

  return (
    <div className="add-form">
      <h2>Create Labor history</h2>
      <form onSubmit={handleSubmit}>
        <label>Description</label>
        <input
          type="text"
          value={form.description}
          onChange={handleChange}
          name="description"
          required
        />
        <label>position</label>
        <input
          type="number"
          value={form.position}
          onChange={handleChange}
          name="position"
          required
        />
        <label>Start At</label>
        <input
          type="date"
          value={form.startAt}
          onChange={handleChange}
          name="startAt"
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

export default AddLabor;
