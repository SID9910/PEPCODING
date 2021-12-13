//sabse pehle npm install cheerio karo 

const request = require('request');
const cheerio = require('cheerio');

console.log('before')//likh do likhna haai to asyncronous behaviour dekhna hai to


request('https://www.worldometers.info/coronavirus/', cb)

//ye request ka bna banaya function hai site per 
function cb (error, response, html) {
 
if(error){
    console.error(error)
}else{
    handleHtml(html)
}

}

function handleHtml(html){
    //setTool site ka saara html data laega ka 
    let setTool=cheerio.load(html)
    //contentArr main setTool main jo imp data site ka chaheye hoga vo lakar dega

    let contentArr=setTool('#maincounter-wrap span') 
         
    //site per jana word per chick karna inspect karke show hoga html per fhir uss jagah id de hogi maincounter per
    //do bar click karna fhir ctrl+f dabana eek terminal khulega niche fhir #maincounter-wrap span ke kar dena bss 
    //vo fhir sare jo jo corona ka data chaheye hoga vo de dega class main se 
    
    //ye loop se haam data html ka dekh sakte hai
    //coronavirus ka
    /*for(let i=0 ;i<contentArr.length ;i++){
        let data=setTool(contentArr[i]).text()
        console.log('data',data)
    }
      */
  

    let TotalCases = setTool(contentArr[0]).text()
    let Totaldeath = setTool(contentArr[1]).text()
    let recovered = setTool(contentArr[2]).text()
 
      console.log('TotalCases',TotalCases)
      console.log('Totaldeath',Totaldeath)
      console.log('TotalCases',recovered)

}


console.log('after')//likh do likhna haai to asyncronous behaviour dekhna hai to