import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class StudentSearch extends Component {

    emptyItem = {
        netId: '',
    };



    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem,

        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'search') {
            const group = await (await fetch(`/api/student/${this.props.match.params.id}`)).json();
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

        await fetch('/api/students').then(response=>response.json);

        //this.props.history.push('/students');

    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Find Student' : 'Student'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="netId">NetId</Label>
                        <Input type="text" name="netId" id="name" value={item.netId || ''}
                               onChange={this.handleChange} autoComplete="netId"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Search</Button>{' '}
                        <Button color="secondary" tag={Link} to="/students">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(StudentSearch);