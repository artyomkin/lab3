var size = 500;
var shift = 30;
var frame = size - 2 * shift
var canvas = document.getElementById("graph");
var context = canvas.getContext("2d");
let r = document.getElementById("canvasForm:canvasR").value;
document.addEventListener("DOMContentLoaded",drawGraph(r))
function drawGraph(radius){

    context.globalCompositeOperation = 'destination-over';
    drawYAxis(radius);
    drawXAxis(radius);
    drawRect(radius);
    drawTriangle(radius);
    drawArc(radius);
    context.globalCompositeOperation = 'source-over';
}

function drawYAxis(radius){

    context.beginPath();

    context.moveTo(size/2, size);
    context.lineTo(size/2, 0);

    context.lineTo(size/2-5,10);

    context.moveTo(size/2,0);
    context.lineTo(size/2+5,10);

    context.moveTo(size/2-5,(size - frame*radius/5)/2);
    context.lineTo(size/2+5,(size - frame*radius/5)/2);

    context.fillText("R",size/2+10, (size - frame*radius/5)/2);

    context.moveTo(size/2-5,size-(size - frame*radius/5)/2);
    context.lineTo(size/2+5,size-(size - frame*radius/5)/2);
    context.fillText("-R",size/2+10,size-(size - frame*radius/5)/2);

    context.moveTo(size/2-5,(size - frame/2 * radius/5)/2);
    context.lineTo(size/2+5,(size - frame/2 * radius/5)/2);
    context.fillText("R/2",size/2+10,(size - frame/2 * radius/5)/2);

    context.moveTo(size/2-5,size - (size - frame/2 * radius/5)/2);
    context.lineTo(size/2+5,size - (size - frame/2 * radius/5)/2);
    context.fillText("-R/2",size/2+10,size - (size - frame/2 * radius/5)/2);
    context.stroke();

}

function drawXAxis(radius){

    context.beginPath();
    context.moveTo(0, size/2);
    context.lineTo(size, size/2);

    context.lineTo(size-10,size/2-5);

    context.moveTo(size,size/2);
    context.lineTo(size-10,size/2+5);

    context.moveTo(size-(size - frame*radius/5)/2,size/2-5);
    context.lineTo(size-(size - frame*radius/5)/2,size/2+5);

    context.fillText("R",size-(size - frame*radius/5)/2,size/2+10);

    context.moveTo((size - frame*radius/5)/2,size/2-5);
    context.lineTo((size - frame*radius/5)/2,size/2+5);
    context.fillText("-R",(size - frame*radius/5)/2,size/2+10);

    context.moveTo((size - frame/2 * radius/5)/2, size/2 - 5);
    context.lineTo((size - frame/2 * radius/5)/2, size/2 + 5);
    context.fillText("-R/2",(size - frame/2 * radius/5)/2, size/2+10);

    context.moveTo(size - (size - frame/2 * radius/5)/2,size/2-5);
    context.lineTo(size - (size - frame/2 * radius/5)/2,size/2+5);
    context.fillText("R/2",size - (size - frame/2 * radius/5)/2,size/2+10);
    context.stroke();


}

function drawRect(radius){

    context.beginPath();

    context.fillStyle = "#389583";
    context.fillRect((size - frame/2 * radius/5)/2, size/2, frame*radius/5/4, frame*radius/5/2);

    context.stroke();

}

function drawTriangle(radius){
    context.beginPath();

    context.strokeStyle = "#389583";
    context.moveTo(size/2, size - (size - frame * radius/5)/2);
    context.lineTo(size - (size - frame * radius/5)/2, size/2);
    context.lineTo(size/2,size/2);
    context.closePath();
    context.fill();

    context.stroke();
}

function drawArc(radius){
    context.beginPath();
    context.arc(size/2, size/2, frame*radius/5/4, -Math.PI/2, Math.PI, true);
    context.lineTo(size/2,size/2);
    context.strokeStyle = '#389583';
    context.fillStyle = '#389583';
    context.fill();
    context.fillStyle = "#000";
    context.strokeStyle = '#000';
    context.stroke();
}

function clear(){
    context.clearRect(0,0,canvas.width, canvas.height);
}

function drawDots(dots){
    let r = document.getElementById("canvasForm:canvasR").value;
    dots.forEach(dot=>{
        if (dot.r == r){
            drawDot(dot.x,dot.y,dot.hit)
        }
    })
}

function drawDot(x, y, hit){
    let xPix = size/2+x*frame/10;
    let yPix = size/2-y*frame/10;
    let color = "red";
    if(hit){
        color = "green";
    }
    context.beginPath();
    context.globalCompositeOperation = 'source-over';
    context.fillStyle = color;
    context.strokeStyle = color;
    context.arc(xPix,yPix,5,0,2*Math.PI,true);
    context.fill();
    context.stroke();
    context.fillStyle = "black";
    context.strokeStyle = "black";
}

function clear(){
    context.clearRect(0,0,canvas.width, canvas.height);
}