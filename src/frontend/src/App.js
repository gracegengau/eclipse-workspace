import { React, useEffect, useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PostcodePage from "./pages/PostcodePage";
import SuburbPage from "./pages/SuburbPage";
import Header from "./Header";
import Footer from "./Footer";

import './App.css';

function App() {
  const [isLoading, setIsLoading] = useState(true);
  const [suburbs, setSuburbs] = useState([]);

  useEffect( () => {
    const fetchData = async() => {
      const response = await fetch("http://localhost:8080/listSuburbs");
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
      <div className="App">
      <Header />
      <Router>
        <Routes>
          <Route path="/" element={<PostcodePage />} />
          <Route path="suburbs" element={<SuburbPage suburb={suburbs} />}>
          <Route path=":suburb" element={<SuburbPage />} />
          </Route>

        </Routes>
      </Router>
      <Footer />
      </div>
    );
  }
}

export default App;
