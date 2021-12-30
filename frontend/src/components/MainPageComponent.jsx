import Carousel from 'react-bootstrap/Carousel'
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { Component } from 'react';
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import "../App.css"

class MainPageComponent extends Component {

    render() {
        return (


            <div>
                <Carousel>
                    <Carousel.Item>
                        <img
                            className="d-block w-100"
                            src="https://www.cummingexteriorcleaning.com/fbm-data/images/Water-Works-Exterior-Cleaning.jpg"
                            alt="First slide"
                        />
                    <Carousel.Caption></Carousel.Caption>
                    </Carousel.Item>

                    <Carousel.Item>
                        <img
                            className="d-block w-100"
                            src="https://media.istockphoto.com/photos/man-cleaning-terrace-with-a-power-washer-high-water-pressure-cleaner-picture-id1029328566?k=20&m=1029328566&s=612x612&w=0&h=UlaUc9aYYHRoOs_1_IXg7TM9GALQZgrWxz6uJo7a6T8="
                            alt="Second slide"
                        />
                    <Carousel.Caption></Carousel.Caption>
                    </Carousel.Item>

                    <Carousel.Item>
                        <img
                            className="d-block w-100"
                            src="https://www.hipcleaning.com/wp-content/uploads/2016/07/high-performance-exterior-services.jpg"
                            alt="Third slide"
                        />
                        <Carousel.Caption> </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>

                <Container>
                    <Row>
                        <Col>
                            <div>
                            <body>
                                    <h4 style={{color:'teal',fontSize: '1.79rem',fontFamily: "Brush Script MT" ,display:'flex',justifyContent:"center", alignItems: "center", }}>Commercial</h4>
                                        <p2> </p2>
                                       <iframe width="100%" height="400px" src="https://www.youtube.com/embed/ypFpl6Rt558?controls=0&amp;start=19" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowFullScreen/>
                                       <p> </p>
                                       <div style={{display:'flex',justifyContent:"center", alignItems: "center"}}>
                                            <Button style={{borderColor:"white",fontSize: '1.2rem', fontFamily: "Brush Script MT"}} variant="outline-secondary" ><a href="https://www.cummingexteriorcleaning.com/projects" style={{color: 'teal'}}>Explore</a></Button>
                                       </div>
                            </body>
                        </div>
                    </Col>

                     <Col>
                        <div >
                            <body>
                                <h4 style={{color:'teal',fontSize: '1.79rem',fontFamily: "Brush Script MT" ,display:'flex',justifyContent:"center", alignItems: "center"}}>Residential</h4>
                                    <p2> </p2>
                                    <iframe width="100%" height="400px" src="https://www.youtube.com/embed/Ojae0qdoD9E?controls=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowFullScreen/>
                                    <p> </p>
                                    <div style={{display:'flex',justifyContent:"center", alignItems: "center"}}>
                                        <Button style={{borderColor:"white", fontSize: '1.2rem', fontFamily: "Brush Script MT"}} variant="outline-secondary"><a href= "https://www.cummingexteriorcleaning.com/soft-washing-company" style={{color: 'teal'}}>Explore</a></Button>
                                    </div>
                            </body>
                        </div>
                    </Col>
                </Row>
             </Container>



        <Container>
         <Row>
            <div style={{padding:"10px",display:'flex',justifyContent:"center", alignItems: "center", fontSize:".6rem"}}>
                <span className="text-muted"> All Rights Reserved 2023 @ Water Works Exterior Cleaning&trade;</span>
            </div>
            <Col>
               <div>
               </div>
            </Col>
            </Row>
            </Container>
          </div>
        );
    }

}

export default MainPageComponent;


