import React from 'react'
import moment, { isMoment, now } from 'moment';

export const Users = ({users}) => {

    console.log('users length:::', users.length)
    if (users.length === 0) return null

    const UserRow = (user,index) => {

        var dateString = user.email;
        var dateObj = new Date(dateString);
        var momentObj = moment(dateObj);
        if (momentObj < moment().startOf('day') || !momentObj.isValid()) return;
        var momentString = momentObj.format('MMMM Do YYYY, h:mm:ss a'); 


        return(
              <tr key = {index} className={index%2 === 0?'odd':'even'}>
                  <td>{index + 1}</td>
                  <td>{user.firstName}</td>
                  <td>{user.lastName}</td>
                  <td>{momentString}</td>
              </tr>
          )
    }

    const userTable = users.map((user,index) => UserRow(user,index))

    return(
        <div className="container">
            <h2>Reservations</h2>
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Reservation Id</th>
                    <th>Zone</th>
                    <th>Desk Number</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                    {userTable}
                </tbody>
            </table>
        </div>
    )
}