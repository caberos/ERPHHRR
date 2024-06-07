import axios from "../axios"

export const contactListRequest = async () => {
    try {
        const response = await axios.get("/contact/getAllObjects");
        return response;
    } catch (error) {
        throw error;
    }
};

export const contactGetRequest = async (id) => {
    try {
        const response = await axios.get(`/contact/get/${id}`);
        return response;
    } catch (error) {
        throw error;
    }
};

export const createContact = async (newContact) => {
    console.log(newContact);
    try {
        const response = await axios.post("contact/create", newContact, {
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

export const updateContactRequest = async (id, newContact) => {
    console.log(newContact);
    try {
        const response = await axios.put(`contact/update/${id}`, newContact, {
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


export const deleteContact = async (id) => {
    try {
        const response = await axios.delete(`contact/delete/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};