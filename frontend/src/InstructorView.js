import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class InstructorView extends Component {

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
                    <h1>Instructor Portal</h1>
                    <h4>Classes and Assignments</h4>

                    <div className="float-left">
                        <Button color="success" tag={Link} to="/instructors/display">Display Courses Taught By Instructor</Button>
                    </div>
                    <div className="float-left">
                        <Button color="primary" tag={Link} to="/instructors/search">Search Class By CRN</Button>
                    </div>
                    <div className="float-left">
                        <Button color="danger" tag={Link} to="/instructors/teaches/delete">Delete Taught Class</Button>
                    </div>
                    <div className="float-left">
                        <Button color="success" tag={Link} to="/instructors/teaches/add">Add Taught Class</Button>
                    </div>
                    <div className="float-left">
                        <Button color="success" tag={Link} to="/instructors/assignment/display">Display Assignment By Instructor</Button>
                    </div>
                    <div className="float-left">
                        <Button color="primary" tag={Link} to="/instructors/assignment/search">Search Assignment By CRN</Button>
                    </div>
                </Container>
            </div>
        );
    }
}

export default InstructorView;