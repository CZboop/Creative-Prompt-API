package com.bnta.practiceapi.prompt;

import java.util.List;

public interface PromptDAO {
    List<Prompt> getAllPrompts();

    int addPrompt(Prompt prompt);

    int deletePrompt(int id);

    int updatePrompt(int id, Prompt prompt);
}
