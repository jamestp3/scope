import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class DeleteTeaches extends Component {

    emptyItem = {
        net_id: '',
        crn: '',
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
            const group = await (await fetch(`/api/teaches/${this.props.match.params.id}`)).json();
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

        await fetch('/api/teaches/' + item.net_id + '/' + item.crn, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/instructors');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{'Delete Taught Class'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="net_id">NetId</Label>
                        <Input type="text" name="net_id" id="net_id" value={item.net_id || ''}
                               onChange={this.handleChange} autoComplete="net_id"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="crn">CRN</Label>
                        <Input type="text" name="crn" id="crn" value={item.crn || ''}
                               onChange={this.handleChange} autoComplete="crn"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Submit</Button>{' '}
                        <Button color="secondary" tag={Link} to="/instructors">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(DeleteTeaches);