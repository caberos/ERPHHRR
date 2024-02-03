import React from "react";
import "./Search.css";

function SearchEmployee({ searchValue, HandleSearch }) {
  const handleSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <div className="employeeSearch">
      <form className="employeeSearch__form" onSubmit={handleSubmit}>
        <input
          type="text"
          value={searchValue}
          onChange={handleSubmit}
          placeholder="Search employee"
        />
      </form>
    </div>
  );
}

export default SearchEmployee;
