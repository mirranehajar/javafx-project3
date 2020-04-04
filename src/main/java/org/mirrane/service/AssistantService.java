package org.mirrane.service;

import org.mirrane.dao.AssistantDao;
import org.mirrane.dao.AssistantDaoImp;
import org.mirrane.entity.Assistant;
import org.mirrane.entity.Patient;

import java.util.List;

public class AssistantService {
    AssistantDao assistantDao;
    public AssistantService(){
        this.assistantDao = new AssistantDaoImp();
    }

    public void addAssistant(Assistant assistant) {
        assistantDao.addAssistant(assistant);
    }

    public List<Assistant> getAssistants() {
        return assistantDao.getAssistants();
    }

    public Assistant getAssistant(Integer id) {
        Assistant assistant;

        if (assistantDao.isPresent(id)) {
            assistant = assistantDao.getAssistant(id);
        } else {
            assistant = new Assistant("0","0","0","0",0,"0","not found");
        }

        return assistant;
    }

    public void updateAssistant(Assistant assistant) {
        if (assistantDao.isPresent(assistant.getId())) {
            assistantDao.updateAssistant(assistant);
        } else {
            assistantDao.addAssistant(assistant);
        }
    }

    public void deleteAssistant(Integer id) {
        Assistant assistant = getAssistant(id);
        if (!assistant.getId().equals(0)){
            assistantDao.deleteAssistant(assistant);
        }
    }

    public boolean isPresent(int id) {
        return assistantDao.isPresent(id);
    }
}
