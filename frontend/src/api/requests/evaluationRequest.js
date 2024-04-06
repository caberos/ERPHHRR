import axios from "../axios"

export const evaluationListRequest = async () => {
    try {
      const response = await axios.get("/evaluation/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const evaluationGetRequest = async (id) => {
    try {
      const response = await axios.get(`/evaluation/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createEvaluation = async (newEvaluation) => {
    console.log(newEvaluation);
    try {
      const response = await axios.post("evaluation/create", newEvaluation, {
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
  
  export const deleteEvaluation = async (id) => {
    try {
        const response = await axios.delete(`evaluation/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
