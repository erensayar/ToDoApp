import React from "react";
import { HashRouter as Router, Route, Redirect, Switch } from "react-router-dom";
import { useSelector } from 'react-redux';
import SignUpPage from "../pages/SignUpPage";
import LoginPage from "../pages/LoginPage";
import HomePage from "../pages/HomePage";
import TopBar from '../components/TopBar';
import LanguageSelector from '../components/LanguageSelector';
import '../style/App.css';
import "../style/footer.scss";

const App = () => {

  const { isLoggedIn } = useSelector(store => ({
    isLoggedIn: store.isLoggedIn
  }));

  return (
    <div>
      <Router>
        <TopBar />
        <Switch>
          {isLoggedIn && <Route exact path="/" component={HomePage} />}
          {!isLoggedIn && <Route path="/login" component={LoginPage} />}
          <Route path="/signup" component={SignUpPage} />
          <Redirect to="/login" />
        </Switch>
      </Router>
      <footer>
        <LanguageSelector />
      </footer>
    </div>
  );
}

export default App;
