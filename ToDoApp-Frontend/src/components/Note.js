import React from "react";
import { useTranslation } from "react-i18next";
import "../style/note-container.scss";

const Note = () => {

    const { t } = useTranslation();


    return (
        <div className="note-container">
            <div className="container">

                <div className="row">
                    <div className="note-create-date col-6">
                        {t("Note Create Date")} : <b>26.03.2021</b>
                    </div>
                    <div className="note-target-date col-6">
                        {t("Note Target Date")} : <b>02.04.2021</b>
                    </div>
                </div>

                <div className="row">
                    <div className="note-title col-12">
                        {t("Note Title")} : <b>Delivery</b>
                    </div>
                </div>

                <div className="note-text-area row">
                    <textarea>
                        1. Heroku
                        2. You can create Dockerized project and push your project into Docker
                        Hub.
                        Your project should include a Readme file with simple instructions to:
                        1. Build your app
                        2. Run the test suite
                        3. Run your app with dependencies
                    </textarea>
                </div>
            </div>

            <footer className="note-footer">
                <button className="btn btn-sm btn-secondary">
                    <svg width="16" height="16" fill="currentColor" className="bi bi-file-earmark-plus-fill" viewBox="0 0 16 16">
                        <path d="M9.293 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.707A1 1 0 0 0 13.707 4L10 .293A1 1 0 0 0 9.293 0zM9.5 3.5v-2l3 3h-2a1 1 0 0 1-1-1zM8.5 7v1.5H10a.5.5 0 0 1 0 1H8.5V11a.5.5 0 0 1-1 0V9.5H6a.5.5 0 0 1 0-1h1.5V7a.5.5 0 0 1 1 0z" />
                    </svg>
                    <label>{t("New")}</label>
                </button>

                <button className="btn btn-sm btn-success ml-auto">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-save" viewBox="0 0 16 16">
                        <path d="M2 1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9.5a1 1 0 0 0-1 1v7.293l2.646-2.647a.5.5 0 0 1 .708.708l-3.5 3.5a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L7.5 9.293V2a2 2 0 0 1 2-2H14a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h2.5a.5.5 0 0 1 0 1H2z" />
                    </svg>
                    <label>{t("Save")}</label>
                </button>

            </footer>
        </div>

    );
};

export default Note;
