import Alert from 'react-bootstrap/Alert';
import React, { Component } from 'react';
import ClientService from '../services/ClientService';

class CreateClientComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            // id: this.props.match.params.id,
            phone: '',
            email: '',
            name: ' ',
            sqFeet: ' ',
            objects: ' ',
            stories: ' ',
            toClean: ' ',
            notes: ' '
        }
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeNotesHandler = this.changeNotesHandler.bind(this);
        this.changeSqFeetHandler = this.changeSqFeetHandler.bind(this);
        this.changeStoriesHandler = this.changeStoriesHandler.bind(this);
        this.changeToCleanHandler = this.changeToCleanHandler.bind(this);
        this.changeObjectsHandler = this.changeObjectsHandler.bind(this);
    }

    componentDidMount(){ // step 3 (TRIGGER!)
    }
    saveOrUpdateClient = (e) => {
        e.preventDefault();
        let client = {phone: this.state.phone, email: this.state.email, name: this.state.name, toClean: this.state.toClean,
        sqFeet: this.state.sqFeet, stories: this.state.stories, objects: this.state.objects, notes: this.state.notes};
        console.log('client => ' + JSON.stringify(client));

        ClientService.createClient(client).then( res => {
            this.props.history.push('/');
        }
      );
    }
    cancel(){
            this.props.history.push('/');
    }
    getTitle(){
           // if(this.state.id === '_add'){
       return <h3 className="text-center"> </h3>
           // }else{
          //    return <h3 className="text-center">Update Clients/Quotes</h3> Kind of useless function for this program
         //  }
    }
    changePhoneHandler= (event) => {
        this.setState({phone: event.target.value});
    }
    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }
    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }
    changeNotesHandler= (event) => {
        this.setState({notes: event.target.value});
    }
    changeStoriesHandler= (event) => {
       this.setState({stories: event.target.value});
    }
    changeSqFeetHandler= (event) => {
       this.setState({sqFeet: event.target.value});
    }
    changeToCleanHandler= (event) => {
       this.setState({toClean: event.target.value});
    }
    changeObjectsHandler= (event) => {
       this.setState({objects: event.target.value});
    }
    render() {
        return (
            <div >
                    <div className = "container" >
                       <div className="row">
                            <div className = "card col-md-6 offset-sm-3 offset-sm-3" style={{backgroundColor:"teal", borderRadius:'2rem' ,borderWidth:"1rem"}}>
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}><span style={{color:"red"}}>*</span> Name: </label>
                                            <input placeholder="First Last" name="name" className="form-control"
                                             value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}> <span style={{color:"red"}}>*</span>Phone: </label>
                                            <input placeholder="Exclude: dashes, parenthesis, spaces, etc." name="phone" className="form-control"
                                             value={this.state.phone} onChange={this.changePhoneHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}> <span style={{color:"red"}}>*</span> Email: </label>
                                            <input placeholder="@blank.com" name="email" className="form-control" 
                                             value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}> <span style={{color:"red"}}>*</span> Service: </label>
                                            <input placeholder="i.e 'roof', 'driveway', etc." name="toClean" className="form-control"
                                             value={this.state.toClean} onChange={this.changeToCleanHandler}  />
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}> <span style={{color:"red"}}>*</span> Approximate sq. footage of service? ("0" if not applicable ) </label>
                                            <input placeholder="i.e. '2000'" name="sqFeet" className="form-control"
                                             value={this.state.sqFeet} onChange={this.changeSqFeetHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}>How many stories is the structure?</label>
                                            <input placeholder="i.e. '6' or '0'" name="stories" className="form-control"
                                            value={this.state.stories} onChange={this.changeStoriesHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}><span style={{color:"red"}}>*</span> How many objects are to be serviced? ("0" if not applicable) </label>
                                            <input placeholder="i.e. amount of 'trucks ,tractors, trailers'" name="objects" className="form-control"
                                            value={this.state.objects} onChange={this.changeObjectsHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label style={{color:"white", fontWeight:"bold"}}>General notes: </label>
                                            <input placeholder=" " name="notes" className="form-control"
                                             value={this.state.notes} onChange={this.changeNotesHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateClient}>Submit</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                      </div>
                      <h1></h1>
                  <Alert variant="warning" style={{borderRadius:"1rem"}}  >
                                  <h5 style={{fontFamily:"sans-serif",fontStyle: "italic" ,textDecoration: "underline"}}>This quote is completely FREE!</h5>

                                   <p style={{fontFamily:"sans-serif"}}> Although we do our best to honor the given quote, the final price is subject to change upon in-person inspection.</p>

                                 </Alert>
          </div>
        );
    }
}
export default CreateClientComponent;