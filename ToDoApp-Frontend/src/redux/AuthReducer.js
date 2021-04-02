import * as ACTIONS from "./Constants";

const loggedOutState = {  //default state
  isLoggedIn: false,
  username: undefined,
  password: undefined,
};

// ...loggedOutState ile baslangic degeri ayarlandi.
const authReducer = (state = { ...loggedOutState }, action) => {
  
  if (action.type === ACTIONS.LOGOUT_SUCCESS) {
    return loggedOutState;
  } 

  else if (action.type === ACTIONS.LOGIN_SUCCESS) {
    return {
      ...action.payload,
      isLoggedIn: true
    };
  }
  
  return state;
};

export default authReducer;
