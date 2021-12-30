import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListClientComponent from './components/ListClientComponent';
import HeaderComponent from './components/HeaderComponent';
import CreateClientComponent from './components/CreateClientComponent';
import MainPageComponent from './components/MainPageComponent';
function App() {
  return (


    <div> 
     <HeaderComponent />
            <div className="container">
              <Router>    
                <Switch>  
                  <Route path ="/" exact={true} component = {MainPageComponent}></Route>
                  <Route path ="/clients" component = {ListClientComponent}></Route>
                  <Route path ="/add-client" component = {CreateClientComponent}></Route>
                </Switch>
              </Router>
            </div>

      </div>
  );
}
export default App;
//  <Route path ="/" exact component = {ListPatientComponent}></Route>