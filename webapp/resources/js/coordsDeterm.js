document.addEventListener("DOMContentLoaded",updateGraph());
document.getElementById("graph").addEventListener("click",function(e){
    pageX = e.pageX;
    pageY = e.pageY;
    let xInput = document.getElementById("canvasForm:canvasX");
    let yInput = document.getElementById("canvasForm:canvasY");
    let graph = document.getElementById("graph");
    let x = -graph.getBoundingClientRect().left + pageX - graph.offsetWidth/2;
    let y = graph.getBoundingClientRect().top - pageY + graph.offsetHeight/2 + window.pageYOffset;
    xInput.value = (10*x/frame).toFixed(4);
    yInput.value = (10*y/frame).toFixed(4);
    document.getElementById("canvasForm:submitGraph").click();
})
function updateGraph(){
    setTimeout(updateGraph, 100);
    let rows = document.querySelectorAll("#history tbody tr");
    let dots = [];
    for (let i = 0; i < rows.length; i++){
        let cells = rows[i].children;
        let dot = new Dot(parseFloat(cells[0].innerHTML),parseFloat(cells[1].innerHTML),parseFloat(cells[2].innerHTML),cells[3].innerHTML == "true");
        dots.push(dot);
    }
    drawDots(dots);
};
function setR(newR){
    document.getElementById("canvasForm:canvasR").value = newR;
}

