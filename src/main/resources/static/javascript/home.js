//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
console.log(userId)

const table = document.getElementById('table');
const row1 = document.getElementById('row-1');
const row2 = document.getElementById('row-2');
const row3 = document.getElementById('row-3');
const row4 = document.getElementById('row-4');
const row5 = document.getElementById('row-5');
const row6 = document.getElementById('row-6');
const row7 = document.getElementById('row-7');
const row8 = document.getElementById('row-8');
const row9 = document.getElementById('row-9');

const headers = {
    "Content-Type": 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/puzzles/puzzle/"

const currentPuzzle = [];
const currentPuzzleSolution = [];

const handleLogout = () => {
    let c = document.cookie.split(";");
    for(let i in c) {
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

async function getPuzzleById(puzzleId) {
    await fetch(baseUrl + puzzleId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => createTable(data))
        .catch(err => console.log(err))
    
}

const createTable = (obj) => {
    let start = obj.value
    let end = obj.solution
    currentPuzzle = start
    currentPuzzleSolution = end
    console.log('start:' + start)
    console.log('end:' + end)
    table.innerHTML = '';
    start.forEach((num) => {
            if(num === 0) {
                let card = document.createElement("input")
                card.classList.add("table-cell")
                card.setAttribute('value','')
                card.setAttribute('maxlength',1)
                table.append(card)
            }
            else {
                let card = document.createElement("div")
                card.classList.add("table-cell")
                card.innerHTML = `
                    ${num}
                `
                table.append(card)
        }
    })    
}

getPuzzleById(1)
