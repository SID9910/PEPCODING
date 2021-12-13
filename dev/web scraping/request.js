
//request npm module haam kisi bhi site ka data lene ke ley use karte hai
const request = require('request');



console.log('before')//likh do likhna haai to asyncronous behaviour dekhna hai to


request('https://www.worldometers.info/coronavirus/', cb)

//ye request ka bna banaya function hai site per 
function cb (error, response, html) {
  console.error('error:', error); // Print the error if one occurred
  console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
  console.log('html:', html); // Print the HTML for the Google homepage.
                             //ye html ka data sara console per leke aajaega
}

console.log('after')//likh do likhna haai to asyncronous behaviour dekhna hai to