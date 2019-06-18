const c = document.getElementById('myContent')
const b = document.getElementById('btnLoad')

b.addEventListener('click', evt => {
    const xhr = new XMLHttpRequest()
    xhr.open('GET', '/data.html', true)

    // Qué se debe hacer con la data?
    xhr.addEventListener('load', e => {
        console.log(e.target)
        c.innerHTML = e.target.responseText
    })

    // Realice la petición
    xhr.send()
})