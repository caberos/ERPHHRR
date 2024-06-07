import axios from "../axios"

export const incidentListRequest = async () => {
    try {
      const response = await axios.get("/incident/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const incidentGetRequest = async (id) => {
    try {
      const response = await axios.get(`/incident/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createIncident = async (newIncident) => {
    console.log(newIncident);
    try {
      const response = await axios.post("evaluation/create", newIncident, {
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
  
  export const updateIncidentRequest = async (id, newIncident) => {
    console.log(newIncident);
    try {
        const response = await axios.put(`incident/update/${id}`, newIncident, {
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

  export const deleteIncident = async (id) => {
    try {
        const response = await axios.delete(`incident/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
