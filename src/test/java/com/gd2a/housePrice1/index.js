//jshint esversion:6

console.log("Hello world");

const {flagToCountry, getFlagsInText} = require('emoji-flags-to-country');

const result1 = flagToCountry('IT');
const result2 = flagToCountry('ES');
const result3 = flagToCountry('US');

console.log(result1);
console.log(result2);
console.log(result3);

const result4 = getFlagsInText("This text has US emoji flags IT");
console.log(result4);


