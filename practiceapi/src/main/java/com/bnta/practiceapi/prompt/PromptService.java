package com.bnta.practiceapi.prompt;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PromptService {
    private PromptDAO promptDAO;

    public PromptService(@Qualifier("postgres") PromptDAO promptDAO) {
        this.promptDAO = promptDAO;
    }

    public List<Prompt> getPrompts(){
        return promptDAO.getAllPrompts();
    }

    public void addPrompt(Prompt prompt){promptDAO.addPrompt(prompt);}

    public void deletePrompt(int id){
        promptDAO.deletePrompt(id);
    }

    public void updatePrompt(int id, Prompt prompt){
        promptDAO.updatePrompt(id, prompt);
    }

    public List<Prompt> filterByTime(int time){
        List<Prompt> filtered = promptDAO.getAllPrompts().stream()
                .filter(p -> p.getMinsToComplete()<=time).collect(Collectors.toList());
        return filtered;
    }

    public List<Prompt> filterByDiscipline(String discipline){
        List<Prompt> filtered = promptDAO.getAllPrompts().stream()
                .filter(p -> p.getDiscipline()==discipline).collect(Collectors.toList());
        return filtered;
    }

    public List<Prompt> filterTimeAndType(String discipline, int time){
        List<Prompt> filteredByType = filterByDiscipline(discipline);
        List<Prompt> filteredByBoth = filteredByType.stream()
                .filter(p -> p.getMinsToComplete()<=time).collect(Collectors.toList());
        return filteredByBoth;
    }

    public Prompt getRandomPrompt(){
        List<Prompt> all = promptDAO.getAllPrompts();
        return all.get(new Random().nextInt(all.size()));
    }

    public Prompt getFilteredPrompt(int time,  String discipline, int difficulty){
        List<Prompt> filteredByType = promptDAO.getAllPrompts().stream()
                .filter(p -> p.getDiscipline().equals(discipline)).collect(Collectors.toList());
        System.out.println(filteredByType);
        List<Prompt> filteredByTypeandTime = filteredByType.stream()
                .filter(p -> p.getMinsToComplete()<=time).collect(Collectors.toList());
        List<Prompt> filteredByAllParams = filteredByTypeandTime.stream()
                .filter(p -> p.getDifficulty()<=difficulty).collect(Collectors.toList());
        return filteredByAllParams.get(new Random().nextInt(filteredByAllParams.size()));
    }

}
