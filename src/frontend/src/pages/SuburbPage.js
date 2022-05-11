import { React, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import SuburbCard from "../components/SuburbCard";

function SuburbPage(props) {
  const [suburbs, setSuburb] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async() => {
        const response = await fetch("http://localhost:8080/suburbs/Clayton");
        const data = await response.json();
        setSuburb(data);
        setIsLoading(false);
    }

    fetchData();
  }, []);

  if (isLoading) {
    <h1>loading ...</h1>
  } else {
    console.log(suburbs);

    return (
      <div className="SuburbPage">
      {
        suburbs.map((sb, index) => {
          return <SuburbCard
            key = {index} />
            // streetAddress = {sb.houseSold.streetAddress}
            // bedrooms =
            // bathrooms =
            // price =
            // dateSold =
        })
      }
      </div>
    );
  }
}

export default SuburbPage;
