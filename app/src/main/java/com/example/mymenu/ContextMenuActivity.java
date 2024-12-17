package com.example.mymenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContextMenuActivity extends AppCompatActivity {

    private ArrayList<String> notesList;  // List to hold notes
    private ArrayAdapter<String> notesAdapter;  // Adapter to display notes in ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menu);

        // Initialize the ListView and ArrayList
        ListView notesListView = findViewById(R.id.notes_list);
        notesList = new ArrayList<>();
        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(notesAdapter);

        // Register the ListView for context menu
        registerForContextMenu(notesListView);

        // Set an item click listener for the ListView to handle note interactions
        notesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedNote = notesList.get(position);
            Toast.makeText(this, "Note: " + selectedNote, Toast.LENGTH_SHORT).show();
        });
    }

    // Inflate the menu in the ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_note, menu);  // Inflate the menu with the add note button
        return true;
    }

    // Handle item selection from the ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_add_note) {
            showAddNoteDialog(); // Call the method to add a new note
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Show Add Note dialog to allow the user to create a new note
    private void showAddNoteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add New Note");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Add", (dialog, which) -> {
            String newNote = input.getText().toString();
            if (!newNote.isEmpty()) {
                notesList.add(newNote);  // Add the new note to the list
                notesAdapter.notifyDataSetChanged();  // Update the ListView
                Toast.makeText(this, "New note added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    // Show Edit dialog to allow the user to edit the note
    private void showEditDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Note");
        final EditText input = new EditText(this);
        input.setText(notesList.get(position));  // Pre-fill the EditText with current text
        builder.setView(input);
        builder.setPositiveButton("Save", (dialog, which) -> {
            String updatedText = input.getText().toString();
            notesList.set(position, updatedText);  // Update the note at the given position
            notesAdapter.notifyDataSetChanged();  // Refresh the ListView
            Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    // Show Delete confirmation dialog
    private void showDeleteConfirmationDialog(final int position) {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to delete this note?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    notesList.remove(position);  // Remove the note from the list
                    notesAdapter.notifyDataSetChanged();  // Update the ListView
                    Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", null)
                .show();
    }

    // Handle context menu interactions
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);  // Inflate the context menu
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        assert info != null;
        int position = info.position;  // Get the selected item's position

        int itemId = item.getItemId();

        if (itemId == R.id.context_edit) {
            showEditDialog(position);  // Edit the selected note
            return true;
        } else if (itemId == R.id.context_share) {
            shareContent(position);  // Share the selected note
            return true;
        } else if (itemId == R.id.context_delete) {
            showDeleteConfirmationDialog(position);  // Delete the selected note
            return true;
        } else {
            return super.onContextItemSelected(item); // Default case
        }
    }

    // Share content via external apps
    private void shareContent(int position) {
        String noteToShare = notesList.get(position);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, noteToShare);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
