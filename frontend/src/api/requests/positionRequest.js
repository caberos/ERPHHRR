import axios from "../axios"

export const positionListRequest = async () => {
    try {
      const response = await axios.get("/position/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const positionGetRequest = async (id) => {
    try {
      const response = await axios.get(`/position/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createPosition = async (newPosition) => {
    try {
      const response = await axios.post("position/create", newPosition, {
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
  
  export const deletePosition = async (id) => {
    try {
        const response = await axios.delete(`position/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
