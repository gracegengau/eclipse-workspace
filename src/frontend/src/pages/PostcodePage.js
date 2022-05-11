import { React, useEffect, useState } from "react";
import PostcodeCard from "../components/PostcodeCard";
import SearchCard from "../components/SearchCard";

function PostcodePage() {
  const [isLoading, setIsLoading] = useState(true);
  const [postcode, setPostcode] = useState([]);

  useEffect( () => {
    const fetchData = async() => {
      const response = await fetch("http://localhost:8080/listPostcodes");
      const data = await response.json();
      setPostcode(data);
    };

    fetchData();
    setIsLoading(false);

  }, []);

  if (isLoading) {
    <h1>loading ...</h1>
  } else {

    return (
      <div className="PostscodePage">
        <SearchCard />
        {
          postcode.map((ps, index) => {
            return <PostcodeCard
              key = {index}
              postcode = {ps.postcode}
              listTotal = {ps.listTotal}
              highestPrice = {ps.highestPrice}
              lowestPrice = {ps.lowestPrice}
              suburbList = {ps.suburbs} />
        })
      }
      </div>
    );
  }
}

export default PostcodePage;
