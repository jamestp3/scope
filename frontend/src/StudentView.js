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

                     <div className="float-right">
                         <Button color="primary" tag={Link} to="/students/search">Search Class</Button>
                     </div>
                    <div className="float-right">
                        <Button color="danger" tag={Link} to="/students/enrollment/delete">Delete Class</Button>
                    </div>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/students/enrollment/add">Add Class</Button>
                    </div>
                    <h4>Student Portal - lofendo2</h4>
                    {/*<h6>lofendo2</h6>*/}

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
                </Container>
            </div>
        );
    }
}

export default StudentView;