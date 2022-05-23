package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNotesUseCase (

    private val repository: NoteRepository

    ) {

        @Throws(InvalidNoteException::class)
        suspend operator fun  invoke(note: Note) {

            if(note.title.isBlank()) {

                throw InvalidNoteException("The title of note cannot be blank.")

            }

            if(note.content.isBlank()) {

                throw InvalidNoteException("The content of note cannot be blank.")

            }

            repository.insertNote(note)

        }




}