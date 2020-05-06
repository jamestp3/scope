import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class StudentView extends Component {
    courseTitle;
    courseNumber;
    department;

    constructor(props) {
        super(props);
        this.state = {groups: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/students')
            .then(response => response.json())
            .then(data => this.setState({groups: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/student/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedGroups = [...this.state.groups].filter(i => i.id !== id);
            this.setState({groups: updatedGroups});
            this.render();
        });
    }

    render() {
        const {groups, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const groupList = groups.map(group => {
            const courseTitle = `${group.courseTitle || ''} `;
            const courseNumber = `${group.courseNumber || ''} `;
            const department = `${group.department || ''} `;

            return <tr key={group.CRN}>
                    <td style={{whiteSpace: 'nowrap'}}>{group.CRN}</td>
                    <td>{department}</td>
                    <td>{courseNumber}</td>
                    <td>{courseTitle}</td>

                    {/*<td>*/}
                    {/*    <ButtonGroup>*/}
                    {/*        <Button size="sm" color="primary" tag={Link} to={"/students/" + group.netId}>Edit</Button>*/}
                    {/*        <Button size="sm" color="danger" onClick={() => this.remove(group.netId)}>Delete</Button>*/}
                    {/*    </ButtonGroup>*/}
                    {/*</td>*/}
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
                        <Button color="danger" tag={Link} to="/students/delete">Delete Class</Button>
                    </div>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/students/new">Add Class</Button>
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