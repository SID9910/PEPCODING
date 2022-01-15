(function () {
   let btnaddFolder = document.querySelector("#addFolder");
   let btnaddTextFile = document.querySelector("#addTextFolder");
   let divbreadCrumb = document.querySelector("#breadCrumb");
   let divContainer = document.querySelector("#container");
   let templates = document.querySelector("#templates");
   let resources = []; //isme array main store karenge content
   let cfid = -1; //initial at current root folder -1
   let rid = 0;//resource id ko initial zero lo
   btnaddFolder.addEventListener("click", addFolder);
   btnaddTextFile.addEventListener("click", addTextFile);

   //persist-ram,storage
   //validations-unique, non-blank
   function addFolder() {
      let rname = prompt("ENTER FOLDER'S NAME");

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
      let tfname = prompt("ENTER TEXT FILE NAME ");



   }

   function deleteFolder() {

   }
   function deleteTextFile() {

   }
   function renameFolder() {

   }
   function renameTextfile() {

   }
   function viewFolder() {

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
   function viewTextFile() {

   }
   //rjson(resource json)
   function saveToStorage() {
      let rjson = JSON.stringify(resources); //local storage main data main show hoga string ki form main
      localStorage.setItem("data", rjson);
   }
   //data persist rahe load karne ke baad uska fn
   function loadfromStorage() {
      let rjson = localStorage.getItem("data");//get karenge
      if (!!rjson) {
         resources = JSON.parse(rjson); //resources se data lekar load karenge
         for (let i = 0; i < resources.length; i++) {
            //ye condition hai bss root vale parent folder ko bss dikaho load karne ke baad 
            //jinka parent id current folder ke barabar hai.means show only root folder after reloading
            if (resources[i].pid == cfid) {
               addFolderHTML(resources[i].rname, resources[i].rid, resources[i].pid);

            }
            //ye second conditon hai jaise he load karenge to rid hogi vo aage se start ho naki vapis zero se start ho assign karna
            if (resources[i].rid > rid) {
               rid = resources[i].rid;
            }
         }
      }


   }
   loadfromStorage();


})();