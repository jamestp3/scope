import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import StudentView from './StudentView';
import AddEnrollment from './AddEnrollment';
import StudentSearch from './StudentSearch';
import InstructorView from "./InstructorView";
import DeleteEnrollment from "./DeleteEnrollment";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/students' exact={true} component={StudentView}/>
                    <Route path='/students/search' component={StudentSearch}/>
                    <Route path='/students/enrollment/add' component={AddEnrollment}/>
                    <Route path='/students/enrollment/delete' component={DeleteEnrollment}/>
                    <Route path='/instructors' exact={true} component={InstructorView}/>
                    <Route path='/instructors/search' component={StudentSearch}/>
                    <Route path='/instructors/enrollment/add' component={AddEnrollment}/>
                    <Route path='/instructors/enrollment/delete' component={DeleteEnrollment}/>
                </Switch>
            </Router>
        )
    }
}

export default App;