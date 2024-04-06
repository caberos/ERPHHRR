import React, { useState, useEffect } from "react";
import ReactModal from "react-modal";
import { useLocation, useNavigate } from "react-router-dom";
import { createPosition } from "../../api/requests/positionRequest";
import { departmentListRequest } from "../../api/requests/departmentRequest";

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

function AddPosition({ position }) {
  const [modalIsOpen, setIsOpen] = useState(true);
  const [dep, setDep] = useState([]);
  const [depSelect, setDepSelect] = useState([]);
  const location = useLocation();
  const navigate = useNavigate();

  const idEmployee = location.pathname.split("/").pop();
  const [form, setForm] = useState({
    name: "",
    description: "",
    salary: "",
    department:""
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await departmentListRequest();
        setDep(res.data);
      } catch (error) {
        console.error("Error fetching departments:", error.message);
      }
    };
    fetchData();
  }, []);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setForm({
      ...form,
      [name]: value,
      employee: { id: idEmployee },
      id: Math.floor(Math.random() * 100),
      department: depSelect,
    });
  };

  function closeModal() {
    setIsOpen(false);
    navigate(-1);
  }

  const handleSelect = (e) => {
    setDepSelect({ id: e.target.value });
    setForm({ ...form, department: {id:e.target.value} });
    console.log(depSelect);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log(form);
      const response = await createPosition(form);
      console.log("Position created:", response);
      closeModal();
    } catch (error) {
      console.error("Error creating position:", error.message);
    }
    setForm(false);
  };

  return (
    <div className="add-form">
      <h2>Create Position</h2>
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
        <label>Salary</label>
        <input
          type="number"
          value={form.salary}
          onChange={handleChange}
          name="salary"
          required
        />
        <label>Department</label>
        <select
          value={depSelect}
          onChange={handleSelect}
          name="department"
          required
        >
          <option selected>Please choose one option</option>
          {dep.map((department) => (
            <option value={department.id}>
              {department.id} - {department.name}
            </option>
          ))}
        </select>

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

export default AddPosition;
