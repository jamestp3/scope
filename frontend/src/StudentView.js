import React, { Component } from 'react';
import {Button, ButtonGroup, Container, Form, FormGroup, Input, Label, Table} from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class StudentView extends Component {

    emptyItem = {
        netId: 'lofendo2'
    };

    constructor(props) {
        super(props);
        this.state = {groups: [], isLoading: true, item: this.emptyItem};
    }

    componentDidMount() {
        // if (this.props.match.params.id !== 'new') {
        //     const group = fetch(`/api/course/${this.props.match.params.id}`).json();
        //     this.setState({item: group});
        // }
        this.setState({isLoading: true});
        fetch('api/students')
            .then(response => response.json())
            .then(data => this.setState({groups: data, isLoading: false}));
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = this.state.item;
        item[name] = value;
        this.setState({item});
    }


    render() {
        const {groups, isLoading} = this.state;
        const {item} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const groupList = groups.map(group => {
            const department = `${group.department || ''} `;
            const course_number = `${group.course_number || ''} `;
            const course_title = `${group.course_title || ''} `;

            return <tr key={group.crn}>
                <td style={{whiteSpace: 'nowrap'}}>{group.crn}</td>
                <td>{department}</td>
                <td>{course_number}</td>
                <td>{course_title}</td>
                <td>
                    {/*<ButtonGroup>*/}
                    {/*    <Button size="sm" color="danger" onClick={() => this.remove(group.net_id, group.crn)}>Delete</Button>*/}
                    {/*</ButtonGroup>*/}
                </td>
            </tr>
        });


        return (

            <div>
                <AppNavbar/>
                <Container fluid>
                    <h1>Student Portal</h1>
                    <h4>Classes and Assignments</h4>
                    <div className="float-left">
                        <Button color="success" tag={Link} to="/students/display">Display Courses By Student</Button>
                    </div>
                    <div className="float-left">
                        <Button color="primary" tag={Link} to="/students/search">Search Course By CRN</Button>
                    </div>
                    <div className="float-left">
                        <Button color="danger" tag={Link} to="/students/enrollment/delete">Delete Enrollment</Button>
                    </div>
                    <div className="float-left">
                        <Button color="success" tag={Link} to="/students/enrollment/add">Add Enrollment</Button>
                    </div>
                    {/*<h4>Assignments</h4>*/}
                    <div className="float-left">
                        <Button color="primary" tag={Link} to="/students/assignment/display">Display Assignment By Student</Button>
                    </div>
                    <div className="float-left">
                        <Button color="success" tag={Link} to="/students/assignment/search">Search Assignment By CRN</Button>
                    </div>



                </Container>
                <Container>

                </Container>
            </div>
    );
    }
}

export default StudentView;