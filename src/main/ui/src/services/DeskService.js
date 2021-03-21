
export async function getAllDesks() {

    const response = await fetch('/api/desks');
    return await response.json();
}

export async function getDesksBookings() {

    const response = await fetch('/api/desksbookings');
    return await response.json();
}