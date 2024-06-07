import axios from "../axios"

export const vacationListRequest = async () => {
    try {
        const response = await axios.get("/vacation/getAllObjects");
        return response;
    } catch (error) {
        throw error;
    }
};

export const vacationGetRequest = async (id) => {
    try {
        const response = await axios.get(`/vacation/get/${id}`);
        return response;
    } catch (error) {
        throw error;
    }
};

export const createVacation = async (newVacation) => {
    console.log(newVacation);
    try {
        const response = await axios.post("vacation/create", newVacation, {
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

export const updateVacationRequest = async (id, newVacation) => {
    console.log(newVacation);
    try {
        const response = await axios.put(`vacation/update/${id}`, newVacation, {
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

export const deleteVacation = async (id) => {
    try {
        const response = await axios.delete(`vacation/delete/${id}`);
        console.log(`vacation/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};