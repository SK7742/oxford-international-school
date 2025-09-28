import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Adjust the base URL to your backend
});

export default api;
