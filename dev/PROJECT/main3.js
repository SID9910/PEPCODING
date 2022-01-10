(function () {


    let btn = document.querySelector("#buttonaddfolder");
    let divcontainer = document.querySelector("#container");
    let mytemplates = document.querySelector("#mytemplates");
    let fid = -1;
    let folders = [];

    btn.addEventListener("click", addFolder);

    function addFolder() {
        let fname = prompt("ENTERS FOLDER's NAME ");

        if (!!fname) {

            let exist = folders.some(f => f.name == fname);

            if (exist == false) {
                fid++;
                //RAM
                folders.push({
                    id: fid,
                    name: fname
                });

                //HTML
                addFolderHTML(fname, fid);

                //storage
                saveToStorage();

            }

            else {
                alert(fname + " ALREADY EXIST");
            }



        }
        else {
            alert("ENTER VALID NAME ");
        }


    }
    function editFolder() {
        let divfolder = this.parentNode;
        let divName = divfolder.querySelector("[purpose='name']");
        let ofname = divName.innerHTML; //old fname

        let nfname = prompt("ENTER NEW FOLDER'S NAME" + ofname); //new fname

        if (!!nfname) {
    
            if(nfname != ofname){ //aaagr file pehle se exist karti hogi taab nhi chalega ye

            let exist = folders.some(f => f.name == nfname); //aagr new fname exist karega edit vala to already exist kar denge

            if (exist == false) {

                //RAM
                let folder = folders.some(f => f.name == nfname); //aaagr edit vala folder exist nhi karta hoga exist to change kar denge f.name main
                folder.name=nfname; //edit newfname daal denge
                //HTML
                divName.innerHTML= nfname;


                //storage
                saveToStorage();

            }

            else {
                alert(nfname + " ALREADY EXIST");
            }

        }
        else {
            alert(" THIS IS OLD NAME .PLEASE ENTER NEW NAME !! ");
        }
    }else{
        alert("PLEASE ENTER A NAME ");
    }


    }
    function deleteFolder() {
        let divfolder = this.parentNode;
        let divName = divfolder.querySelector("[purpose='name']");


        let flag = confirm("DO YOU WANT TO DELETE " + divName.innerHTML + "?");
        if (flag == true) {
            //ram
            let fidx = folders.findIndex(f => f.name == divName.innerHTML);
            folders.splice(fidx, 1);

            //html
            divcontainer.removeChild(divfolder);

            //storage
            saveToStorage();

        }



    }

    function addFolderHTML(fname, fid) {
        let divfoldertemplate = mytemplates.content.querySelector(".folder");
        let divFolder = document.importNode(divfoldertemplate, true);

        let divName = divFolder.querySelector("[purpose='name']");
        let spanEdit = divFolder.querySelector("span[action='edit']");
        let spanDelete = divFolder.querySelector("span[action='delete']");

        divFolder.setAttribute("fid", fid);
        divName.innerHTML = fname;
        spanEdit.addEventListener("click", editFolder);
        spanDelete.addEventListener("click", deleteFolder);

        divcontainer.appendChild(divFolder);

    }

    //ye persistTostorage vala function hai
    function saveToStorage() {
        let fjson = JSON.stringify(folders);
        localStorage.setItem("data", fjson);

    }
    function loadFromStorage() {
        let fjson = localStorage.getItem("data");
        if (!!fjson) {
            folders = JSON.parse(fjson);
            folders.forEach(f => {

                if (f.id > fid) {
                    fid = f.id;
                }


                addFolderHTML(f.name, f.id);

            });
        }

    }

    loadFromStorage();
})();