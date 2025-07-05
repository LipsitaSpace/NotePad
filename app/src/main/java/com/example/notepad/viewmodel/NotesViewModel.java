package com.example.notepad.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notepad.model.Items;

import java.util.ArrayList;
import java.util.List;

public class NotesViewModel extends ViewModel {
    private MutableLiveData<List<Items>> itemList;
    public LiveData<List<Items>> getTaskList() {
            if (itemList == null) {
                itemList = new MutableLiveData<>();
                loadTasks();
            }
            return itemList;
        }

        private void loadTasks() {
            List<Items> items = new ArrayList<>();
            items.add(new Items("Meeting", "Project discussion", "2025-07-05", "10:00 AM"));
            items.add(new Items("Workout", "Gym session", "2025-07-06", "6:00 PM"));
            items.add(new Items("Groceries", "Buy essentials", "2025-07-07", "4:00 PM"));
            items.add(new Items("Doctor Appointment", "Regular health checkup", "2025-07-08", "11:30 AM"));
            items.add(new Items("Call with Client", "Discuss project milestones", "2025-07-09", "2:00 PM"));
            items.add(new Items("Team Meeting", "Sprint planning session", "2025-07-10", "9:00 AM"));
            items.add(new Items("Lunch with Friend", "Catch-up over lunch", "2025-07-11", "1:00 PM"));
            items.add(new Items("Shopping", "Buy new clothes and accessories", "2025-07-12", "5:00 PM"));
            items.add(new Items("Yoga Class", "Evening relaxation session", "2025-07-13", "6:30 PM"));
            items.add(new Items("Car Service", "Routine vehicle maintenance", "2025-07-14", "10:00 AM"));
            items.add(new Items("Parent-Teacher Meeting", "Discuss academic progress", "2025-07-15", "3:00 PM"));
            items.add(new Items("Flight to Delhi", "Business trip", "2025-07-16", "8:00 AM"));
            items.add(new Items("Anniversary Dinner", "Dinner reservation at restaurant", "2025-07-17", "7:30 PM"));

            itemList.setValue(items);
        }

}
