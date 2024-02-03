import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import EmployeePage from "./pages/EmployeePage";
import VacationPage from "./pages/VacationPage";

function RoutePage() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/employee" element={<EmployeePage />} />
        <Route path="/employee/vacation" element={<VacationPage />} />
      </Routes>
    </Router>
  );
}

export default RoutePage;
