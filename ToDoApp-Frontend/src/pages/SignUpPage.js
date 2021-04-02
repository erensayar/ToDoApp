import React, { useState } from "react";
import Input from "../components/Input";
import { useTranslation } from "react-i18next";
import { withApiProgress } from '../shared/ApiProgress';
import { useDispatch } from 'react-redux';
import { signupHandler } from '../redux/AuthActions';
import ButtonWithProgress from "../components/ButtonWithProgress";

const SignUpPage = (props) => {

  //<======================================================>
  const [form, setForm] = useState({
    username: null,
    password: null,
    passwordRepeat: null,
  });

  const [validationFieldsErrors, setValidationFieldsErrors] = useState({});

  const dispatch = useDispatch();  // Dispatchi proptan almak yerine hook ile aldik.
  //<======================================================>
  const onChange = (event) => {
    const { name, value } = event.target;

    // Degisimlerde gorunen errorun yok olmasi icin.
    setValidationFieldsErrors((previousErrors) => ({ ...previousErrors, [name]: undefined }));
    setForm((previousForm) => ({ ...previousForm, [name]: value }));
  };
  //<======================================================>
  const onClickSignup = async (event) => {
    event.preventDefault();

    const { history } = props;
    const { push } = history;
    const { username, password } = form;

    const body = {
      username,
      password
    }

    try {
      await dispatch(signupHandler(body));
      push('/');
    } catch (error) {
      if (error.response.data.validationFieldsErrors) {
        setValidationFieldsErrors(error.response.data.validationFieldsErrors);
      }
    }

  }
  //<======================================================>

  const { username: usernameError, password: passwordError } = validationFieldsErrors;
  const { pendingApiCall } = props;
  const { t } = useTranslation();

  let passwordRepeatError;
  if (form.password !== form.passwordRepeat) {
    passwordRepeatError = t('Password mismatch');
  }

  return (

    <div className="form-container">
      <form>

        <h1 className="text-center">{t('Sign Up')}</h1>

        <Input name="username" label={t("User Name")} error={usernameError} onChange={onChange} />
        <Input name="password" label={t("Password")} error={passwordError} onChange={onChange} type="password" />
        <Input name="passwordRepeat" label={t("Password Repeat")} error={passwordRepeatError} onChange={onChange} type="password" />

        <div className="text-center">
          <ButtonWithProgress
            onClick={onClickSignup}
            disabled={pendingApiCall || passwordRepeatError !== undefined}
            pendingApiCall={pendingApiCall}
            text={t('Sign Up')} />
        </div>

      </form>
    </div>
  );
}

const SignupPageWithApiProgressForSignupRequest = withApiProgress(SignUpPage, '/api/addUser');
const SignupPageWithApiProgressForAuthRequest = withApiProgress(SignupPageWithApiProgressForSignupRequest, '/api/auth');

export default SignupPageWithApiProgressForAuthRequest;