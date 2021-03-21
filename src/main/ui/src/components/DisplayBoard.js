import React from 'react'

export const DisplayBoard = ({numberOfUsers, getAllUsers}) => {

    return(
        <div className="display-board">
            <h4>Reservations Created</h4>
            <div className="number">
            {numberOfUsers}
            </div>
            <div className="btn">
                <button type="button" onClick={(e) => getAllUsers()} className="btn btn-warning">Get All Reservations</button>
            </div>
        </div>
    )
}