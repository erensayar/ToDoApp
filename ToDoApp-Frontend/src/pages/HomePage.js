import React from 'react';
import NoteList from '../components/NoteList';
import Note from '../components/Note';

const HomePage = () => {

    return (
        <div className="row">
            <div className="col-3">
                <NoteList />
            </div>
            <div className="col-9">
                <Note />
            </div>
        </div>
    );
};

export default HomePage;