import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/students">Update Students Table</Link></Button>
                </Container>
                <Container fluid>
                    <Button color="link"><Link to="/instructors">Update Instructors Table</Link></Button>
                </Container>
                <Container fluid>
                    <Button color="link"><Link to="/courses">Update Courses Table</Link></Button>
                </Container>
                <Container fluid>
                    <Button color="link"><Link to="/assignments">Update Assignments Table</Link></Button>
                </Container>
                <Container fluid>
                    <Button color="link"><Link to="/assessments">Update Assessments Table</Link></Button>
                </Container>
            </div>
        );
    }
}

export default Home;