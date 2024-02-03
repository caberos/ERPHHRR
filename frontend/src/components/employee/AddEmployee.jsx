import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { createEmployee } from "../../api/request";

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
    Name: "",
    dateBirth: "",
    phone: "",
    mail: "",
    city: "",
    ci: "",
    supervisor: "",
    role: "",
    password: "",
    admin: "",
    start_at: "",
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
        Add Employee
      </button>
      <ReactModal
        style={customStyles}
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
      >
        <h2>Add Employee</h2>
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
            <label>Name</label>
            <input
              type="text"
              value={form.Name}
              onChange={handleChange}
              name="Name"
              required
            />
            <label>Date of Birth</label>
            <input
              type="date"
              value={form.dateBirth}
              onChange={handleChange}
              name="dateBirth"
              required
            />
            <label>Phone number</label>
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
            <label>City</label>
            <input
              type="text"
              value={form.city}
              onChange={handleChange}
              name="city"
              required
            />
            <label>Supervisor</label>
            <input
              type="text"
              value={form.supervisor}
              onChange={handleChange}
              name="supervisor"
              required
            />
            <label>Role</label>
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
            <label>Admin</label>
            <input
              type="Boolean"
              value={form.admin}
              onChange={handleChange}
              name="admin"
              required
            />
            <label>Start to work</label>
            <input
              type="date"
              value={form.start_at}
              onChange={handleChange}
              name="start_at"
              required
            />
          </form>
        </div>
        <div>
          <button className="btn-cancel" onClick={closeModal}>
            Cancel
          </button>
          <button
            className="btn-confirm"
            type="submit"
            onClick={handleSubmit}
          >
            Submit
          </button>
        </div>
      </ReactModal>
    </div>
  );
}

export default AddEmployee;
