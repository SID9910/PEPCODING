(function(){

let saveAlbum=document.querySelector("#saveAlbum");
let addAlbum=document.querySelector("#addAlbum");
let deleteAlbum=document.querySelector("#deleteAlbum");
let importAlbum=document.querySelector("#importAlbum");
let exportAlbum=document.querySelector("#exportAlbum");
let playAlbum=document.querySelector("#playAlbum");
let selectAlbum=document.querySelector("#selectAlbum");
let allTemplates=document.querySelector("#allTemplates");
let overlay=document.querySelector("#overlay");
contentDetailsOverlay=document.querySelector("#content-details-overlay");
//albums array main store karenge
let albums=[{
    name:"test",
    slides:[]
}];

addAlbum.addEventListener("click",handleAddAlbum);
selectAlbum.addEventListener("change",handleSelectAlbum);
function handleAddAlbum(){
    let albumName=prompt("ENTER THE NAME FOR NEW ALBUM ");
    if(albumName==null){
        return;
    }

    //trim isley karenge taaki name ke baad spaces ke sath save na ho sake

    albumName=albumName.trim();
    //aaagr empty name se save kara to not allowed aaega
    if(!albumName){
        alert("EMPTY NAMES ARE NOT ALLOWED");
        return;
    }

    //aab hum check karenge aagar albumname pehle se exist karti hai ya nhi.aagr nhi karti hogi to loop main milegi nhi
    //and false return hoga
    let exists=albums.some(a=>a.name==albumName);
    if(exists){
        alert(albumName+ " ALREADY EXIST!! PLZ ENTER THE NEW NAME");
        
        return;
    }

    //ye album bna dea hai taaki content isme aay and albums(array) main store kar de 
    let album={
        name: albumName,
        slides: []
    };

    albums.push(album);
 let optionTemplate = allTemplates.content.querySelector("[purpose=new-album]");
 let newAlbumOption =document.importNode(optionTemplate, true);

 newAlbumOption.setAttribute("value", albumName);
 newAlbumOption.innerHTML=albumName;
 selectAlbum.appendChild(newAlbumOption);
 
 //is se direct select main name daal jaega album ka 
 selectAlbum.value=albumName;

 //is se select album ka event ke ander ka function aapne aap fire ho jaega 
 //dispatch event ki help se
 selectAlbum.dispatchEvent(new Event("change"));


}


//select ke button ka function
//overlay ko htane ka tarika
function handleSelectAlbum(){

//-1 aaagr string hogi ander  to mtlb block he rakho overlay ko
//else nhi to none kardo mtlb hta do overlay ko
    if(this.value =="-1"){
        overlay.style.display="block";
       
        contentDetailsOverlay.style.display="none";
    }
    else{
        overlay.style.display="none";
        contentDetailsOverlay.style.display="block";
    }

}



})();