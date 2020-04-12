import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class GroupList extends Component {

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
        });
    }

    render() {
        const {groups, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const groupList = groups.map(group => {
            const firstName = `${group.firstName || ''} `;
            const lastName = `${group.lastName || ''} `;
            return <tr key={group.netId}>
                <td style={{whiteSpace: 'nowrap'}}>{group.netId}</td>
                <td>{firstName}</td>
                <td>{lastName}</td>
                {/*<td>{group.events.map(event => {*/}
                {/*    return <div key={event.id}>{new Intl.DateTimeFormat('en-US', {*/}
                {/*        year: 'numeric',*/}
                {/*        month: 'long',*/}
                {/*        day: '2-digit'*/}
                {/*    }).format(new Date(event.date))}: {event.title}</div>*/}
                {/*})}</td>*/}
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/students/" + group.netId}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(group.netId)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/students/new">Add Student</Button>
                    </div>
                    <h3>Students Table</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">NetId</th>
                            <th width="20%">First Name</th>
                            <th width="20%">Last Name</th>
                            {/*<th>Events</th>*/}
                            {/*<th width="10%">Actions</th>*/}
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

export default GroupList;