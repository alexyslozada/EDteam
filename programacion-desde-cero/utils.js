// Dibuja la información de la lista de tareas
// en el documento html
const print = list => {
    // Obtiene el elemento html donde se dibujará la lista de tareas
    const listHtml = document.getElementById('list')
    // Se limpia el elmento para volver a dibujarlo todo
    listHtml.innerHTML = ``

    // Si no hay tareas, no realiza ninguna acción
    if (list.length === 0) { return }

    // Fragmento que almacenará temporalemente la lista
    // con el fin de mejorar el rendimiento de pintado de data
    let fragment = document.createDocumentFragment()

    // Se recorren las tareas para dibujarlas en el documento html
    for (let i = 0; i < list.length; i++) {
        const task = document.createElement('li')
        task.innerText = `${list[i].title} - ${list[i].dueDate} - ${list[i].done}`
        fragment.appendChild(task)
    }

    listHtml.appendChild(fragment)
}
