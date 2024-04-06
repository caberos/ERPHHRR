import axios from "../axios"

export const departmentListRequest = async () => {
    try {
      const response = await axios.get("/department/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const departmentGetRequest = async (id) => {
    try {
      const response = await axios.get(`/department/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createDepartment = async (newDepartment) => {
    console.log(newDepartment);
    try {
      const response = await axios.post("department/create", newDepartment, {
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
  
  export const deleteDepartment = async (id) => {
    try {
        const response = await axios.delete(`department/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
