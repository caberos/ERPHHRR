import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import VacationPage from "./pages/VacationPage";
import EmployeePage from "./pages/EmployeePage";
import HomePage from "./pages/HomePage";
import Sidebar from "./components/Sidebar";
import EmployeeDetail from "./components/employee/EmployeeDetail";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Sidebar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/employees" element={<EmployeePage />} />
          <Route path="/employees/vacation/:id" element={<VacationPage />} />
          <Route path="/employees/employee/:id" Component={EmployeeDetail} />
          <Route path="/leave" element={<EmployeePage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
