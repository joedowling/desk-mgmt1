
export async function getAllZones() {

    const response = await fetch('http://localhost:5000/api/zones');
    return await response.json();
}