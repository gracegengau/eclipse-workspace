import {React, useEffect, useState} from "react";
import SuburbPage from "../pages/SuburbPage";

function PostcodeCard(props) {
  function toSuburbPage() {
    
    return <SuburbPage />
  }

  return (
    <div className="PostcodeCard">
    <h1>Postcode {props.postcode}</h1>
    <p>Total {props.listTotal} houses sold </p>
    <p>Highest price: {props.highestPrice}</p>
    <p>Lowest price: {props.lowestPrice}</p>
    <button onClick={toSuburbPage}>Suburbs</button>
    </div>
  );
}

export default PostcodeCard;
