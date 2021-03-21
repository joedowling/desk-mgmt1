import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Header } from './components/Header'
import { Users } from './components/Users'
import { DisplayBoard } from './components/DisplayBoard'
import CreateUser from './components/CreateUser'
import { getAllUsers, createUser } from './services/UserService'
import { getAllZones } from './services/ZoneService'
import moment from 'moment';


class App extends Component {

  state = {
    user: {},
    users: [],
    numberOfUsers: 0,
    zones: [],
    bookings: [],
    desks: [],
    booking: {}
  }

  componentDidMount() {
      getAllZones()
        .then(zones => {
          let user = this.state.user
          console.log("ZONES: ",zones)
          this.setState({zones: zones})
            user.firstName = zones[0].name;
          this.setState({desks: zones[0].desks})
            user.lastName = zones[0].desks[0].name;
            user.email = new Date ();
          // zones.forEach(zone => {
          //   zone.desks.forEach(desk => {
          //     desk.bookings.forEach(booking => {
          //     });
          //   });
          // });
          this.setState({user})
        });
  }

  createUser = (e) => {
      createUser(this.state.user)
        .then(response => {
          console.log(response);
          this.setState({numberOfUsers: this.state.numberOfUsers + 1})
      });
      let user = this.state.user;
      user.email = new Date();
      this.setState({user})
  }


  getAllUsers = () => {
    getAllUsers()
      .then(users => {
        console.log("USERS:", users)
        this.setState({users: users, numberOfUsers: users.length})
      });
  }

  onChangeForm = (e) => {

      let user = this.state.user
      console.log("in onChange:", user)
      if (e.target){
        if (e.target.name === 'zone') {
            user.firstName = e.target.value;
            this.state.zones.forEach(zone => {
              if (zone.name === e.target.value){
                let a = zone.desks.slice(0);
                this.setState({desks: a});
                user.firstName = e.target.value;
                user.lastName = a[0].name;
              }
            });
        } else if (e.target.name === 'desk') {
            user.lastName = e.target.value;
        } 
        
      } else {
          user.email = e;
      }
      this.setState({user})
  }

  render() {
    return (
      
      <div className="App">
        <Header></Header>
        <div className="container mrgnbtm">
          <div className="row">
            <div className="col-md-8">
                <CreateUser 
                  user={this.state.user}
                  onChangeForm={this.onChangeForm}
                  createUser={this.createUser}
                  zones = {this.state.zones}
                  desks = {this.state.desks}
                  bookings = {this.state.bookings}
                  >
                </CreateUser>
            </div>
            <div className="col-md-4">
                <DisplayBoard
                  numberOfUsers={this.state.numberOfUsers}
                  getAllUsers={this.getAllUsers}
                >
                </DisplayBoard>
            </div>
          </div>
        </div>
        <div className="row mrgnbtm">
          <Users users={this.state.users}></Users>
        </div>
      </div>
    );
  }
}

export default App;
