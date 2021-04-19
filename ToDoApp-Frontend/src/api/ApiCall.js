import axios from "axios";

export const changeLanguage = (language) => {
  axios.defaults.headers["accept-languge"] = language;
};

export const signup = (body) => {
  return axios.post("/api/addUser", body);
};

export const login = (creds) => {
  return axios.post("/api/auth", {}, { auth: creds });
};

export const deleteNote = (id) => {
  return axios.delete("/api/deleteNote/" + id);
}

export const getNote = (id) => {
  return axios.get("api/getNote/" + id);
}

export const getAllNote = () => {
  return axios.get("api/getAllNote");
}

export const getAllNoteJustNoteNameAndId = (creds) => {
  return axios.get("api/getAllNoteJustNoteNameAndId",{}, { auth: creds });
}

export const getUser = (id) => {
  return axios.get("api/getUser/" + id);
}

