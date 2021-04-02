import i18n from "i18next";
import { initReactI18next } from "react-i18next";

i18n.use(initReactI18next).init({
  resources: {
    en: {
      translations: {
        "Sign Up": "Sign Up",
        "Login" : "Login",
        "Password Mismatch": "Password Mismatch!",
        "User Name" : "User Name",
        "Password" : "Password",
        "Password Repeat" : "Password Repeat",
        "Logout" : "Logout",
        "Note Create Date": "Note Create Date",
        "Note Target Date": "Note Target Date",
        "Note Title": "Note Title",
        "New": "New",
        "Save": "Save",
      },
    },
    tr: {
      translations: {
        "Sign Up": "Kayıt Ol",
        "Login" : "Giriş",
        "Password Mismatch": "Şifre Uyuşmazlığı!",
        "User Name" : "Kullanıcı Adı",
        "Password" : "Şifre",
        "Password Repeat" : "Şifre Tekrarı",
        "Logout" : "Çıkış",
        "Note Create Date": "Not Kayıt Tarihi",
        "Note Target Date": "Not Hedef Tarihi",
        "Note Title": "Not Başlığı",
        "New": "Yeni",
        "Save": "Kaydet",
      },
    },
  },
  fallbackLng: "tr",
  ns: ["translations"],
  defaultNS: "translations",
  keySeparator: false,
  interpolation: {
    escapeValue: false,
    formatSeparator: ",",
  },
  react: {
    wait: true,
  },
});

export default i18n;
