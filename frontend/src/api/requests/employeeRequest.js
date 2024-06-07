import axios from "../axios"

export const employeeListRequest = async () => {
  try {
    const response = await axios.get("/employee/getAllObjects");
    return response;
  } catch (error) {
    throw error;
  }
};

export const employeeGetRequest = async (id) => {
  try {
    const response = await axios.get(`/employee/get/${id}`);
    return response;
  } catch (error) {
    throw error;
  }
};

export const employeeGetPositionRequest = async (id) => {
  try {
    const response = await axios.get(`/employee/getAllPositions/${id}`);
    return response;
  } catch (error) {
    throw error;
  }
};

export const createEmployee = async (newEmployee) => {
  console.log(newEmployee);
  try {
    const response = await axios.post("employee/create", newEmployee, {
      headers: {
        'Content-Type': 'application/json',
      }
    });
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.log(error);
    throw error;
  }
};

export const updateEmployeeRequest = async (id, newEmployee) => {
  console.log(newEmployee);
  try {
      const response = await axios.put(`employee/update/${id}`, newEmployee, {
          headers: {
              'Content-Type': 'application/json',
          }
      });
      console.log(response.data);
      return response.data;
  } catch (error) {
      console.log(error);
      throw error;
  }
};

export const deleteEmployee = async (id) => {
  try {
    const response = await axios.delete(`employee/delete/${id}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw error;
  }
};