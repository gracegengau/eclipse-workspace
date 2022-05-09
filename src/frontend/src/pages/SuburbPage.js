import { React, useEffect, useState } from "react";
import BigCard from "../components/BigCard";
import DetailCard from "../components/DetailCard";

function SuburbPage(props) {
  const [suburb, setSuburb] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async() => {
        const response = await fetch("http://localhost:8080/listHousePriceByPostcode");
        const data = await response.json();
        setSuburb(data);
        setIsLoading(false);
    }

    fetchData();
  }, [])

  return (

    <div className="SuburbPage">
      <h1>Suburb Name: {isLoading ? 'loading' : suburb[0].suburb}</h1>
      <BigCard />
      <DetailCard />
      <DetailCard />
      <DetailCard />
    </div>
  );
}

export default SuburbPage;
