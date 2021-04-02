import React from "react";
import logo from "../assets/writing.png";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";
import { useDispatch, useSelector } from 'react-redux';
import { logoutSuccessAction } from "../redux/AuthActions";

const TopBar = (props) => {

  //<======================================================>
  // Translation Hook
  const { t } = useTranslation();

  // Redux Prop Hook
  const { username, isLoggedIn } = useSelector(store => ({
    username: store.username,
    isLoggedIn: store.isLoggedIn
  }));

  //Redux Dispatch Hook
  const dispatch = useDispatch();
  const onLogoutSuccess = () => {
    dispatch(logoutSuccessAction());
  }
  //<======================================================>

  let navBarOptions = (
    <ul className="navbar-nav ml-auto">
      <li> <Link className="nav-link" to="/login">{t("Login")}</Link></li>
      <li> <Link className="nav-link" to="/signup">{t("Sign Up")}</Link></li>
    </ul>
  )

  if (isLoggedIn) {
    navBarOptions = (
      <ul className="navbar-nav ml-auto">
        <li> <Link className="nav-link" to="/">{username}</Link></li>
        <li className="nav-link" onClick={onLogoutSuccess} style={{ cursor: "pointer" }}>{t("Logout")}</li>
      </ul>
    )
  }

  return (
    
    <div className="top-bar">
      <div className="shadow-sm">
        <nav className="navbar navbar-light navbar-expand">
          <Link className="navbar-brand" to="/"> <img src={logo} width="45" alt="ToDo App Logo" /> To Do </Link>
          {navBarOptions}
        </nav>
      </div>
    </div>
  );
}

export default TopBar;