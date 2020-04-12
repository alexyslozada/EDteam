// Crea un nuevo objeto tipo tarea
const newTask = (title, dueDate) => {
    return {
        title,
        dueDate,
        done: false
    }
}

// Obtiene el ID de la tarea que se va a procesar
// si el usuario digitó un dato no válido, se devuelve cero
const getIDTask = () => {
    const id = prompt('Digite el ID de la tarea')
    const idNumber = parseInt(id, 10)
    if (isNaN(idNumber)) {
        console.warn("Se esperaba un número entero, se obtuvo", id)
        idNumber = 0
    }

    return idNumber
}

// Obtiene el valor de `hecho` de una tarea
// si el usuario digita 1 es verdadero, de lo contrario es falso
const getIsDone = () => {
    const isDone = prompt("Digite 1 para hecho, cualquier otra tecla para no hecho")
    if (isDone === "1") {
        return true
    }

    return false
}

// Almacén de la lista de tareas
const list = []

// Captura la información digitada por el usuario 
// y la convierte en una tarea
const createTask = () => {
    const title = prompt('Digite el título')
    const dueDate = prompt('Digite la fecha en formato AAAA-MM-DD (o vacio)')
    return newTask(title, dueDate)
}

// Agrega la tarea a la lista
const processAddTask = () => {
    const task = createTask()
    list.push(task)
    print(list)
}

// Edita la tarea en la lista
const processEditTask = () => {
    const id = getIDTask()
    if (id === 0) {
        alert("No es un número vaído, proceso cancelado")
        return
    }

    const task = createTask()
    list[id-1] = task
    print(list)
}

// Marca como hecha (false, true) una tarea
const processDoneTask = () => {
    const id = getIDTask()
    if (id === 0) {
        alert("No es un número vaído, proceso cancelado")
        return
    }

    const isDone = getIsDone()
    list[id-1].done = isDone
    print(list)
}

// Borra una tarea de la lista
const processDeleteTask = () => {
    const id = getIDTask()
    if (id === 0) {
        alert("No es un número vaído, proceso cancelado")
        return
    }

    list.splice(id-1, 1)
    print(list)
}

// Botones
const btnAdd = document.getElementById('btnAdd')
const btnEdit = document.getElementById('btnEdit')
const btnDone = document.getElementById('btnDone')
const btnDelete = document.getElementById('btnDelete')

// Agregamos los eventos a los botones
btnAdd.addEventListener('click', processAddTask)
btnEdit.addEventListener('click', processEditTask)
btnDone.addEventListener('click', processDoneTask)
btnDelete.addEventListener('click', processDeleteTask)