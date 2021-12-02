document.addEventListener("DOMContentLoaded",function(){
    Array.from(document.getElementsByClassName("coordinate")).forEach(input=>{
            input.addEventListener("input", function(e){
                if (input.value != null && input.value.length > 7) {
                    input.value = input.value.substr(0, 7);
                }
            })
        }
    )
});



