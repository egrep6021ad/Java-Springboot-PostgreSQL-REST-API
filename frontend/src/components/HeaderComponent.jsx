import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar'
import NavDropdown from 'react-bootstrap/NavDropdown'
import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }


    render() {
        return (
    <div>
          <header>
          <Navbar bg="#primary;" expand="lg">
  <Container>
    <Navbar.Brand href="/" style={{fontSize:"2.15rem",fontWeight:"bold", fontFamily: "Brush Script MT", color:"teal",}}> Water Works Exterior Cleaning</Navbar.Brand>
    <Navbar.Toggle aria-controls="basic-navbar-nav" />
    <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="me-auto">
        <Nav.Link style={{maxWidth:'40%',backgroundColor:"#FFAF2E", fontWeight: "bold", fontStyle: "italic"}}href="/add-client">Instant Quote!&copy;</Nav.Link>
        <Nav.Link href="/clients">Login</Nav.Link>
        <NavDropdown title="More" id="basic-nav-dropdown">
        <NavDropdown.Item href="https://www.cummingexteriorcleaning.com/about">About Us</NavDropdown.Item>
          <NavDropdown.Item href="https://www.cummingexteriorcleaning.com/">All Services</NavDropdown.Item>
          <NavDropdown.Item href="https://www.cummingexteriorcleaning.com/reviews">Reviews</NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="https://www.cummingexteriorcleaning.com/contact-us">Contact</NavDropdown.Item>
        </NavDropdown>
      </Nav>
    </Navbar.Collapse>
  </Container>
</Navbar>
        </header> 
    </div>
        );
    }
}

export default HeaderComponent;