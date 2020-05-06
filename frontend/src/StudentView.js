import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class StudentView extends Component {

    constructor(props) {
        super(props);
        this.state = {groups: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/enrollment')
            .then(response => response.json())
            .then(data => this.setState({groups: data, isLoading: false}));
    }


    render() {
        const {groups, isLoading} = this.state;

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

                     <div className="float-right">
                         <Button color="primary" tag={Link} to="/students/search">Search Class</Button>
                     </div>
                    <div className="float-right">
                        <Button color="danger" tag={Link} to="/students/enrollment/delete">Delete Class</Button>
                    </div>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/students/enrollment/add">Add Class</Button>
                    </div>
                    <h3>Student Name Here</h3>
                    <h4>Classes</h4>

                    <Table className="shadow mt-4">
                        <thead>
                        <tr>
                            <th width="20%">CRN</th>
                            <th width="20%">Department</th>
                            <th width="20%">Course Number</th>
                            <th width="20%">Course Title</th>
                        </tr>
                        </thead>
                        <tbody>
                        {groupList}
                        </tbody>
                    </Table>
                    <h4>Assignments</h4>
                    <Table className="shadow mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Type</th>
                            <th width="20%">Title</th>
                            <th width="20%">Location</th>
                            <th width="20%">Due Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        {groupList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default StudentView;