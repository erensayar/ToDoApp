import React, { useState, useEffect } from 'react';
import { getAllNoteJustNoteNameAndId } from '../api/ApiCall';
import "../style/list-container.scss";
import DeleteButton from './DeleteButton';


const List = () => {

    const [notesNameAndId, setnotesNameAndId] = useState([]);

    useEffect(() => { getNotesNameAndId(); }, []);

    const getNotesNameAndId = async () => {
        try {
            const response = await getAllNoteJustNoteNameAndId();
            setnotesNameAndId(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    //const onDeleteNote = () => {
    //    alert("delete");
    //}
    //
    //const onOpenNote = () => {
    //    alert("openNote");
    //}
    return (

        <div className="list-container">
            <ul className="list-group">
                {notesNameAndId.map(
                    (notesNameAndId) => (
                        <li key={notesNameAndId.id} className="list-group-item" id="list-card" >
                            <div>{notesNameAndId.noteName}</div>
                            <DeleteButton />
                        </li>
                    )
                )}

            </ul>
        </div>

    );
};

export default List;
