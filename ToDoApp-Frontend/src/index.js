import React from 'react';
import ReactDOM from 'react-dom';
import App from "./container/App";
import reportWebVitals from './reportWebVitals';
import "./i18n";
import './style/index.css';
import "./style/bootstrap-override.scss";
import "./style/form-container.scss";
import "./style/scroll-bar.scss";
import { Provider } from "react-redux";
import configureStore from "./redux/ConfigureStore";

const store = configureStore();

ReactDOM.render(
  <Provider store={store}>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </Provider>,
  document.getElementById("root")
);

reportWebVitals();
