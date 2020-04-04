package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Doctor;

import java.util.List;

public interface AssistantDao {
   void addAssistant(Assistant assistant);
    List<Assistant> getAssistants();
    Assistant getAssistant(Integer id);
    void updateAssistant(Assistant assistant);
    void deleteAssistant(Assistant assistant);
    boolean isPresent(int id);
}
