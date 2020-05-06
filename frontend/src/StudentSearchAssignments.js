import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class StudentSearchAssignments extends Component {

    emptyItem = {
        netId: '',
    };


    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem,
            value: ""
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const group = await (await fetch(`/api/Assessment/${this.props.match.params.id}`)).json();
            this.setState({item: group});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        const response = await fetch('http://localhost:8080/api/Assessment/' + item.crn);
        const data = await response.json();
        this.setState({ value: JSON.stringify(data) })

        //this.props.history.push('/students');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{'Search Assignments'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="net_id">CRN</Label>
                        <Input type="text" name="net_id" id="net_id" value={item.net_id || ''}
                               onChange={this.handleChange} autoComplete="net_id"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Search</Button>{' '}
                        <Button color="secondary" tag={Link} to="/students">Cancel</Button>
                    </FormGroup>
                </Form>
                <text>
                    {this.state.value}
                </text>
            </Container>
        </div>
    }
}

export default withRouter(StudentSearchAssignments);