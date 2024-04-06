import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import { createTraining } from "../../api/requests/trainingRequest";


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

function AddTraining({ training }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const location = useLocation();
  const navigate = useNavigate();
  const idEmployee = location.pathname.split("/").pop();
  const [form, setForm] = useState({
    name: "",
    type: "",
    description: "",
    startAt: "",
    endAt: "",
  });

  const handleChange = (event) => {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
      employee: { id: idEmployee },
      trainingId: Math.floor(Math.random() * 100)
    });
  };

  function closeModal() {
    setIsOpen(false);
    navigate(-1);
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await createTraining(form);
      console.log("Training created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating training:", error.message);
    }
    setForm(false);
  };

  return (
    <div className="add-form">
      <h2>Create training</h2>
      <form onSubmit={handleSubmit}>
        <label>Name</label>
        <input
          type="text"
          value={form.name}
          onChange={handleChange}
          name="name"
          required
        />
        <label>Description</label>
        <input
          type="text"
          value={form.description}
          onChange={handleChange}
          name="description"
          required
        />
        <label>Type</label>
        <input
          type="text"
          value={form.address}
          onChange={handleChange}
          name="address"
          required
        />
        <label>Start</label>
        <input
          type="date"
          value={form.startAt}
          onChange={handleChange}
          name="startAt"
          required
        />

        <label>End</label>
        <input
          type="date"
          value={form.endAt}
          onChange={handleChange}
          name="endAt"
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

export default AddTraining;
