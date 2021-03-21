import React from 'react'
import Form from 'react-bootstrap/Form';
import DatePicker from 'react-datetime';

import 'react-datetime/css/react-datetime.css';

const CreateUser = ({user, onChangeForm, createUser, zones, desks, bookings }) => {

        const zones1 = /*getAllZones()*/
        [
          'America',
          'India',
          'Australia',
          'Argentina',
          'Ireland',
          'Indonesia',
          'Iceland',
          'Japan'
        ]

        let inputProps = {
            name:"date",
            placeholder:"Date"
        };

        console.log("desks:", desks)
        console.log("bookings:", bookings)
        console.log("user:", user)
      
    return(
        <div className="container">
            <div className="row">
                <div className="col-md-7 mrgnbtm">
                <h2>Reserve Desk</h2>
                <form>
                    <div className="row">
                        <div className="form-group col-md-6">
                            <Form.Group controlId="exampleForm.SelectZone">
                                <Form.Label>Zone</Form.Label>
                                <Form.Control className="form-control" as="select" custom onChange={(e) => onChangeForm(e)} name="zone" placeholder="Zone">
                                    {zones.map(response => <option key={response.id} value={response.name}> {response.name} </option>)}
                                </Form.Control>
                            </Form.Group>
                        </div>
                        <div className="form-group col-md-6">
                            <Form.Group controlId="exampleForm.SelectDesk">
                                <Form.Label>Desk</Form.Label>
                                <Form.Control className="form-control" as="select" custom onChange={(e) => onChangeForm(e)} name="desk" placeholder="Desk">
                                    {desks.map(response => <option key={response.id} value={response.name}> {response.name} </option>)}
                                </Form.Control>
                            </Form.Group>
                        </div>
                    </div>
                </form>
                        <div className="form-group col-md-12">
                            <label>Start Date</label>
                            <DatePicker 
                                inputProps={inputProps}
                                value={user.email}
                                dateFormat="MMMM Do YYYY"
                                timeFormat="hh:mm:ss a"
                                onChange={e => onChangeForm(e)}
                            />
                        </div>
                    <button type="button" onClick= {(e) => createUser()} className="btn btn-danger">Reserve</button>

                </div>
            </div>
        </div>
    )
}

export default CreateUser