import React from "react";
import { useTranslation } from "react-i18next";
import { changeLanguage } from "../api/ApiCall";

const LanguageSelector = (props) => {

  const { i18n } = useTranslation();

  //<======================================================>
  const onchangeLanguage = (language) => {
    i18n.changeLanguage(language);
    changeLanguage(language);
  };
  //<======================================================>
  return (
    <div className="language-container">

      <img
        src="https://www.countryflags.io/tr/flat/24.png"
        alt="TR Flag"
        onClick={() => onchangeLanguage("tr")}
        style={{ cursor: "pointer" }}
      />

      <img
        src="https://www.countryflags.io/us/flat/24.png"
        alt="US Flag"
        onClick={() => onchangeLanguage("en")}
        style={{ cursor: "pointer" }}
      />

    </div>
  );
};

export default LanguageSelector;
