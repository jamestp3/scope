import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import StudentView from './StudentView';
import GroupEdit from './GroupEdit';
import StudentSearch from './StudentSearch';
import InstructorView from "./InstructorView";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/students' exact={true} component={StudentView}/>
                    <Route path='/students/search' component={StudentSearch}/>
                    <Route path='/students/:id' component={GroupEdit}/>
                    <Route path='/instructors' exact={true} component={InstructorView}/>
                    <Route path='/instructors/search' component={StudentSearch}/>
                    <Route path='/instructors/:id' component={GroupEdit}/>
                </Switch>
            </Router>
        )
    }
}

export default App;