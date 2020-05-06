import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import StudentView from './StudentView';
import AddEnrollment from './AddEnrollment';
import StudentSearch from './StudentSearch';
import InstructorView from "./InstructorView";
import DeleteEnrollment from "./DeleteEnrollment";
import AddTeaches from "./AddTeaches";
import DeleteTeaches from "./DeleteTeaches";
import SearchTeaches from "./SearchTeaches";
import DisplayStudentCourses from "./DisplayStudentCourses";
import DisplayInstructorCourses from "./DisplayInstructorCourses";

import StudentSearchAssignments from "./StudentSearchAssignments";
import InstructorSearchAssignments from "./InstructorSearchAssignments";

import InstructorDisplayAssignments from "./InstructorDisplayAssignments";
import StudentDisplayAssignments from "./StudentDisplayAssignments";







class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/students' exact={true} component={StudentView}/>
                    <Route path='/students/display' component={DisplayStudentCourses}/>
                    <Route path='/students/search' component={StudentSearch}/>
                    <Route path='/students/enrollment/add' component={AddEnrollment}/>
                    <Route path='/students/enrollment/delete' component={DeleteEnrollment}/>
                    <Route path='/students/assignment/search' component={StudentSearchAssignments}/>
                    <Route path='/instructors/assignment/search' component={InstructorSearchAssignments}/>
                    <Route path='/instructors' exact={true} component={InstructorView}/>
                    <Route path='/instructors/display' component={DisplayInstructorCourses}/>
                    <Route path='/instructors/search' component={SearchTeaches}/>
                    <Route path='/instructors/teaches/add' component={AddTeaches}/>
                    <Route path='/instructors/teaches/delete' component={DeleteTeaches}/>

                    <Route path='/instructors/assignment/display' component={InstructorDisplayAssignments}/>
                    <Route path='/students/assignment/display' component={StudentDisplayAssignments}/>

                </Switch>
            </Router>
        )
    }
}

export default App;