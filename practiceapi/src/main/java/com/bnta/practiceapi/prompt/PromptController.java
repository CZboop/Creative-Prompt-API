package com.bnta.practiceapi.prompt;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PromptController {

    private PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/all")
    public List<Prompt> getPrompts(){
        return promptService.getPrompts();
    }

    @PostMapping("/add")
    public void addNewPrompt(@RequestBody Prompt prompt){
        promptService.addPrompt(prompt);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrompt(@PathVariable("id") int id){
        promptService.deletePrompt(id);
    }

    @PutMapping("/update/{id}")
    public void updatePrompt(@PathVariable("id") int id, @RequestBody Prompt prompt){
        promptService.updatePrompt(id, prompt);
    }

    @GetMapping("time/{time}")
    public List<Prompt> getByTime(@PathVariable("time") int time){
        return promptService.filterByTime(time);
    }

    @GetMapping("type/{discipline}")
    public List<Prompt> getByDiscipline(@PathVariable("discipline") String discipline){
        return promptService.filterByDiscipline(discipline);
    }

    @GetMapping("type/{discipline}/time/{time}")
    public List<Prompt> getByDiscipline(@PathVariable Map<String, String> pathVariables){
        String discipline = pathVariables.get("discipline");
        int time = Integer.parseInt(pathVariables.get("time"));
        return promptService.filterTimeAndType(discipline, time);
    }

    @GetMapping("/random")
    public Prompt getRandomPrompt(){
        return promptService.getRandomPrompt();
    }

    @GetMapping("/filtered/{time}/{discipline}/{difficulty}")
    public Prompt getFilteredPrompt(@PathVariable("time") int time,
                                    @PathVariable("discipline") String discipline,
                                    @PathVariable("difficulty") int difficulty)
    {return promptService.getFilteredPrompt(time, discipline, difficulty); }
}


