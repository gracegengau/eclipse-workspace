import React, { useState } from "react";

function SearchCard() {
  const [searchPostcode, setSearchPostcode] = useState("");

  function handleChange(event) {
    const newSearch = event.target.value;
    setSearchPostcode(newSearch);
  }

  function submitSearch(event) {
  }

  return (
    <div>
      <form>
        <input
          onChange={handleChange}
          value={searchPostcode}
          placeholder="Postcode "
        />
        <button onClick={submitSearch}>Search</button>
      </form>
    </div>
  );
}

export default SearchCard;
