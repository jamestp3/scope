import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class ClassEdit extends Component {

    emptyItem = {
        CRN: '',
        department: '',
        courseNumber: '',
        courseTitle: '',
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const group = await (await fetch(`/api/course/${this.props.match.params.id}`)).json();
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

        await fetch('/api/course', {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/students');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Student' : 'Add Student'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="CRN">CRN</Label>
                        <Input type="text" name="CRN" id="CRN" value={item.CRN || ''}
                               onChange={this.handleChange} autoComplete="CRN"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="department">Department</Label>
                        <Input type="text" name="department" id="department" value={item.department || ''}
                               onChange={this.handleChange} autoComplete="department"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="courseNumber">Course Number</Label>
                        <Input type="text" name="courseNumber" id="courseNumber" value={item.courseNumber || ''}
                               onChange={this.handleChange} autoComplete="courseNumber"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="courseTitle">Course Title</Label>
                        <Input type="text" name="courseTitle" id="courseTitle" value={item.courseTitle || ''}
                               onChange={this.handleChange} autoComplete="courseTitle"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/students">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(ClassEdit);