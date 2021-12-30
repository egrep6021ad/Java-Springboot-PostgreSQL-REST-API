import axios from 'axios';
const CLIENT_API_BASE_URL = "http://localhost:8080/api/v1/clients"

//This makes a REST API call!!!
class ClientService {
     getClients(){
         return axios.get(CLIENT_API_BASE_URL);
     }
     createClient(client){
        return axios.post(CLIENT_API_BASE_URL, client);
    }
    updateClient(client) {
        return axios.post(CLIENT_API_BASE_URL, client.notes);
    }


}
export default new ClientService()