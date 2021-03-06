package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Doctor;

import java.util.List;

public interface AssistantDao {
   int addAssistant(Assistant assistant);
    List<Assistant> getAssistants();
    Assistant getAssistant(Integer id);
    Assistant getAssistantByCin(String cin);
    Assistant getAssistantByMail(String mail);
    void updateAssistant(Assistant assistant);
    void deleteAssistant(Assistant assistant);
    boolean isPresent(int id);
}
