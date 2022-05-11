import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PostcodePage from "./pages/PostcodePage";
import SuburbPage from "./pages/SuburbPage";
import Header from "./Header";
import Footer from "./Footer";

import './App.css';

function App() {
  return (
    <div className="App">
    <Header />
    <Router>
      <Routes>
        <Route path="/listPostcodes" element={<PostcodePage />} />
      </Routes>
    </Router>
    <Footer />
    </div>
  );
}

export default App;
