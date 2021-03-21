
export async function getAllBookings() {

    const response = await fetch('/api/bookings');
    return await response.json();
}