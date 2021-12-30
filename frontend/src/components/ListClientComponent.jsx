
import React, { Component } from 'react';
import ClientService from '../services/ClientService';

class ListClientComponent extends Component {
    constructor(props) {
        super(props) 
        this.state = {
            clients : [] 
        }
        this.addClient = this.addClient.bind(this);
    }
   //This is the best place to make REST API calls! 
componentDidMount(){
    ClientService.getClients().then((res) => {
       this.setState({clients : res.data})
  });
}

addClient(){
    this.props.history.push('/add-client');
}

render(){
    return (
        <div>
            <h2 className="text-center">Client Database (Administrators ONLY)</h2>
            <div className= "row" >
            </div>
            <button className="btn btn-primary"  onClick={this.addClient}>Manual Quote</button>
            <div className = "row">
                <table className = " table table-striped table-bordered ">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th> Phone</th>
                            <th>Email</th>
                            <th>Service</th>
                            <th>Sq. Feet</th>
                            <th>Height</th>
                            <th>Objects Serviced</th>
                            <th> Notes </th>
                            <th> Free Quote (Approx.)</th>
                        </tr>
                    </thead>

                    <tbody>
                        { 
                            this.state.clients.map(
                                client => 
                                <tr key = {client.id}>
                                    <td> {client.name} </td>
                                    <td> {client.phone} </td>
                                    <td> {client.email} </td>
                                    <td> {client.toClean} </td>
                                    <td> {client.sqFeet} </td>
                                    <td> {client.stories} </td>
                                    <td> {client.objects} </td>
                                    <td> {client.notes} </td>
                                    <td> ${client.freeQuote} </td>

                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
        )
    }
    
}
export default ListClientComponent;