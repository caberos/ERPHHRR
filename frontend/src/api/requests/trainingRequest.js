import axios from "../axios"

export const trainingListRequest = async () => {
    try {
      const response = await axios.get("/training/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const trainingGetRequest = async (id) => {
    try {
      const response = await axios.get(`/training/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createTraining = async (newTraining) => {
    console.log(newTraining);
    try {
      const response = await axios.post("training/create", newTraining, {
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

  export const updateTrainingRequest = async (id, newTraining) => {
    console.log(newTraining);
    try {
        const response = await axios.put(`training/update/${id}`, newTraining, {
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
  
  export const deleteTraining = async (id) => {
    try {
        const response = await axios.delete(`training/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
