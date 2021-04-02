import { createStore, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';
import authReducer from "./AuthReducer";
import SecureLS from "secure-ls";

const secureLs = new SecureLS();

const getStateFromStorage = () => {
  const todoAuth = secureLs.get("todo-auth");

  let stateInLocalStorage = {
    isLoggedIn: false,
    username: undefined,
    password: undefined,
  };

  if (todoAuth) {
    return todoAuth;
  }
  return stateInLocalStorage;
};

const updateStateInStorage = (newState) => {
  secureLs.set("todo-auth", newState);
};

const configureStore = () => {

  const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
  const store = createStore(authReducer, getStateFromStorage(), composeEnhancers(applyMiddleware(thunk)));

  store.subscribe(() => {
    updateStateInStorage(store.getState());
  });

  return store;
};

export default configureStore;