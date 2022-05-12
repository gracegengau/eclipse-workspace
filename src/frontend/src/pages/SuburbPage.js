import { React, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import HouseCard from "../components/HouseCard";

function SuburbPage() {
  //need to specify the structure of suburbDetails, otherwise state updates to null
  const state = {
      id: 0,
      suburb: "",
      postcode: {},
      postcodeid: 0,
      houseSold: []
  }

  const {suburb} = useParams();
  const [isLoading, setIsLoading] = useState(true);
  const [suburbDetails, setSuburbDetails] = useState(state);

  useEffect( () => {
      const fetchData = async() => {
        const address = 'http://localhost:8080/suburbs/'+suburb;
        const response = await fetch(address);
        const data = await response.json();
        setSuburbDetails(data);
      };

      fetchData();
      setIsLoading(false);
  }, []);

  if (isLoading) {
    <h1>loading ...</h1>
  } else {
    const houseSold = suburbDetails.houseSold;

    return (
      <div className="Page">
        {
            houseSold.map((house, index) => {
            return <HouseCard
              key = {index}
              streetAddress = {house.streetAddress}
              bedrooms = {house.bedrooms}
              bathrooms = {house.bathrooms}
              price = {house.price}
              dateSold = {house.dateSold}/>
            })
          }
      </div>
    );
  }
}

export default SuburbPage;
