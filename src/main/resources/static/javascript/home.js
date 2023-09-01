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
const checkBtn = document.getElementById('check-button');
const resetBtn = document.getElementById('reset-button');

const headers = {
    "Content-Type": "application/json"
}

const baseUrl = "http://localhost:8080/api/v1/puzzles/puzzle/"

let currentPuzzleId;
let currentPuzzle = [];
let currentPuzzleSolution = [];
let correct;


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

async function addHistory() {
    const response = await fetch(`http://localhost:8080/api/v1/history/user/${userId}/puzzle/${currentPuzzleId}/correct/${correct}`, {
        method: "POST",
        headers: headers
    })
    .catch(err => console.error(err.message))

}

const createTable = (obj) => {
    currentPuzzleId = obj.id
    let idNum = 1
    let start = obj.value
    let end = obj.solution
    currentPuzzle = start
    currentPuzzleSolution = end
    console.log('start: ' + start)
    console.log('end: ' + end)
    table.innerHTML = '';
    start.forEach((num) => {
            if(num === 0) {
                let card = document.createElement("input")
                card.classList.add('table-cell')
                card.setAttribute('value','')
                card.setAttribute('maxlength',1)
                card.setAttribute('type','text')
                card.setAttribute('inputmode','numeric')
                card.setAttribute('id',`card-${idNum}`)
                idNum ++
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

const resetPuzzle = () => {
    getPuzzleById(currentPuzzleId)
}

const checkPuzzle = () => {
    let checkArray = []
    let checkArrayNum = []
    let fields = document.querySelectorAll('.table-cell')
    let fieldsArray = [...fields]
    console.log(currentPuzzleSolution)
    fieldsArray.forEach(cell => {
        if (cell.nodeName === 'INPUT') {
            if(cell.value === '') {
                checkArray.push('0')
            } else {
                checkArray.push(cell.value)
            }
        }
        else if (cell.nodeName === "DIV") {
            checkArray.push(cell.innerText)
        }
    })
    for (let i = 0; i < fieldsArray.length; i++) {
        checkArrayNum.push(parseInt(checkArray[i]))
    }
    console.log(checkArrayNum)

    let wrongArr = []
    let sumWrong = 0

    const arraysEqual = (arr1, arr2) => {
        for (let i = 0; i < arr1.length; i++) {
            if (arr1[i] === arr2[i]) {
                wrongArr.push(0)
            } else if (arr1[i] !== arr2[i]) {
                wrongArr.push(1)
            }
        }

        console.log(wrongArr)
        for (let i=0; i < wrongArr.length; i++) {
            sumWrong += wrongArr[i]
        }

        console.log(sumWrong)

        if (sumWrong>0) {
            correct = false
        } else {
            correct = true
        }
    }

    arraysEqual(checkArrayNum,currentPuzzleSolution)

    if(correct) {
        alert("Great Job, you've completed this puzzle!")
    }
    else {
        alert(`Keep trying! ${sumWrong} squares are still incorrect.`)
    }

    addHistory()
}

getPuzzleById(1)
checkBtn.addEventListener('click', checkPuzzle)
resetBtn.addEventListener('click', resetPuzzle)
