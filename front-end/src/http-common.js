import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:9000/api",
    headers: {
        'Access-Control-Allow-Origin': '*',
        "Content-type": "application/json",
    }
});