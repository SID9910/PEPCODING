(function () {
   let btnaddFolder = document.querySelector("#addFolder");
   let btnaddTextFile = document.querySelector("#addTextFolder");
   let divbreadCrumb = document.querySelector("#breadCrumb");
   let divContainer = document.querySelector("#container");
   let aRootPath=divbreadCrumb.querySelector("a[purpose='path']");
   let templates = document.querySelector("#templates");
   let divApp = document.querySelector("#app");
   let divAppTitleBar = document.querySelector("#app-title-bar");
   let divAppTitle = document.querySelector("#app-title");
   let divAppmenuBar = document.querySelector("#app-menu-bar");
   let divAppBody = document.querySelector("#app-body");
    
 
   let resources = []; //isme array main store karenge content
   let cfid = -1; //initial at current root folder -1
   let rid = 0;//resource id ko initial zero lo
   btnaddFolder.addEventListener("click", addFolder);
   btnaddTextFile.addEventListener("click", addTextFile);
   aRootPath.addEventListener("click", viewFolderFromPath);

  


   function saveNotepad(){

   }
   function makeNotepadBold(){
      let textArea=divAppBody.querySelector("textArea");
      let ispressed=this.getAttribute("pressed") =="true";
      if(ispressed ==false){
         this.setAttribute("pressed" ,true);
         textArea.style.fontWeight ="bold";

      }else{
         this.setAttribute("pressed", false);
         textArea.style.fontWeight="normal";
      }


   }
   function makeNotepadItalic(){
      let textArea=divAppBody.querySelector("textArea");
      let ispressed=this.getAttribute("pressed") =="true";
      if(ispressed ==false){
         this.setAttribute("pressed" ,true);
         textArea.style.fontStyle ="italic";

      }else{
         this.setAttribute("pressed", false);
         textArea.style.fontStyle="normal";
      }



   }
   function makeNotepadUnderline(){
      let textArea=divAppBody.querySelector("textArea");
      let ispressed=this.getAttribute("pressed") =="true";
      if(ispressed ==false){
         this.setAttribute("pressed" ,true);
         textArea.style.textDecoration ="underline";

      }else{
         this.setAttribute("pressed", false);
         textArea.style.textDecoration="normal";
      }


   }
   function chnageNotepadFontSize(){

   }
   function changeNotepadFontFamily(){
      let fontFamily=this.value;
      let textArea=divAppBody.querySelector("textArea");
      textArea.style.fontFamily=fontFamily;

   }
//notepad ke aander ka bg-color kaam sara kaam ye function karega
function changeNotepadBGColor(){
   let color=this.value;
   let textArea=divAppBody.querySelector("textArea");
   textArea.style.backgroundColor=color;

}

function changeNotepadTextColor(){
   let color=this.value;
   let textArea=divAppBody.querySelector("textArea");
   textArea.style.color=color;

}






   //persist-ram,storage
   //validations-unique, non-blank
   function addFolder() {
      let rname = prompt("ENTER FOLDER'S NAME");
     
      //name main space nhi aay isley trim kardo name
     if(rname !=null){
      rname = rname.trim();
     }
      //empty folder validation
      if (!rname) {
         alert("EMPTY NAME IS NOT ALLOWED");
         return;
      }


      //unique rahe name mtlb same name parent main na save ho

      //haam kya karenge aagar rname aaega dubara to to nhi karenge save and parent id main cfid aaagr equal hue to 
      //mtln exist karti hai pehle se to taab bhi save nhi karenge folder
      let alreadyExist = resources.some(r => r.rname == rname && r.pid == cfid);
      if (alreadyExist == true) {
         alert(rname + "NAME IS ALREADY IN USE.ENTER ANOTHER NAME");
         return;
      }

      let pid = cfid;
      rid++;//resource id ko ++ karke bedgho  
      addFolderHTML(rname, rid, pid);
      resources.push({
         rid: rid,
         rname: rname,
         rtype: "folder",
         pid: cfid

      });
      saveToStorage();

   }
   //    tfname=text file name 
   function addTextFile() {
      let rname = prompt("ENTER TEXT FILE  NAME");
     
      //name main space nhi aay isley trim kardo name
     if(rname !=null){
      rname = rname.trim();
     }
      //empty folder validation
      if (!rname) {
         alert("EMPTY NAME IS NOT ALLOWED");
         return;
      }


      //unique rahe name mtlb same name parent main na save ho

      //haam kya karenge aagar rname aaega dubara to to nhi karenge save and parent id main cfid aaagr equal hue to 
      //mtln exist karti hai pehle se to taab bhi save nhi karenge folder
      let alreadyExist = resources.some(r => r.rname == rname && r.pid == cfid);
      if (alreadyExist == true) {
         alert(rname + "NAME IS ALREADY IN USE.ENTER ANOTHER NAME");
         return;
      }

      let pid = cfid;
      rid++;//resource id ko ++ karke bedgho  
      addTextFileHTML(rname, rid, pid);
      resources.push({
         rid: rid,
         rname: rname,
         rtype: "text-file",
         pid: cfid

      });
      saveToStorage();



   }

   function deleteFolder() {
      let spanDelete= this;
      let divfolder = spanDelete.parentNode;
        let divName = divfolder.querySelector("[purpose='name']");
        let fidtbd =divfolder.getAttribute("rid");
        let fname=divName.innerHTML;

  let childrenExists=resources.some(r=>r.pid==fidtbd);
        let sure= confirm(`ARE YOU SURE YOU WANT TO DELETE ${fname}?`+ (childrenExists?".it also has children.":""));
        if (!sure) {
           return;        
        }
            
            

            //html
            divContainer.removeChild(divfolder);

            //ram
            deleteHelper(fidtbd);

            //storage
            saveToStorage();
            }
                
 //ye deleteHelper he main kaam karega folder ko delete karne main recussion laag rahi hai 
 //pehel ander ke folder delete hoenge fhir bahar ke 
      function deleteHelper(fidtbd){

let children=resources.filter(r=>r.pid == fidtbd);
for(let i=0;i<children.length;i++){
   deleteFolder(children[i].rid);//this is capable of delete
}
let ridx=resources.findIndex(r=>r.rid ==fidtbd);
resources.splice(ridx,1);//splice ka kaam badsically ye hai ki vo  eek rid ko hta dega  child  ki 
      }
   


   function deleteTextFile() {
      let spanDelete= this;
      let divTextFile = spanDelete.parentNode;
        let divName = divTextFile.querySelector("[purpose='name']");
        let fidtbd =divTextFile.getAttribute("rid");
        let fname=divName.innerHTML;

 
        let sure= confirm(`ARE YOU SURE YOU WANT TO DELETE ${fname}?`);
        if (!sure) {
           return;        
        }
            
            

            //html
            divContainer.removeChild(divTextFile);

            //ram
            let ridx= resources.findIndex(r => r.rid == fidtbd);
            resources.splice(ridx,1);

            //storage
            saveToStorage();

   }
   function renameFolder() {
      let nrname = prompt("ENTER  NEW FOLDER'S NAME");//nrname(new resource name)
     
      //name main space nhi aay isley trim kardo name
     if(nrname != null){
      nrname = nrname.trim();
     }
      //empty folder validation
      if (!nrname) {
         alert("EMPTY NAME IS NOT ALLOWED");
         return;
      }

      let spanRename = this;  //is se span main jakar folder ke ander ko this bolte hai
      let divFolder=spanRename.parentNode; //div ke ander jakar folder ko parent bolenge span rename ka
      let divName = divFolder.querySelector("[purpose=name]");//div folder se uska name nikal lenge
      let orname= divName.innerHTML; //orname(old resource name ) div folder ke ander se jakar purana name nikalega ye
       
      //ribTBU(resource name to be edited) ye haam rid nikalenge taaki us id ka
      //use karke ham uska rename kar sake
       let ribTBU =parseInt(divFolder.getAttribute("rid"));
       if(nrname == orname ){
          alert("THIS NAME ALREADY EXIST .TRY ANOTHER NAME");
          return;
       }
      
       //aab haam check karenge ye jo edit karenge uska name bhi pehle se to exist nhi karta
       //to usper alreadyExist vali condition jagenge jo pehle use kari thi
       let alreadyExist = resources.some(r => r.rname == nrname && r.pid == cfid);
       if (alreadyExist == true) {
          alert(nrname + "NAME IS ALREADY IN USE.ENTER ANOTHER NAME");
          return;
       }

       //change karenge html main
       divName.innerHTML=nrname;

       //change ram
       //find se haam jis resource per pehle vo folder ka name tha .us he id per haam rname karenge
       //taaki dubara id nhi bane resource ki us name per
      let resource= resources.find(r => r.rid == ribTBU);
      resource.rname=nrname;

       //change storage
       saveToStorage();
       


   }
   function renameTextFile() {
      let nrname = prompt("ENTER  NEW FILE'S NAME");//nrname(new resource name)
     
      //name main space nhi aay isley trim kardo name
     if(nrname != null){
      nrname = nrname.trim();
     }
      //empty folder validation
      if (!nrname) {
         alert("EMPTY NAME IS NOT ALLOWED");
         return;
      }

      let spanRename = this;  
            let divTextFile=spanRename.parentNode; //div ke ander jakar folder ko parent bolenge span rename ka
      let divName = divTextFile.querySelector("[purpose=name]");
            let orname= divName.innerHTML; //orname(old resource name ) div folder ke ander se jakar purana name nikalega ye
       
      
       let ribTBU =parseInt(divTextFile.getAttribute("rid"));
       if(nrname == orname ){
          alert("THIS NAME ALREADY EXIST .TRY ANOTHER NAME");
          return;
       }
      
       //aab haam check karenge ye jo edit karenge uska name bhi pehle se to exist nhi karta
       //to usper alreadyExist vali condition jagenge jo pehle use kari thi
       let alreadyExist = resources.some(r => r.rname == nrname && r.pid == cfid);
       if (alreadyExist == true) {
          alert(nrname + "NAME IS ALREADY IN USE.ENTER ANOTHER NAME");
          return;
       }

       //change karenge html main
       divName.innerHTML=nrname;

       //change ram
       //find se haam jis resource per pehle vo folder ka name tha .us he id per haam rname karenge
       //taaki dubara id nhi bane resource ki us name per
      let resource= resources.find(r => r.rid == ribTBU);
      resource.rname=nrname;

       //change storage
       saveToStorage();
       

   }

   //view ke ander ka kaam
   function viewFolder() {
      let spanView=this;
      let divFolder=spanView.parentNode; //folder ke ander aajenge is se span view ke
      let divName=divFolder.querySelector("[purpose='name']"); //name aajaega folder ka

      let fname=divName.innerHTML;//folder name aajaega is se
      let fid=parseInt(divFolder.getAttribute("rid"));//is se resource ki id aajegi us  folder id main

      let apathTemplate=templates.content.querySelector("a[purpose='path']"); //path le lenge is se
      let apth=document.importNode(apathTemplate, true); //clone of apathtemplete
 
      apth.innerHTML=fname; //path main us folder ka name daal denge
      apth.setAttribute("rid",fid);//id daal denge vo vali jis me honge
      apth.addEventListener("click", viewFolderFromPath); //ye call karenge taaki us directory per aajay jo chaheye
      divbreadCrumb.appendChild(apth); //breadcrumb main daal denge

      cfid=fid; //aab current folder main jis folder main hai vo daal denge
      divContainer.innerHTML="";//container khali kar denge jaise he kisi ke ander view ke amder enter karenge to
 
      //is se cureent folder ke ander honge taabhi changes honge
      for (let i = 0; i < resources.length; i++){
  if (resources[i].pid == cfid) {
               addFolderHTML(resources[i].rname, resources[i].rid, resources[i].pid);

            }
         }
   }

//ye function breadcrumb main jisper jana hoga usper jane main help karega by path 
//jaise root per click karenge to bss vo he dikega or kuch nhi path ki help se
   function viewFolderFromPath(){
      let aPath= this;
      let fid=parseInt(aPath.getAttribute("rid")); //is se uss folder ki id aaegi jo chaheye

      //set the breadcrumb
      while(aPath.nextSibling){
         aPath.parentNode.removeChild(aPath.nextSibling); //is se jonsa directory chaheye uske aajava baaki ke aage ke bhta dega 
      }

      //set the container
      cfid=fid; //current folder kardo
      divContainer.innerHTML ="";//khali kardo container
        //is se cureent folder ke ander honge taabhi changes honge
        
         for (let i = 0; i < resources.length; i++) {
         
            if (resources[i].pid == cfid) {
               if(resources[i].rtype =="folder"){
               addFolderHTML(resources[i].rname, resources[i].rid, resources[i].pid);
               }  else if(resources[i].rtype =="text-file"){
                  addTextFileHTML(resources[i].rname, resources[i].rid, resources[i].pid);
                  }
            }
      
             
            }
                


   }
   //rid(resource id),rname(resource name),pid(parent id)
   function addFolderHTML(rname, rid, pid) {
      let divFolderTemplate = templates.content.querySelector(".folder");
      let divFolder = document.importNode(divFolderTemplate, true);

      let spanRename = divFolder.querySelector("[action=rename]");
      let spanDelete = divFolder.querySelector("[action=delete]");
      let spanView = divFolder.querySelector("[action=view]");
      let divName = divFolder.querySelector("[purpose=name]");

      spanRename.addEventListener("click", renameFolder);
      spanDelete.addEventListener("click", deleteFolder);
      spanView.addEventListener("click", viewFolder);

      divName.innerHTML = rname;//aab resource name fname ki tarah work karega
      divFolder.setAttribute("rid", rid);//aab attribute set karenge resource id bhi show ho
      divFolder.setAttribute("pid", pid); //aab attribute dalenge taaki parent id bhi show ho
      divContainer.appendChild(divFolder);



   }

   function addTextFileHTML(rname, rid, pid) {
      let divTextFileTemplate = templates.content.querySelector(".text-file");
      let divTextFile = document.importNode(divTextFileTemplate, true);

      let spanRename = divTextFile.querySelector("[action=rename]");
      let spanDelete = divTextFile.querySelector("[action=delete]");
      let spanView = divTextFile.querySelector("[action=view]");
      let divName = divTextFile.querySelector("[purpose=name]");

      spanRename.addEventListener("click",renameTextFile);
      spanDelete.addEventListener("click", deleteTextFile);
      spanView.addEventListener("click", viewTextFile);

      divName.innerHTML = rname;//aab resource name fname ki tarah work karega
      divTextFile.setAttribute("rid", rid);//aab attribute set karenge resource id bhi show ho
      divTextFile.setAttribute("pid", pid); //aab attribute dalenge taaki parent id bhi show ho
      divContainer.appendChild(divTextFile);



   }
   function viewTextFile() {
      let spanView=this;
      let divTextFile=spanView.parentNode;
      let divName=divTextFile.querySelector("[purpose=name]");
      let fname=divName.innerHTML;
      let fid=parseInt(divTextFile.getAttribute("rid"));
      
      let divNotepadMenuTemplate=templates.content.querySelector("[purpose=notepad-menu]");
      let divNotepadmenu=document.importNode(divNotepadMenuTemplate,true);
      divAppmenuBar.innerHTML="";
      divAppmenuBar.appendChild(divNotepadmenu);

      let divNotepadBodyTemplate=templates.content.querySelector("[purpose=notepad-body]");
      let divNotepadbody=document.importNode(divNotepadBodyTemplate,true);
      divAppBody.innerHTML="";
      divAppBody.appendChild(divNotepadbody);
  divAppTitle.innerHTML=fname;

  //ye sara kaam notepad ke ley ho rha hai
  let spanSave=divAppmenuBar.querySelector("[action=save]");
  let spanBold=divAppmenuBar.querySelector("[action=bold]");
  let spanItalic=divAppmenuBar.querySelector("[action=italic]");
  let spanUnderline=divAppmenuBar.querySelector("[action=underline]");
  let inputBGColor=divAppmenuBar.querySelector("[action=bg-color]");
  let inputTextColor=divAppmenuBar.querySelector("[action=fg-color]");
  let selectFontFamily=divAppmenuBar.querySelector("[action=font-family]");
  let selectFontSize=divAppmenuBar.querySelector("[action=font-size]");

  
  spanSave.addEventListener("click",saveNotepad);
  spanBold.addEventListener("click",makeNotepadBold);
  spanItalic.addEventListener("click",makeNotepadItalic);
  spanUnderline.addEventListener("click",makeNotepadUnderline);
  inputBGColor.addEventListener("change",changeNotepadBGColor);
  inputTextColor.addEventListener("change",changeNotepadTextColor);
  selectFontFamily.addEventListener("change",changeNotepadFontFamily);
  selectFontSize.addEventListener("change",chnageNotepadFontSize);
   }
   //rjson(resource json)
   function saveToStorage() {
      let rjson = JSON.stringify(resources); //local storage main data main show hoga string ki form main
      localStorage.setItem("data", rjson);
   }
   //data persist rahe load karne ke baad uska fn
   function loadfromStorage() {
      let rjson = localStorage.getItem("data");//get karenge
      if (!rjson) {
         return;
      }
         resources = JSON.parse(rjson); //resources se data lekar load karenge
         for (let i = 0; i < resources.length; i++) {
            //ye condition hai bss root vale parent folder and text-file ko bss dikaho load karne ke baad 
            //jinka parent id current folder and text-file ke barabar hai.means show only root folder and text-fileafter reloading
            if (resources[i].pid == cfid) {
               if(resources[i].rtype == "folder"){
               addFolderHTML(resources[i].rname, resources[i].rid, resources[i].pid);
               }  else if(resources[i].rtype == "text-file"){
                  addTextFileHTML(resources[i].rname, resources[i].rid, resources[i].pid);
                  }
            }
      //ye second conditon hai jaise he load karenge to rid hogi vo aage se start ho naki vapis zero se start ho assign karna
      if (resources[i].rid > rid) {
         rid = resources[i].rid;
      }
             
            }
            
         }
      


   
   loadfromStorage();


})();