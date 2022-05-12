import {React, useEffect, useState} from "react";

function HouseCard(props) {
  return (
    <div className="Card">
      <p>{props.streetAddress}</p>
      <p>{props.bedrooms} bedrooms, {props.bathrooms} bathrooms</p>
      <p>Sold for {props.price}</p>
      <p>on {props.dateSold}</p>
    </div>
  )
}

export default HouseCard;
