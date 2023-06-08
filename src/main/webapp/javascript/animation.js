const btn = document.getElementById('btn');
const nav = document.getElementById('nav');

let open = false;
btn.addEventListener('click',()=>{
    if(open==false){
        nav.style.right='-15vw';
        open=true
    }else{
        nav.style.right='-40vw';
        open=false
    }
   
    
})