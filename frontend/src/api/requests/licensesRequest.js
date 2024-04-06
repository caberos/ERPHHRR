import axios from "../axios"

export const licensesListRequest = async () => {
    try {
      const response = await axios.get("/lic_cert/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const licensesGetRequest = async (id) => {
    try {
      const response = await axios.get(`/lic_cert/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createLicenses = async (newLicenses) => {
    console.log(newLicenses);
    try {
      const response = await axios.post("lic_cert/create", newLicenses, {
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
  
  export const deleteLicenses = async (id) => {
    try {
        const response = await axios.delete(`lic_cert/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
