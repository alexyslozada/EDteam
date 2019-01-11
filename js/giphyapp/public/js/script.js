btnSend.addEventListener('click', async () => {
    const q = encodeURI(searchGif.value)
    const headers = new Headers()
    headers.append('Content-Type', 'application/json')
    const myInit = {method: 'GET', headers: headers,  mode: 'cors', cache: 'default'}
    const res = await fetch(`https://api.giphy.com/v1/gifs/search?api_key=mto0q23ZXsGlZDFANOaT1yeVDeR2mmwX&q=${q}&limit=1`, myInit)
    const data = await res.json()
    drawGif(data.data[0].images.fixed_height.url)
})

const drawGif = gif => {
    const html = `<img src="${gif}" alt="un gif bonito">`
    contenido.insertAdjacentHTML('beforeend', html)
}