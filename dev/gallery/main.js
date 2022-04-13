                                          //26 feb 2022 and 5 march

let plus=document.querySelector("#plus");
let imageListContainer=document.querySelector(".img-list-container");
let imageShowContainer=document.querySelector(".img-show_container");
let imgsArr=[];
//dhyan dena padega
let cimgIndex=-1;
let uniqueIdentifier=0;


plus.addEventListener("click", function () {
    let imgLink = prompt("please enter img url");
    // img url nahi put kiya hai 
    if (imgLink == null || imgLink == "") {
        alert("Please enter img src");
        return;
    }

    //    add image to List & add Image to show container
    addImageToListandShow(imgLink,uniqueIdentifier);
})



//ye function help karega list and container main image dalne main 
function addImageToListandShow(imgLink){

    //img list
    let previewImg=document.createElement("img");
    previewImg.setAttribute("src", imgLink);
    previewImg.setAttribute("cid", uniqueIdentifier);

    previewImg.setAttribute("class","img_preview");
    //last main add karta hai
    imageListContainer.appendChild(previewImg);
    

//img list ke ley ye bhi kar sakte the final img ki tarah
// let innerHTMLList=`<img class="img_preview" src=${imgLink} alt="">`

//final image ke ley
setShowImages(imgLink);

//to enable image change on click
handleImageFunctionality(uniqueIdentifier,imgLink,previewImg);
uniqueIdentifier++;
}

function handleImageFunctionality(uniqueIdentifier ,imgLink ,previewImg ){
    let imgIdentifierObj = {
        cid: uniqueIdentifier,
        url: imgLink
    }
    imgsArr.push(imgIdentifierObj);
    previewImg.addEventListener("click", function () {
      //    O(1)
      let cImgSrc = previewImg.getAttribute("src");
      setShowImages(cImgSrc);


      setShowImages(imgIdentifierObj.url)
    })
}

function setShowImages(imgLink, uniqueIdentifier) {
    let innerHtmlBlock = `<img class='final_image' src=${imgLink} alt=""
    cid=""</img>`
    // img show -> replace 
imageShowContainer.innerHTML = innerHtmlBlock;
}
    



