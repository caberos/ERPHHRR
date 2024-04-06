import axios from "../axios"

export const equipmentListRequest = async () => {
    try {
      const response = await axios.get("/equipment/getAllObjects");
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const equipmentGetRequest = async (id) => {
    try {
      const response = await axios.get(`/equipment/get/${id}`);
      return response;
    } catch (error) {
      throw error;
    }
  };
  
  export const createEquipment = async (newEquipment) => {
    console.log(newEquipment);
    try {
      const response = await axios.post("equipment/create", newEquipment, {
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
  
  export const deleteEquipment = async (id) => {
    try {
        const response = await axios.delete(`equipment/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
  
  