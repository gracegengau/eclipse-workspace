import {React, useEffect, useState} from "react";
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";

function PostcodeCard(props) {
  const [isLoading, setIsLoading] = useState(true);
  const [suburbs, setSuburbs] = useState([]);
  const postcode = props.postcode;

  useEffect( () => {
      const fetchData = async() => {
        const address = 'http://localhost:8080/listSuburbsByPostcode/'+postcode;
        const response = await fetch(address);
        const data = await response.json();
        setSuburbs(data);
      };

      fetchData();

      setIsLoading(false);

  }, []);

  if (isLoading) {
    <h1>loading ...</h1>
  } else {
    return (
      <div className="Card">
      <h1>Postcode {props.postcode}</h1>
      <p>Total {props.listTotal} houses sold </p>
      <p>Highest price: {props.highestPrice}</p>
      <p>Lowest price: {props.lowestPrice}</p>
      <ul>
      {suburbs.map((sub) => (
        <li key={sub.id}>
          <Link to={`/suburbs/${sub.suburb}`}>{sub.suburb}</Link>
        </li>
      ))}
      </ul>
      </div>
    );
  }
}

export default PostcodeCard;
