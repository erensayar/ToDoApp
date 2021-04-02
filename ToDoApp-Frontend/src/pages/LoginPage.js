import React, { useState, useEffect } from 'react';
import Input from "../components/Input";
import { useTranslation } from "react-i18next";
import { withApiProgress } from '../shared/ApiProgress';
import { useDispatch } from 'react-redux';
import { loginHandler } from '../redux/AuthActions';
import ButtonWithProgress from "../components/ButtonWithProgress";

const LoginPage = (props) => {

  //<======================================================>
  // Redux Hooks ile proplari aldik.
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const [error, setError] = useState();

  // Gorunen errorun degisimlerde yok olmasi icin hooks metodu.
  useEffect(() => {
    setError(undefined);
  }, [username, password]);

  // Redux dispatch kullanmak icin proptan almak yerine hook ile aldık. Basta tanimlanmali.
  const dispatch = useDispatch();
  //<======================================================>

  const onClickLogin = async (event) => {
    event.preventDefault();

    const creds = {
      username,
      password,
    };

    const { history } = props;
    const { push } = history;

    setError(undefined);

    try {
      await dispatch(loginHandler(creds));
      push("/");

    } catch (apiError) {
      setError(apiError.response.data.message);
    }

  };
  //<======================================================>
  const { t } = useTranslation();
  const { pendingApiCall } = props;
  const buttonEnabled = username && password;

  return (
    <div className="form-container">
      <form>

        <h1 className="text-center">{t("Login")}</h1>

        <Input label={t("User Name")} onChange={event => setUsername(event.target.value)} />
        <Input label={t("Password")} type="password" onChange={event => setPassword(event.target.value)} />

        {error && <div className="alert alert-danger">{error}</div>}

        <div className="text-center">
          <ButtonWithProgress onClick={onClickLogin} disabled={!buttonEnabled || pendingApiCall} pendingApiCall={pendingApiCall} text={t('Login')} />
        </div>

      </form>
    </div>
  );
}


const LoginPageWithApiProgress = withApiProgress(LoginPage, "/api/auth");

export default LoginPageWithApiProgress;

