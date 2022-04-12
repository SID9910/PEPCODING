                                          //26 feb 2022

let plus=document.querySelector("#plus");
let imageListContainer=document.querySelector(".img-list-container");
let imageShowContainer=document.querySelector(".img-show_container");
let imgsArr=[];
//dhyan dena padega
let cimgIndex=-1;
let uniqueIdentifier=0;

plus.addEventListener("click",function(){
    let imgLink=prompt("ENTER THE IMAGE URL");
    if(imgLink ==null || imgLink==""){
        alert("ENTER THE VALID IMAGE URL");
        return;
    }
    addImageToListandShow(imgLink);
})


//ye function help karega list and container main image dalne main 
function addImageToListandShow(imgLink){

    //img list
    let previewImg=document.createElement("img");
    previewImg.setAttribute("src", imgLink);
    previewImg.setAttribute("cid", uniqueIdentifier);
    uniqueIdentifier++;
    previewImg.setAttribute("class","img_preview");
    //last main add karta hai
    imageListContainer.appendChild(previewImg);


//img list ke ley ye bhi kar sakte the final img ki tarah
// let innerHTMLList=`<img class="img_preview" src=${imgLink} alt="">`

//final image ke ley
let innerHTMLShow=`<span action class="material-icons">keyboard_double_arrow_left</span>
            
           
<img class="final_image" src=${imgLink} alt="">
<span action="right" class="material-icons">keyboard_double_arrow_right</span>
`
imageShowContainer.innerHTML=innerHTMLShow;

let imgIdentifierObj={
    cid:uniqueIdentifier,
    url:imgLink
}
imgsArr.push(imgIdentifierObj);
// console.log(imgsArr);

}
