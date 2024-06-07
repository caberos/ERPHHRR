import axios from "../axios"

export const accomplishmentListRequest = async () => {
    try {
        const response = await axios.get("/accomplishment/getAllObjects");
        return response;
    } catch (error) {
        throw error;
    }
};

export const accomplishmentGetRequest = async (id) => {
    try {
        const response = await axios.get(`/accomplishment/get/${id}`);
        return response;
    } catch (error) {
        throw error;
    }
};

export const createAccomplishment = async (newAccomplishment) => {
    console.log(newAccomplishment);
    try {
        const response = await axios.post("accomplishment/create", newAccomplishment, {
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
export const updateAccomplishment = async (id, newAccomplishment) => {
    console.log(newAccomplishment.accomplishmentId);
    
    //conseguir un metodo que cambie el dia a long
    try {
        const response = await axios.put(`accomplishment/update/${id}`, newAccomplishment, {
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

export const deleteAccomplishment = async (id) => {
    try {
        const response = await axios.delete(`accomplishment/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};