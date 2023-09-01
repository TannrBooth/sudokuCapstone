//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
console.log(userId)

const tableContainer = document.getElementById('table-container')
const tableBody = document.getElementById('history-table-body')
const histBtn = document.getElementById('history-btn')


const headers = {
    "Content-Type": "application/json"
}

const baseUrl = "http://localhost:8080/api/v1/history/"

async function getHistoryByUserId(user) {
    console.log(user)
    await fetch(`${baseUrl}user/${user}`, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => createHist(data))
        .catch(err => console.log(err))
}

const createHist = (obj) => {
    console.log(obj)
    obj.forEach(element => {
        let table = document.createElement("tr")
        table.classList.add('history-table-row')
        table.innerHTML = `
            <td>${element.puzzle.id}</td>
            <td>${element.win}</td>
            <td>${element.checkAnswers}</td>
        `
        tableBody.append(table)
    });

}

getHistoryByUserId(userId)
