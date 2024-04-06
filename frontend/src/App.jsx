import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import VacationPage from "./pages/VacationPage";
import EmployeePage from "./pages/EmployeePage";
import AccomplishmentPage from "./pages/AccomplishmentPage";
import IncidentPage from "./pages/IncidentPage";
import EvaluationPage from "./pages/EvaluationPage";
import LaborHistoryPage from "./pages/LaborHistoryPage";
import HomePage from "./pages/HomePage";
import Sidebar from "./components/Sidebar";
import EmployeeDetail from "./components/employee/EmployeeDetail";
import AddContact from "./components/contact/AddContact";
import AddTraining from "./components/training/AddTraining";
import AddPosition from "./components/position/AddPosition";
import AddLicenses from "./components/licenses/AddLicenses";
import AddVacation from "./components/vacation/AddVacation";
import AddLabor from "./components/labor/AddLabor";
import AddAccomplishment from "./components/accomplishment/AddAccomplishment";
import AddIncident from "./components/incident/AddIncident";
import AddEvaluation from "./components/evaluation/AddEvaluation";
import DepartmentPage from "./pages/DepartmentPage";
import EquipmentPage from "./pages/EquipmentPage";
import DepartmentDetail from "./components/department/DepartmentDetail";
import EquipmentDetail from "./components/equipment/EquipmentDetail";
import EditAccomplishment from "./components/accomplishment/EditAccomplishment";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Sidebar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/employees" element={<EmployeePage />} />
          <Route path="/departments" element={<DepartmentPage />} />
          <Route path="/equipments" element={<EquipmentPage />} />
          <Route path="/employee/vacation/:id" element={<VacationPage />} />
          <Route path="/employee/accomplishment/:id" element={<AccomplishmentPage />} />
          <Route path="/employee/accomplishment/edit/:id/:id" element={<EditAccomplishment />} />
          <Route path="/employee/incident/:id" element={<IncidentPage />} />
          <Route path="/employee/laborHistory/:id" element={<LaborHistoryPage />} />
          <Route path="/employee/evaluation/:id" element={<EvaluationPage />} />
          <Route path="/employee/AddContact/:id" element={<AddContact />} />
          <Route path="/employee/AddTraining/:id" element={<AddTraining />} />
          <Route path="/employee/AddPosition/:id" element={<AddPosition />} />
          <Route path="/employee/AddLicenses/:id" element={<AddLicenses />} />
          <Route path="/employee/AddVacation/:id" element={<AddVacation />} />
          <Route path="/employee/AddLabor/:id" element={<AddLabor />} />
          <Route path="/employee/AddAccomplishment/:id" element={<AddAccomplishment />} />
          <Route path="/employee/AddIncident/:id" element={<AddIncident />} />
          <Route path="/employee/AddEvaluation/:id" element={<AddEvaluation />} />
          <Route path="/employee/:id" Component={EmployeeDetail} />
          <Route path="/department/:id" Component={DepartmentDetail} />
          <Route path="/equipments/:id" Component={EquipmentDetail} />
          <Route path="/leave" element={<EmployeePage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
