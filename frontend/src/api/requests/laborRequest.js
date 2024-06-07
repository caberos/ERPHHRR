import axios from "../axios"

export const laborHistoryListRequest = async () => {
    try {
      const response = await axios.get("/labor_history/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const laborHistoryGetRequest = async (id) => {
    try {
      const response = await axios.get(`/labor_history/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createLaborHistory = async (newLaborHistory) => {
    console.log(newLaborHistory);
    try {
      const response = await axios.post("labor_history/create", newLaborHistory, {
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

  export const updateLaborHistoryRequest = async (id, newLaborHistory) => {
    console.log(newLaborHistory);
    try {
        const response = await axios.put(`labor_history/update/${id}`, newLaborHistory, {
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
  
  export const deleteLaborHistory = async (id) => {
    try {
        const response = await axios.delete(`labor_history/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
